package com.sarim.rest.webservices.restfulwebservices.user;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private Integer Id;

    @Size(min = 3, message = "Name should have atleast two characters")
    private String name;
    @Past
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
