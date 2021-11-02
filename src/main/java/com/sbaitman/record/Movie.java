package com.sbaitman.record;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public record Movie(String name, String genre, List<Actor> actors) implements Serializable {
    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", actors=" + actors +
                '}';
    }

    public Movie {
        Objects.nonNull(name);
        Objects.nonNull(genre);
        if(actors.size() < 0) {
            throw new IllegalArgumentException("Movie should have actors");
        }
    }

}
