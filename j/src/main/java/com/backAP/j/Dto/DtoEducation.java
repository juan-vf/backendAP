package com.backAP.j.Dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class DtoEducation {
    @NotBlank
    private String tittle;
    @NotBlank
    private String instituteName;
    @NotBlank
    private String instituteLogo;
    @NotBlank
    private String instituteCertification;
    @NotBlank
    private Date startActivityDate;
    //puede ser que todavia no lo termino, revisar eso
    @NotBlank
    private Date endActivityDate;
    @NotBlank
    private String descriptionOptional;

    public DtoEducation() {
    }

    public DtoEducation(String tittle, String instituteName, String instituteLogo, String instituteCertification, Date startActivityDate, Date endActivityDate, String descriptionOptional) {
        this.tittle = tittle;
        this.instituteName = instituteName;
        this.instituteLogo = instituteLogo;
        this.instituteCertification = instituteCertification;
        this.startActivityDate = startActivityDate;
        this.endActivityDate = endActivityDate;
        this.descriptionOptional = descriptionOptional;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteLogo() {
        return instituteLogo;
    }

    public void setInstituteLogo(String instituteLogo) {
        this.instituteLogo = instituteLogo;
    }

    public String getInstituteCertification() {
        return instituteCertification;
    }

    public void setInstituteCertification(String instituteCertification) {
        this.instituteCertification = instituteCertification;
    }

    public Date getStartActivityDate() {
        return startActivityDate;
    }

    public void setStartActivityDate(Date startActivityDate) {
        this.startActivityDate = startActivityDate;
    }

    public Date getEndActivityDate() {
        return endActivityDate;
    }

    public void setEndActivityDate(Date endActivityDate) {
        this.endActivityDate = endActivityDate;
    }

    public String getDescriptionOptional() {
        return descriptionOptional;
    }

    public void setDescriptionOptional(String descriptionOptional) {
        this.descriptionOptional = descriptionOptional;
    }
}
