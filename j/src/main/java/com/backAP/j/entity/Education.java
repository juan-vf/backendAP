package com.backAP.j.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Component
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private Integer id;

    private String tittle;
    private String instituteName;
    private String instituteLogo;
    private String instituteCertification;
    private Date startActivityDate;
    //puede ser que todavia no lo termino, revisar eso
    private Date endActivityDate;
    private String descriptionOptional;

    public Education() {
    }

    public Education(String tittle, String instituteName, String instituteLogo, String instituteCertification, Date startActivityDate, Date endActivityDate, String descriptionOptional) {
        this.tittle = tittle;
        this.instituteName = instituteName;
        this.instituteLogo = instituteLogo;
        this.instituteCertification = instituteCertification;
        this.startActivityDate = startActivityDate;
        this.endActivityDate = endActivityDate;
        this.descriptionOptional = descriptionOptional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
