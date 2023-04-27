package com.backAP.j.Dto;

import jakarta.validation.constraints.NotBlank;

public class DtoLanguaje {
    @NotBlank
    private String languaje;
    @NotBlank
    private String lanjuageDomain;
    @NotBlank
    private Integer lanjuageDomainNumber;

    public DtoLanguaje() {
    }

    public DtoLanguaje(String languaje, String lanjuageDomain, Integer lanjuageDomainNumber) {
        this.languaje = languaje;
        this.lanjuageDomain = lanjuageDomain;
        this.lanjuageDomainNumber = lanjuageDomainNumber;
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
