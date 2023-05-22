package com.practiceAPI4.practice4RestAPI.entity;

import java.time.LocalDate;

public class Users {
    private  int id;
    private String name;
    private LocalDate dateOfbirth;

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
