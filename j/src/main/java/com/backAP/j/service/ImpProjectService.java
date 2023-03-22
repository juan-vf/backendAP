package com.backAP.j.service;

import com.backAP.j.entity.Project;
import com.backAP.j.interfaces.IntProjectService;
import com.backAP.j.repository.IntProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImpProjectService implements IntProjectService {


    @Autowired
    public IntProjectRepository intProjectRepository;

    @Override
    public List<Project> getListProject() {
        List<Project> prjList = intProjectRepository.findAll();
        return prjList;
    }

    @Override
    public void saveProject(Project project) {
        intProjectRepository.save(project);
    }

    @Override
    public void deleteProjectById(Integer id) {
        intProjectRepository.deleteById(id);
    }

    @Override
    public Project findProjectById(Integer id) {
        Project prj = intProjectRepository.findById(id).orElse(null);
        return prj;
    }

}
