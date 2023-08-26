package com.superherogame.cleonildo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.superherogame.cleonildo.domain.entities.User;

import java.util.UUID;

public record UserResponse(UUID id, String name, String email, String phone, @JsonProperty("code_name") String codeName,
        String group)
{
    public UserResponse(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getCodeName(), user.getHeroGroup().getGroupName());
    }
}

