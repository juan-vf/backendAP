package com.backAP.j.interfaces;

import com.backAP.j.entity.Education;

import java.util.List;

public interface IntEducationService {
    public List<Education> getListEducation();

    //save Education class
    public void saveEducation(Education education);

    //delete Education
    public void deleteEducationById(Integer id);

    //find Education by id
    public Education findEducationById(Integer id);
}
