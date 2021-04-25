package com.post.model.entity;


import com.post.enums.EnvelopeStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class EnvelopeInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusID;
    @Column
    private String Description;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateTime;
    @Column
    private String employeeName;
    @Enumerated(EnumType.STRING)
    private EnvelopeStatus envelopeStatus;
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "tracking_Number")
    private Envelope envelope;

    public Envelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

    public EnvelopeInformation() {
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public EnvelopeStatus getEnvelopeStatus() {
        return envelopeStatus;
    }

    public void setEnvelopeStatus(EnvelopeStatus envelopeStatus) {
        this.envelopeStatus = envelopeStatus;
    }

    public EnvelopeInformation(int statusID, String description, Date dateTime, String employeeName, EnvelopeStatus envelopeStatus) {
        this.statusID = statusID;
        Description = description;
        this.dateTime = dateTime;
        this.employeeName = employeeName;
        this.envelopeStatus = envelopeStatus;
    }

    @Override
    public String toString() {
        return "EnvelopeInformation{" +
                "statusID=" + statusID +
                ", Description='" + Description + '\'' +
                ", dateTime=" + dateTime +
                ", employeeName='" + employeeName + '\'' +
                ", envelopeStatus=" + envelopeStatus +
                ", envelope=" + envelope +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnvelopeInformation)) return false;
        EnvelopeInformation that = (EnvelopeInformation) o;
        return getStatusID() == that.getStatusID() && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDateTime(), that.getDateTime()) && Objects.equals(getEmployeeName(), that.getEmployeeName()) && getEnvelopeStatus() == that.getEnvelopeStatus() && Objects.equals(getEnvelope(), that.getEnvelope());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusID(), getDescription(), getDateTime(), getEmployeeName(), getEnvelopeStatus(), getEnvelope());
    }
}
