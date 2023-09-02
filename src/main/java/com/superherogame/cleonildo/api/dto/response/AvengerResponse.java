package com.superherogame.cleonildo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AvengerResponse(@JsonProperty("codinome") String codeName) {}
