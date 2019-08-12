package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @XmlTransient
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    // 1234567890
    private Integer inn;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getInn() {
        return inn;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID = ").append(getId())
            .append("; FirstName = ").append(getFirstName())
            .append("; LastName = ").append(getLastName())
            .append("; MiddleName = ").append(getMiddleName())
            .append("; Inn = ").append(getInn());
        return sb.toString();
    }

}
