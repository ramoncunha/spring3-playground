package com.ramon.myplayground.infrastructure.services;

import com.ramon.myplayground.domain.IUserService;
import com.ramon.myplayground.infrastructure.models.UserRequest;
import com.ramon.myplayground.infrastructure.repositories.UserRepository;
import com.ramon.myplayground.infrastructure.repositories.models.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserRequest userRequest) {
        UserEntity user = UserEntity.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .build();
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public UserEntity findById(UUID id) {
        return null;
    }

    @Override
    public UserEntity update(UUID id, UserRequest userRequest) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
