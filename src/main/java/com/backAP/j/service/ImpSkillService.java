package com.backAP.j.service;

import com.backAP.j.entity.Skill;
import com.backAP.j.repository.IntSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ImpSkillService{

    @Autowired
    public IntSkillRepository intSkillRepository;


    public List<Skill> getListSkill() {
        List<Skill> listSks = intSkillRepository.findAll();
        return listSks;
    }
    public void saveSkill(Skill skill) {
        intSkillRepository.save(skill);
    }

    public void deleteSkillById(Integer id) {
        intSkillRepository.deleteById(id);
    }

    public Optional<Skill> findSkillById(Integer id) {
        return intSkillRepository.findById(id);
    }
    public Optional<Skill> getByNameSkill(String nameSkill) {return intSkillRepository.findByNameSkill(nameSkill);}
    public boolean existsById(int id){ return intSkillRepository.existsById(id);}
    public boolean existByNameSkill(String nameSkill){
        return intSkillRepository.existsByNameSkill(nameSkill);
    }

}
