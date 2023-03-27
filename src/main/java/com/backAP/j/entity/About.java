package com.backAP.j.entity;

import jakarta.persistence.*;

@Entity
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "abt_id")
    private Integer id;
    private String tittleAbout;
    @Column(length = 500)
    private String descriptionAbout;

    //UN ABOUT.CLASS TIENE UN PERSON.CLASS
    @OneToOne(mappedBy = "about", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Person person;

    public About() {
    }

    public About(String tittleAbout, String descriptionAbout) {
        this.tittleAbout = tittleAbout;
        this.descriptionAbout = descriptionAbout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
