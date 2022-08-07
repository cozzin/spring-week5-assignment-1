package com.codesoom.assignment.application;

import com.codesoom.assignment.domain.User;
import com.codesoom.assignment.domain.UserRepository;
import com.codesoom.assignment.dto.UserData;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final Mapper mapper;

    public UserService(UserRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public User createUser(UserData userData) {
        User user = mapper.map(userData, User.class);
        return repository.save(user);
    }
}
