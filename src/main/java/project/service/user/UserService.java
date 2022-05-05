package project.service.user;

import project.entity.MyUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    MyUser findUserByUserName(String username);

    MyUser findUserByRandomToken(String randomToken);

    MyUser saveUser(MyUser u);
}
