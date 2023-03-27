package com.backAP.j.service;

import com.backAP.j.entity.Experience;
import com.backAP.j.interfaces.IntExperienceService;
import com.backAP.j.repository.IntExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpExperienceService{

    @Autowired
    private IntExperienceRepository intExperienceRepository;

    //private IntExperienceRepository intExperienceRepository;

    public void saveExperience(Experience exp) {
        intExperienceRepository.save(exp);
    }

    public void deleteExperienceById(Integer id) {
        intExperienceRepository.deleteById(id);
    }

    //@Override
    public Optional<Experience> findExperienceById(Integer id) {
        return intExperienceRepository.findById(id);
    }

    public Optional<Experience> getByPositionTitle(String positionTitle){
        return intExperienceRepository.findByPositionTitle(positionTitle);
    }

    public boolean existsById(int id){
        return intExperienceRepository.existsById(id);
    }

    public boolean existByPositionTitle(String positionTitle){
        return intExperienceRepository.existsByPositionTitle(positionTitle);
    }

    public List<Experience> getListExperience() {
        List<Experience> expList = intExperienceRepository.findAll();
        return expList;
    }

}
