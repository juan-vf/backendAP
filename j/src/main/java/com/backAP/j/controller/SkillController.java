package com.backAP.j.controller;

import com.backAP.j.entity.Skill;
import com.backAP.j.interfaces.IntSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    public IntSkillService intSkillService;


    @GetMapping("/get")
    public List<Skill> getListSkill(){
        List<Skill> sksList = intSkillService.getListSkill();
        return sksList;
    }

    @PostMapping("/save")
    public String saveSkill(@RequestBody Skill skill){
        intSkillService.saveSkill(skill);
        return "Skill data saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSkillById(@PathVariable Integer id){
        intSkillService.deleteSkillById(id);
        return "Skill data deleted succesfully";
    }

    @GetMapping("/getaSkill/{id}")
    public Skill getSkillById(Integer id){
        Skill sks = intSkillService.findSkillById(id);
        return sks;
    }

    //http://localhost:8080/skill/edit/1? PARA PEDIR CON ID 1
    @PutExchange("/edit/{id}")
    public Skill editSkillById(@PathVariable Integer id,
                               @RequestParam("nameSkill") String newNameSkill,
                               @RequestParam("typeSoft") Boolean newTypeSoft,
                               @RequestParam("typeHard") Boolean newTypeHard,
                               @RequestParam("skillDomain") Integer newSkillDomain){
        Skill editSks = intSkillService.findSkillById(id);

        editSks.setNameSkill(newNameSkill);
        editSks.setTypeHard(newTypeHard);
        editSks.setTypeSoft(newTypeSoft);
        editSks.setSkillDomain(newSkillDomain);

        intSkillService.saveSkill(editSks);
        return editSks;
    }
}
