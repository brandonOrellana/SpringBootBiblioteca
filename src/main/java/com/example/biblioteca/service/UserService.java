package com.example.biblioteca.service;

import com.example.biblioteca.client.InstantWebToolsApiClient;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.exception.EntityNotFoundException;
import com.example.biblioteca.exception.UserAlreadyRegisteredException;
import com.example.biblioteca.exception.config.GlobalErrorCode;
import com.example.biblioteca.model.common.UserStatus;
import com.example.biblioteca.model.entity.UserEntity;
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
    private final InstantWebToolsApiClient instantWebToolsApiClient;

    public void createUser(UserDto userDto){
        Optional<UserEntity> userEntitiesByUsername = userRepository.findUserEntitiesByUsername(userDto.getUsername());
        if(userEntitiesByUsername.isPresent()){
            throw new UserAlreadyRegisteredException("user already registered under given username", GlobalErrorCode.ERROR_USER_ALREADY_REGISTERED);
        }
        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setUsername(userDto.getUsername());
        newUserEntity.setPassword(UUID.randomUUID().toString());
        newUserEntity.setUserStatus(UserStatus.PENDING);
        newUserEntity.setAirlineId(userDto.getAirlineId());
        userRepository.save(newUserEntity);
    }

    public UserDto readUserByUsername(String username){
        UserEntity userEntity = userRepository.findUserEntitiesByUsername(username).orElseThrow(EntityNotFoundException::new);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity,userDto);
        userDto.setAirlineId(readAirline(userDto.getAirlineId()));
        return userDto;
    }

    public String readAirline(String id){
        return instantWebToolsApiClient.readAirLineById(id);
    }
}
