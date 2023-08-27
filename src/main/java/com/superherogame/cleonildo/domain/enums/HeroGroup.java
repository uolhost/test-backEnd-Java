package com.superherogame.cleonildo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HeroGroup {
    AVENGER("Vingadores"), JUSTICE_LEAGUE("Liga da Justiça");

    private final String groupName;
}
