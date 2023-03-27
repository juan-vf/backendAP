package com.backAP.j.interfaces;

import com.backAP.j.entity.Skill;

import java.util.List;

public interface IntSkillService {
    //get Skill List
    public List<Skill> getListSkill();

    //save Skill class
    public void saveSkill(Skill skill);

    //delete Skill
    public void deleteSkillById(Integer id);

    //find Skill by id
    public Skill findSkillById(Integer id);
}
