package com.backAP.j.Dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

public class DtoProject {

    @NotBlank
    private String nameProject;
    @NotBlank
    private String descriptionProject;
    @NotBlank
    private String linkProject;
    @NotBlank
    private Date startActivityDate;
    @NotBlank
    private Date endActivityDate;
    @NotBlank
    private List<String> imagesProject;

    public DtoProject() {
    }

    public DtoProject(String nameProject, String descriptionProject, String linkProject, Date startActivityDate, Date endActivityDate, List<String> imagesProject) {
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.linkProject = linkProject;
        this.startActivityDate = startActivityDate;
        this.endActivityDate = endActivityDate;
        this.imagesProject = imagesProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }

    public String getLinkProject() {
        return linkProject;
    }

    public void setLinkProject(String linkProject) {
        this.linkProject = linkProject;
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

    public List<String> getImagesProject() {
        return imagesProject;
    }

    public void setImagesProject(List<String> imagesProject) {
        this.imagesProject = imagesProject;
    }
}
