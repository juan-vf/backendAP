package com.backAP.j.service;

import com.backAP.j.entity.Experience;
import com.backAP.j.interfaces.IntExperienceService;
import com.backAP.j.repository.IntExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImpExperienceService implements IntExperienceService{

    @Autowired
    private IntExperienceRepository intExperienceRepository;

    @Override
    public void saveExperience(Experience exp) {
        intExperienceRepository.save(exp);
    }

    @Override
    public void deleteExperienceById(Integer id) {
        intExperienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperienceById(Integer id) {
        Experience exp = intExperienceRepository.findById(id).orElse(null);
        return exp;
    }

    @Override
    public List<Experience> getListExperienceById() {
        List<Experience> expList = intExperienceRepository.findAll();
        return expList;
    }

}
