package com.wjd.sisfiado.services;

import com.wjd.sisfiado.dto.UserInputDto;
import com.wjd.sisfiado.dto.UserOutputDto;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Save user output dto.
     *
     * @param userInputDto the user input dto
     * @return the user output dto
     */
    UserOutputDto save(final UserInputDto userInputDto);

    /**
     * Find by id user output dto.
     *
     * @param id the id
     * @return the user output dto
     */
    UserOutputDto findById(final Long id);

    /**
     * Update user output dto.
     *
     * @param userInputDto the user input dto
     * @return the user output dto
     */
    UserOutputDto update(final UserInputDto userInputDto);

    /**
     * Update avatar.
     *
     * @param avatarUrl the avatar url
     */
    void updateAvatar(final String avatarUrl, final Long id);
}
