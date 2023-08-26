package com.superherogame.cleonildo.domain.enums;

import lombok.Getter;

public enum HeroGroup {
    AVENGER("Vingadores"),
    JUSTIC_LEAGUE("Liga da Justiça");
    private final String groupName;

    public String getGroupName() {
        return groupName;
    }

    HeroGroup(String groupName) {
        this.groupName = groupName;
    }
}
