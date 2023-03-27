package com.backAP.j.service;

import com.backAP.j.entity.Education;
import com.backAP.j.interfaces.IntEducationService;
import com.backAP.j.repository.IntEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ImpEducationService{

    @Autowired
    public IntEducationRepository intEducationRepository ;

    public List<Education> getListEducation() {
        List<Education> eduList = intEducationRepository.findAll();
        return eduList;
    }


    public void saveEducation(Education education) {
        intEducationRepository.save(education);
    }


    public void deleteEducationById(int id) {
        intEducationRepository.deleteById(id);
    }


    public Optional<Education> findEducationById(Integer id) {
        return intEducationRepository.findById(id);
    }

    public Optional<Education> getByTittle(String tittle) {
        return intEducationRepository.findByTittle(tittle);
    }

    public Optional<Education> findByTittle(String tittle) {
        return intEducationRepository.findByTittle(tittle);
    }
    public boolean exitsById(int id) {
        return intEducationRepository.existsById(id);
    }

    public boolean exitsByTittle(String tittle) {
        return intEducationRepository.existsByTittle(tittle);
    }


}
