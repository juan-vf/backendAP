package com.backAP.j.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Integer id;

    @Basic
    @NotNull
    @Size(min = 1, max = 50, message = "name does not meet the length")
    private String name;
    @NotNull
    @Size(min = 1, max = 50, message = "last name does not meet the length")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_abt_id", referencedColumnName = "abt_id")
    private About about;

    //@OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    //private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_exp_id", referencedColumnName = "p_id")
    private List<Experience> experiences;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_edu_id", referencedColumnName = "p_id")
    private List<Education> educations;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_prj_id", referencedColumnName = "p_id")
    private List<Project> projects;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_sks_id", referencedColumnName = "p_id")
    private List<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_lan_id", referencedColumnName = "p_id")
    private List<Languaje> languajes;

    public Person() {
    }
    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }

    //public User getUser() {
    //    return user;
    //}

    //public void setUser(User user) {
    //    this.user = user;
    //}

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Languaje> getLanguajes() {
        return languajes;
    }

    public void setLanguajes(List<Languaje> languajes) {
        this.languajes = languajes;
    }
}
