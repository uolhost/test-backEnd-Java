package com.superherogame.cleonildo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Avenger(@JsonProperty("codinome") String codeName) { }
