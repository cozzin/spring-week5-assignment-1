package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.UserService;
import com.codesoom.assignment.domain.User;
import com.codesoom.assignment.dto.UserCreateData;
import com.codesoom.assignment.dto.UserUpdateData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid UserCreateData userCreateData) {
        return userService.createUser(userCreateData);
    }

    @RequestMapping(value = "/{id}",
            method = {RequestMethod.PATCH, RequestMethod.PUT})
    public User update(
            @PathVariable Long id,
            @RequestBody @Valid UserUpdateData userUpdateData
    ) {
        return userService.updateUser(id, userUpdateData);
    }
}
