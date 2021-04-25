package com.post.model.entity;

import javax.persistence.*;
@Entity
public class Employee extends User{
    @Id
    private String UserName;

    public Employee(String password, Long phoneNumber, String email, Address address, String name, String userName) {
        super(password, phoneNumber, email, address, name);
        UserName = userName;
    }

    public Employee() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "UserName='" + UserName + '\'' +
                '}';
    }
}
