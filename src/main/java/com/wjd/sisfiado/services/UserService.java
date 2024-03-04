package com.wjd.sisfiado.services;

import com.wjd.sisfiado.dto.UserInputDto;
import com.wjd.sisfiado.dto.UserOutputDto;

public interface UserService {
    UserOutputDto save(final UserInputDto userInputDto);
}
