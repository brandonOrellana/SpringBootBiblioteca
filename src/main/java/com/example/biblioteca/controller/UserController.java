package com.example.biblioteca.controller;

import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.model.entity.User;
import com.example.biblioteca.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity readUser(@PathVariable String username){
        return ResponseEntity.ok(userService.readUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/airline/{airlineId}")
    public ResponseEntity createUser(@PathVariable String airlineId){
       // return ResponseEntity.ok(userService.readAirline(airlineId));
    }
}
