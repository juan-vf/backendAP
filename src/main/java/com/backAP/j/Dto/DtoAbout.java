package com.backAP.j.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class DtoAbout {
    @NotBlank
    private String tittleAbout;
    @NotBlank
    private String descriptionAbout;

    public DtoAbout() {
    }

    public DtoAbout(String tittleAbout, String descriptionAbout) {
        this.tittleAbout = tittleAbout;
        this.descriptionAbout = descriptionAbout;
    }

    public String getTittleAbout() {
        return tittleAbout;
    }

    public void setTittleAbout(String tittleAbout) {
        this.tittleAbout = tittleAbout;
    }

    public String getDescriptionAbout() {
        return descriptionAbout;
    }

    public void setDescriptionAbout(String descriptionAbout) {
        this.descriptionAbout = descriptionAbout;
    }
}
