package project.service.user.impl;

import project.entity.MyUser;
import project.entity.Role;
import project.repository.RoleRepository;
import project.repository.UserRepository;
import project.service.email.BodyBuilderService;
import project.service.email.EmailSender;
import project.service.token.RandomTokenService;
import project.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    BodyBuilderService bodyBuilderService;

    @Autowired
    EmailSender emailSender;

    @Autowired
    RandomTokenService randomTokenService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public MyUser findUserByUserName(String userName) {
        return userRepository.findByUsernameIgnoreCase(userName);
    }

    public MyUser findUserByRandomToken(String randomToken) {
        return userRepository.findByRandomToken(randomToken);
    }

    public MyUser saveUser(MyUser u) {
        MyUser user = new MyUser(u);
        user.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
        user.setRandomToken(randomTokenService.randomToken(u));
        emailSender.sendEmail(user.getEmail(), "Activate your Account", bodyBuilderService.emailBody(user));
        u.getRoles().forEach(role -> {
            final Role roleByName = roleRepository.findByName(role.getName());
            if (roleByName == null)
                user.getRoles().add(roleRepository.save(role));
            else {
                role.setId(roleByName.getId());
            }
        });
        return userRepository.save(user);
    }
}
