package com.codesoom.assignment.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);

    Optional<User> findById(Long id);

    void delete(User user);

    boolean existsByEmail(String email);
}
