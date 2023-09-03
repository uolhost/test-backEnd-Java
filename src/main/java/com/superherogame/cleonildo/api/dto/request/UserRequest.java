package com.superherogame.cleonildo.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.superherogame.cleonildo.domain.enums.HeroGroup;

public record UserRequest(String name, String email, String phone, @JsonProperty("code_name") String codeName,
                          HeroGroup group) { }
