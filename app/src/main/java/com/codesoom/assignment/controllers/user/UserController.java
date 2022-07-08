package com.codesoom.assignment.controllers.user;

import com.codesoom.assignment.services.user.UserDeleter;
import com.codesoom.assignment.services.user.UserRegisterer;
import com.codesoom.assignment.services.user.UserUpdater;
import com.codesoom.assignment.services.user.domain.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRegisterer userRegisterer;
    private final UserUpdater userUpdater;
    private final UserDeleter userDeleter;

    public UserController(
            UserRegisterer userRegisterer,
            UserUpdater userUpdater,
            UserDeleter userDeleter
    ) {
        this.userRegisterer = userRegisterer;
        this.userUpdater = userUpdater;
        this.userDeleter = userDeleter;
    }

    @PostMapping
    public User register(@RequestBody @Valid User user) {
        return this.userRegisterer.execute(user.getName(), user.getEmail(), user.getPassword());
    }

    @PutMapping("/{id}")
    public User update(@RequestBody @Valid User user, @PathVariable @Valid Long id) {
        return this.userUpdater.execute(id, user.getName(), user.getEmail(), user.getPassword());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Valid Long id) {
        this.userDeleter.execute(id);
    }
}
