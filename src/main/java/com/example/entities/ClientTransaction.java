package com.example.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "trn")
@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientTransaction implements Serializable {
    private static final long serialVersionUID = 1L;

    // this identifier is a dummy;
    @Id
    @XmlTransient
    private Long id;

    private String place;

    private Double amount;

    private String currency;

    public String card;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    public Client client;

    public Long getId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Client getClient() {
      return client;
    }

    public void setClient(Client client) {
      this.client = client;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- - - - - - - - - - - - - - - - - - - -").append("\n")
            .append("ID = ").append(getId()).append("\n")
            .append("    Place = ").append(getPlace()).append("\n")
            .append("    Amount = ").append(getAmount()).append("\n")
            .append("    Currency = ").append(getCurrency()).append("\n")
            .append("    Card = ").append(getCard()).append("\n")
            .append("    Client = ").append(getClient()).append("\n");
        return sb.toString();
    }

}
