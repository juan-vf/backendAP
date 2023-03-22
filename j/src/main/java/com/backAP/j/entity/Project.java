package com.backAP.j.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prj_id")
    private Integer id;

    private String nameProject;
    private String descriptionProject;
    private String linkProject;
    private Date startActivityDate;
    private Date endActivityDate;
    private List<String> imagesProject;

    public Project() {
    }

    public Project(String nameProject, String descriptionProject, String linkProject, Date startActivityDate, Date endActivityDate, List<String> imagesProject) {
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
