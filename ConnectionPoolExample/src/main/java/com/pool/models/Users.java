package com.pool.models;

public class Users {
    private int id;
    private String name;
    private String about;

    public Users(int id, String name, String about) {
        this.id = id;
        this.name = name;
        this.about = about;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
