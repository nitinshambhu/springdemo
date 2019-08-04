package com.example.demo.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class User {

    @Id
    int id;
    String name;
    int age;

    protected User() {
        
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", id=" + id + ", name=" + name + "]";
    }

}