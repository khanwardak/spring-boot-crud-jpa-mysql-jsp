package com.practiceAPI4.practice4RestAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "users_details")
public class Users {
    /* We can customize uor rest-api as we want on the name property We
        customize name @JsonProperty("user_name"), in response it return
        user_name instead of name.
        also We customized the id field in a way that not showing in response
     */

//    We done filtering on id field

    public Users() {

    }

//    @JsonIgnore
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;
    @Size(min = 2, message = "the name should be at least 2 characters")

//    in response it must be user_name instead of name here we done some serialization
    @JsonProperty("user_name")
    private String name;
    @Past(message = "the birth date should be in the past")
    private LocalDate dateOfbirth;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Users(int id, String name, LocalDate dateOfbirth) {
        this.id = id;
        this.name = name;
        this.dateOfbirth = dateOfbirth;
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

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfbirth=" + dateOfbirth +
                '}';
    }
}
