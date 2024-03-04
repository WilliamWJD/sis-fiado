package com.wjd.sisfiado.mappers;

import com.wjd.sisfiado.domain.User;
import com.wjd.sisfiado.dto.UserInputDto;
import com.wjd.sisfiado.dto.UserOutputDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userInputDtoForUserEntity(final UserInputDto userInputDto) {
        return new User(null, userInputDto.getName(), userInputDto.getEmail(), userInputDto.getPassword(), userInputDto.getPassword());
    }

    public UserOutputDto userEntityForUserOutputDto(final User user){
        return new UserOutputDto(user.getId(), user.getName(), user.getEmail(), user.getAvatarUrl());
    }
}
