package com.sbaitman.record;

import java.io.Serializable;
import java.util.Objects;

public record Actor(String name, String email) implements Serializable {
    public Actor {
        Objects.nonNull(name);
        Objects.nonNull(email);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
