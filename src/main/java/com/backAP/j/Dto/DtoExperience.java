package com.backAP.j.Dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class DtoExperience {
    @NotBlank
    private String positionTitle;
    @NotBlank
    private String companyLogo;
    @NotBlank
    private String descriptionOfActivities;
    @NotBlank
    private Date startActivityDate;
    @NotBlank
    private Date endActivityDate;

    public DtoExperience() {
    }

    public DtoExperience(String positionTitle, String companyLogo, String descriptionOfActivities, Date startActivityDate, Date endActivityDate) {
        this.positionTitle = positionTitle;
        this.companyLogo = companyLogo;
        this.descriptionOfActivities = descriptionOfActivities;
        this.startActivityDate = startActivityDate;
        this.endActivityDate = endActivityDate;
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
