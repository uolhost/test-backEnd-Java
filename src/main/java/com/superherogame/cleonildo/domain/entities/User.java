package com.superherogame.cleonildo.domain.entities;

import com.superherogame.cleonildo.domain.enums.HeroGroup;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    @Column(name = "code_name", unique = true)
    private String codeName;
    @Enumerated(EnumType.STRING)
    @Column(name = "hero_group")
    private HeroGroup heroGroup;

    public User(String name, String email, String phone, String codeName, HeroGroup heroGroup) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.codeName = codeName;
        this.heroGroup = heroGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
