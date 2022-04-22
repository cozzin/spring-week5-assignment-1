package com.codesoom.assignment.controller;

import com.codesoom.assignment.application.UserCommandService;
import com.codesoom.assignment.domain.UserResponseDto;
import com.codesoom.assignment.domain.UserSaveDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@UserController
public class UserUpdateController {

    private final UserCommandService service;

    public UserUpdateController(UserCommandService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT})
    public UserResponseDto updateUser(@PathVariable Long id,
                                      @Valid @RequestBody UserSaveDto userSaveDto) {
        return new UserResponseDto(service.updateUser(id, userSaveDto));
    }

}
