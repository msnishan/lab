package com.msnishan.lab.model;

/**
 * Created by ksaleh on 10/16/16.
 */
public class Level {
    private String id;
    private String description;

    public Level(String id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level level = (Level) o;

        if (id != null ? !id.equals(level.id) : level.id != null) return false;
        return description != null ? description.equals(level.description) : level.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
