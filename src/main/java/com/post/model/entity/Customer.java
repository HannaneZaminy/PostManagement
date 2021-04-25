package com.post.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {
    @Id
    private String UserName;
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "userName")
    private List<Envelope> envelopes = new ArrayList<>();

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public List<Envelope> getEnvelopes() {
        return envelopes;
    }

    public void setEnvelopes(List<Envelope> envelopes) {
        this.envelopes = envelopes;
    }

    public Customer(String password, Long phoneNumber, String email, Address address, String name, String userName) {
        super(password, phoneNumber, email, address, name);
        UserName = userName;
    }

    public Customer() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "UserName='" + UserName + '\'' +
                ", envelopes=" + envelopes +
                '}';
    }
}
