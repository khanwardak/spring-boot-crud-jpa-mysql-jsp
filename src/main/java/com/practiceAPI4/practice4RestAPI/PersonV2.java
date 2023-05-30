package com.practiceAPI4.practice4RestAPI;

public class PersonV2 {
    private String name;
    private  String lastname;

    public PersonV2(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public String getLastname() {
        return lastname;
    }
}
