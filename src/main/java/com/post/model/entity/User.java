package com.post.model.entity;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class User {
    @Column
    private String password;
    @Column
    private Long phoneNumber;
    @Column
    private String email;
    @Column
    private Address address;
    @Column
    private String name;

    public User(String password, Long phoneNumber, String email, Address address, String name) {
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.name = name;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", name='" + name + '\'' +
                '}';
    }
}
