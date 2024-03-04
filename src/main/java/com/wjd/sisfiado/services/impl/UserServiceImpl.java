package com.wjd.sisfiado.services.impl;

import com.wjd.sisfiado.domain.User;
import com.wjd.sisfiado.dto.UserInputDto;
import com.wjd.sisfiado.dto.UserOutputDto;
import com.wjd.sisfiado.mappers.UserMapper;
import com.wjd.sisfiado.repositories.UserRepository;
import com.wjd.sisfiado.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(final UserRepository userRepository, final UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserOutputDto save(UserInputDto userInputDto) {
        User user = userMapper.userInputDtoForUserEntity(userInputDto);
        return userMapper.userEntityForUserOutputDto(userRepository.save(user));
    }
}