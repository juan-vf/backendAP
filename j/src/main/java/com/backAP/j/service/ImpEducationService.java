package com.backAP.j.service;

import com.backAP.j.entity.Education;
import com.backAP.j.interfaces.IntEducationService;
import com.backAP.j.repository.IntEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ImpEducationService implements IntEducationService {

    @Autowired
    public IntEducationRepository intEducationRepository ;
    @Override
    public List<Education> getListEducation() {
        List<Education> eduList = intEducationRepository.findAll();
        return eduList;
    }

    @Override
    public void saveEducation(Education education) {
        intEducationRepository.save(education);
    }

    @Override
    public void deleteEducationById(Integer id) {
        intEducationRepository.deleteById(id);
    }

    @Override
    public Education findEducationById(Integer id) {
        Education edu = intEducationRepository.findById(id).orElse(null);
        return edu;
    }

}
