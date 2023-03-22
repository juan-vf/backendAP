package com.backAP.j.interfaces;

import com.backAP.j.entity.Experience;

import java.util.List;

public interface IntExperienceService {
    public List<Experience> getListExperienceById();

    //save About class
    public void saveExperience(Experience exp);

    //delete person
    public void deleteExperienceById(Integer id);

    //find person by id
    public Experience findExperienceById(Integer id);
}
