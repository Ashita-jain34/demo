package com.example.mapper.demo1.Entity;

import javax.persistence.*;
@Entity
public class Post {
    @Id
    private Integer Id;

    private String firstname;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
