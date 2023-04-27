package com.backAP.j.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sks_id")
    private Integer id;

    private String nameSkill;
    private boolean typeSoft;
    private boolean typeHard;
    private Integer skillDomain;

    public Skill() {
    }

    public Skill(String nameSkill, boolean typeSoft, boolean typeHard, Integer skillDomain) {
        this.nameSkill = nameSkill;
        this.typeSoft = typeSoft;
        this.typeHard = typeHard;
        this.skillDomain = skillDomain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public boolean isTypeSoft() {
        return typeSoft;
    }

    public void setTypeSoft(boolean typeSoft) {
        this.typeSoft = typeSoft;
    }

    public boolean isTypeHard() {
        return typeHard;
    }

    public void setTypeHard(boolean typeHard) {
        this.typeHard = typeHard;
    }

    public Integer getSkillDomain() {
        return skillDomain;
    }

    public void setSkillDomain(Integer skillDomain) {
        this.skillDomain = skillDomain;
    }
}
