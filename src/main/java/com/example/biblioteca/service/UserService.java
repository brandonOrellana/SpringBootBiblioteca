package com.example.biblioteca.service;

import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.model.common.UserStatus;
import com.example.biblioteca.model.entity.User;
import com.example.biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserDto userDto){
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(UUID.randomUUID().toString());
        newUser.setUserStatus(UserStatus.PENDING);
        userRepository.save(newUser);
    }

    public UserDto readUserByUsername(String username){
        Optional<User> userByUsername = userRepository.findUsersByUsername(username);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userByUsername.get(),userDto);
        return userDto;
    }
}
