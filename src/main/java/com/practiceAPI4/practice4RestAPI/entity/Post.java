package com.practiceAPI4.practice4RestAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.lang.reflect.Type;

@Entity
public class Post {
    public Post(){

    }
    public Post(int id, String description, Users user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;
    private  String description;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @JsonIgnore
    @ManyToOne(fetch =  FetchType.LAZY)
    private Users user;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
