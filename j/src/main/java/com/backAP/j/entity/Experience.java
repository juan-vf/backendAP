package com.backAP.j.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private Integer id;

    private String positionTitle;
    private String companyLogo;
    private String descriptionOfActivities;

    private Date startActivityDate;
    private Date endActivityDate;

    public Experience() {
    }
    public Experience(String positionTitle, String companyLogo, String descriptionOfActivities, Date startActivityDate, Date endActivityDate) {
        this.positionTitle = positionTitle;
        this.companyLogo = companyLogo;
        this.descriptionOfActivities = descriptionOfActivities;
        this.startActivityDate = startActivityDate;
        this.endActivityDate = endActivityDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getDescriptionOfActivities() {
        return descriptionOfActivities;
    }

    public void setDescriptionOfActivities(String descriptionOfActivities) {
        this.descriptionOfActivities = descriptionOfActivities;
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
}
