package com.api.EventHub.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.EventHub.model.dto.UserDto;
import com.api.EventHub.model.entity.User;
import com.api.EventHub.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return modelMapper.map(user, UserDto.class);
        } else {
            return null;
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        user.setDateCreateAcount(
                Optional.ofNullable(userDto.getDateCreateAcount())
                        .orElse(Date.valueOf(LocalDate.now()))
        );

        userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user = modelMapper.map(userDto, User.class);
            userRepository.save(user);
            return modelMapper.map(user, UserDto.class);
        } else {
            return null;
        }
    }
}
