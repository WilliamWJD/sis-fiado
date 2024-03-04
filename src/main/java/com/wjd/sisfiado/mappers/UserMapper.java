package com.wjd.sisfiado.mappers;

import com.wjd.sisfiado.domain.Role;
import com.wjd.sisfiado.domain.User;
import com.wjd.sisfiado.dto.RoleDto;
import com.wjd.sisfiado.dto.UserInputDto;
import com.wjd.sisfiado.dto.UserOutputDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final RoleMapper roleMapper;

    public UserMapper(final RoleMapper roleMapper){
        this.roleMapper = roleMapper;
    }

    public User userInputDtoForUserEntity(final UserInputDto userInputDto) {
        User user = new User();
        if(userInputDto.getId() != null){
            user.setId(userInputDto.getId());
        }
        user.setName(userInputDto.getName());
        user.setEmail(userInputDto.getEmail());
        user.setPassword(userInputDto.getPassword());
        user.setAvatarUrl(userInputDto.getAvatarUrl());

        for(RoleDto roleDto: userInputDto.getRoles()){
            Role role = roleMapper.roleDtoForRoleEntity(roleDto);
            user.getRoles().add(role);
        }

        return user;
    }

    public UserOutputDto userEntityForUserOutputDto(final User user){
        return new UserOutputDto(user.getId(), user.getName(), user.getEmail(), user.getAvatarUrl());
    }
}
