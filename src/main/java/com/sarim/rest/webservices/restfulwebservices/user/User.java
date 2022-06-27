package com.sarim.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {

    private Integer Id;
    private String name;
    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        Id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
