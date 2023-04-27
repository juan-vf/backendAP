package com.backAP.j.Dto;

import jakarta.validation.constraints.NotBlank;

public class DtoSkill {
    @NotBlank
    private String nameSkill;
    @NotBlank
    private boolean typeSoft;
    @NotBlank
    private boolean typeHard;
    @NotBlank
    private Integer skillDomain;

    public DtoSkill(String nameSkill, boolean typeSoft, boolean typeHard, Integer skillDomain)
    {
        this.nameSkill = nameSkill;
        this.typeSoft = typeSoft;
        this.typeHard = typeHard;
        this.skillDomain = skillDomain;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public boolean getTypeSoft() {
        return typeSoft;
    }

    public void setTypeSoft(boolean typeSoft) {
        this.typeSoft = typeSoft;
    }

    public boolean getTypeHard() {
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
