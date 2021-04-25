package com.post.model.entity;


import com.post.enums.EnvelopeStatus;
import com.post.enums.EnvelopeType;
import com.post.enums.PostType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Envelope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trackingNumber;
    @Column
    private String sourceAddress;
    @Column
    private String destinationAddress;
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "tracking_Number")
    private List<EnvelopeInformation> envelopeInformations=new ArrayList<>();
    @Column
    private float weight;
    @Column
    private float height;
    @Column
    private float length;
    @Column
    private float width;
    @Column
    private String packageMaterial;
    @Enumerated(EnumType.STRING)
    private EnvelopeType envelopeType;
    @Enumerated(EnumType.STRING)
    private PostType postType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName")
    private Customer customer;
    @Column
    private String employeeName;
    @Enumerated(EnumType.STRING)
    private EnvelopeStatus lastStatus;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }



    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }





    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        width = width;
    }

    public EnvelopeType getEnvelopeType() {
        return envelopeType;
    }

    public void setEnvelopeType(EnvelopeType envelopeType) {
        this.envelopeType = envelopeType;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public Envelope() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "trackingNumber=" + trackingNumber +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", envelopeInformations=" + envelopeInformations +
                ", weight=" + weight +
                ", height=" + height +
                ", length=" + length +
                ", width=" + width +
                ", packageMaterial='" + packageMaterial + '\'' +
                ", envelopeType=" + envelopeType +
                ", postType=" + postType +
                ", customer=" + customer +
                ", employeeName='" + employeeName + '\'' +
                ", lastStatus=" + lastStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Envelope)) return false;
        Envelope envelope = (Envelope) o;
        return getTrackingNumber() == envelope.getTrackingNumber() && Float.compare(envelope.getWeight(), getWeight()) == 0 && Float.compare(envelope.getHeight(), getHeight()) == 0 && Float.compare(envelope.getLength(), getLength()) == 0 && Float.compare(envelope.getWidth(), getWidth()) == 0 && Objects.equals(getSourceAddress(), envelope.getSourceAddress()) && Objects.equals(getDestinationAddress(), envelope.getDestinationAddress()) && Objects.equals(envelopeInformations, envelope.envelopeInformations) && getEnvelopeType() == envelope.getEnvelopeType() && getPostType() == envelope.getPostType() && Objects.equals(getCustomer(), envelope.getCustomer()) && Objects.equals(getEmployeeName(), envelope.getEmployeeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrackingNumber(), getSourceAddress(), getDestinationAddress(), envelopeInformations, getWeight(), getHeight(), getLength(), getWidth(), getEnvelopeType(), getPostType(), getCustomer(), getEmployeeName());
    }

    public List<EnvelopeInformation> getEnvelopeInformations() {
        return envelopeInformations;
    }

    public void setEnvelopeInformations(List<EnvelopeInformation> envelopeInformations) {
        this.envelopeInformations = envelopeInformations;
    }

    public String getPackageMaterial() {
        return packageMaterial;
    }

    public void setPackageMaterial(String packageMaterial) {
        this.packageMaterial = packageMaterial;
    }

    public EnvelopeStatus getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(EnvelopeStatus lastStatus) {
        this.lastStatus = lastStatus;
    }
}
