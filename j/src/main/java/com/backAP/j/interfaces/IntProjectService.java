package com.backAP.j.interfaces;

import com.backAP.j.entity.Project;

import java.util.List;

public interface IntProjectService {
    //get Project List
    public List<Project> getListProject();

    //save Project class
    public void saveProject(Project project);

    //delete Project
    public void deleteProjectById(Integer id);

    //find Project by id
    public Project findProjectById(Integer id);
}
