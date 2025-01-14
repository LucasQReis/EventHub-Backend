package com.api.EventHub.service;

import java.sql.Date;
import java.time.LocalDate;
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
        User user = new User();
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail()); // O Spring já vai validar isso automaticamente
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setLevelAcess(userDto.getLevelAcess());
        user.setIeStatus(userDto.getIeStatus());

        // Configurando a data de criação automaticamente
        if (userDto.getDateCreateAcount() == null) {
            user.setDateCreateAcount(Date.valueOf(LocalDate.now()));
        } else {
            user.setDateCreateAcount(userDto.getDateCreateAcount());
        }

        User savedUser = userRepository.save(user);
        return new UserDto(
                savedUser.getUserId(), savedUser.getName(), savedUser.getLastname(), savedUser.getDateCreateAcount(),
                savedUser.getEmail(), savedUser.getPhone(), savedUser.getPassword(), savedUser.getLevelAcess(),
                savedUser.getDateCreateAcount(), savedUser.getIeStatus());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setName(userDto.getName()); // Change the E-mail field
            user.setLastname(userDto.getLastname()); // Change the E-mail field

            userRepository.save(user); // Save changes

            return modelMapper.map(user, UserDto.class);
        } else {
            return null;
        }
    }
}
