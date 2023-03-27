package com.backAP.j.service;

import com.backAP.j.entity.Project;
import com.backAP.j.interfaces.IntProjectService;
import com.backAP.j.repository.IntProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ImpProjectService{


    @Autowired
    public IntProjectRepository intProjectRepository;




    public List<Project> getListProject() {
        List<Project> prjList = intProjectRepository.findAll();
        return prjList;
    }

    public void saveProject(Project project) {
        intProjectRepository.save(project);
    }

    public void deleteProjectById(Integer id) {
        intProjectRepository.deleteById(id);
    }

    public Optional<Project> findProjectById(Integer id) {
        return intProjectRepository.findById(id);
    }
    public Optional<Project> getByNameProject(String nameProject){
        return intProjectRepository.findByNameProject(nameProject);
    }
    public boolean existsById(int id){
        return intProjectRepository.existsById(id);
    }

    public boolean existByNameProject(String nameProject){
        return intProjectRepository.existsByNameProject(nameProject);
    }

}
