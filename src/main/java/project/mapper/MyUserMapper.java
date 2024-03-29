package project.mapper;

import project.entity.MyUser;
import project.rest.model.MyUserDTO;

public class MyUserMapper {

    public static MyUser fromDtoToEntity(MyUserDTO myUserDTO) {
        return new MyUser(myUserDTO.getUsername(), myUserDTO.getPassword(), myUserDTO.isAccountNonExpired(),
                myUserDTO.isAccountNonLocked(), myUserDTO.isCredentialsNonExpired(), myUserDTO.isEnabled(),
                myUserDTO.getFullName(), myUserDTO.getEmail(), myUserDTO.getRoles(), myUserDTO.getPasswordConfirm());
    }

    public static MyUserDTO fromEntityToDTO(MyUser myUser) {
        return new MyUserDTO(myUser.getId(), myUser.getUsername(), myUser.getFullName(), myUser.getEmail());
    }

}
