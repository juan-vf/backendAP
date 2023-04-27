package com.backAP.j.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "languajes")
public class Languaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lan_id")
    private Integer id;

    private String languaje;
    private String lanjuageDomain;
    private Integer lanjuageDomainNumber;

    public Languaje() {
    }

    public Languaje(String languaje, String lanjuageDomain, Integer lanjuageDomainNumber) {
        this.languaje = languaje;
        this.lanjuageDomain = lanjuageDomain;
        this.lanjuageDomainNumber = lanjuageDomainNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguaje() {
        return languaje;
    }

    public void setLanguaje(String languaje) {
        this.languaje = languaje;
    }

    public String getLanjuageDomain() {
        return lanjuageDomain;
    }

    public void setLanjuageDomain(String lanjuageDomain) {
        this.lanjuageDomain = lanjuageDomain;
    }

    public Integer getLanjuageDomainNumber() {
        return lanjuageDomainNumber;
    }

    public void setLanjuageDomainNumber(Integer lanjuageDomainNumber) {
        this.lanjuageDomainNumber = lanjuageDomainNumber;
    }
}
