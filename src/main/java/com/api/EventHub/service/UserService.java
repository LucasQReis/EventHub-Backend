package com.api.EventHub.service;

import java.util.List;

import com.api.EventHub.model.dto.UserDto;

public interface UserService {
            // get all User
    public List<UserDto> getAllUser();
    // get User by id
    public UserDto getUserById(Long id);
    // create a new user
    public UserDto createUser(UserDto userDto);
    // update User
    public UserDto updateUser(Long userId, UserDto userDto);
    // delete User
    public UserDto deleteUser(Long userId);

    // TODO search event by filter
    // TODO change event status
    // TODO list all events participants
    // TODO create a review of the given event
}
