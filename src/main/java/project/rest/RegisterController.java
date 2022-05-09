package project.rest;

import project.entity.MyUser;
import project.entity.Role;
import project.exeptions.AlreadyExists;
import project.mapper.MyUserMapper;
import project.repository.UserRepository;
import project.rest.model.MyUserDTO;
import project.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        MyUser user = new MyUser();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(false);

        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(@ModelAttribute("user") @RequestBody MyUserDTO myUserDTO) throws Exception {

        if (myUserDTO.getPassword().equals(myUserDTO.getPasswordConfirm())) {
            myUserDTO.setRoles(Set.of(new Role("ROLE_USER")));

            if (emailExists(myUserDTO.getEmail())) {
                throw new AlreadyExists("Account with this email address already exists: " + myUserDTO.getEmail());
            }

            MyUserMapper.fromEntityToDTO(userService.saveUser(MyUserMapper.fromDtoToEntity(myUserDTO)));
            return "register-success";
        } else {
            return "register";
        }
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }
}
