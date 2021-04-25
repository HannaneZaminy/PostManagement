package com.post.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
   @Column
   private String state;
   @Column
   private String city;
   @Column
   private String address;

   public Address() {

   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public Address(String state, String city, String address) {
      this.state = state;
      this.city = city;
      this.address = address;
   }
}
