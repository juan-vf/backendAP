package com.backAP.j.service;

import com.backAP.j.entity.Skill;
import com.backAP.j.interfaces.IntSkillService;
import com.backAP.j.repository.IntSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ImpSkillService implements IntSkillService {

    @Autowired
    public IntSkillRepository intSkillRepository;

    @Override
    public List<Skill> getListSkill() {
        List<Skill> listSks = intSkillRepository.findAll();
        return listSks;
    }

    @Override
    public void saveSkill(Skill skill) {
        intSkillRepository.save(skill);
    }

    @Override
    public void deleteSkillById(Integer id) {
        intSkillRepository.deleteById(id);
    }

    @Override
    public Skill findSkillById(Integer id) {
        Skill sks = intSkillRepository.findById(id).orElse(null);
        return sks;
    }

}
