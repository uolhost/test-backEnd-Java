package com.superherogame.cleonildo.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.superherogame.cleonildo.api.dto.request.UserRequest;
import com.superherogame.cleonildo.api.dto.response.Avenger;
import com.superherogame.cleonildo.api.dto.response.AvengerResponse;
import com.superherogame.cleonildo.api.dto.response.UserResponse;
import com.superherogame.cleonildo.domain.client.AvengerClient;
import com.superherogame.cleonildo.domain.entities.User;
import com.superherogame.cleonildo.domain.enums.HeroGroup;
import com.superherogame.cleonildo.domain.repositories.UserRepository;
import com.superherogame.cleonildo.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.superherogame.cleonildo.exceptions.ErrorMessagemConstant.USER_NOT_FOUND;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;
    private final AvengerJsonService service;

    public UserService(UserRepository repository, AvengerJsonService service) {
        this.repository = repository;
        this.service = service;
        this.insertUser();
    }

    public Page<UserResponse> getAllUser(Pageable pageable) {
        LOGGER.info("Listá de usuários retornada com sucesso.");
        return repository.findAll(pageable).map(UserResponse::new);
    }

    public UserResponse getUserById(UUID id) {
        Optional<User> response = repository.findById(id);

        if (response.isEmpty()) {
            LOGGER.error(USER_NOT_FOUND);
            throw new NotFoundException(USER_NOT_FOUND);
        }

        LOGGER.info("Usuários econtrado com sucesso.");
        return new UserResponse(response.get());
    }

    public UserResponse addUser(UserRequest request) {
        try {
            List<AvengerResponse> listCodeName = service.getAvengersCodeNames();

            listCodeName.contains(request.codeName());

            User response = new User(request.name(), request.email(), request.phone(), request.codeName(), request.group());

            repository.save(response);
            LOGGER.info("Usuários salvo com sucesso.");
            return new UserResponse(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(UUID id, UserRequest request) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()) {
            LOGGER.error(USER_NOT_FOUND);
            throw new NotFoundException(USER_NOT_FOUND);
        }

        user.get().setName(request.name());
        user.get().setEmail(request.email());
        user.get().setPhone(request.phone());
        user.get().setCodeName(request.codeName());
        user.get().setHeroGroup(request.group());

        repository.save(user.get());
        LOGGER.info("Usuários foi atualizado com sucesso.");
    }

    public void deleteUserById(UUID id) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()) {
            LOGGER.error(USER_NOT_FOUND);
            throw new NotFoundException(USER_NOT_FOUND);
        }

        repository.deleteById(id);
        LOGGER.info("Usuários foi deletado com sucesso.");
    }

    private void insertUser() {
        User user = new User();
        user.setName("Hulk");
        user.setEmail("john@example.com");
        user.setPhone("123-456-7890");
        user.setCodeName("johnd");
        user.setHeroGroup(HeroGroup.AVENGER);

        repository.save(user);
    }
}
