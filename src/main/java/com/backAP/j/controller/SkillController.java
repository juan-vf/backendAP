package com.backAP.j.controller;

import com.backAP.j.Dto.DtoSkill;
import com.backAP.j.entity.Skill;
import com.backAP.j.security.entity.Mensaje;
import com.backAP.j.service.ImpSkillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@Controller
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendap-90374.web.app"})
@RequestMapping("/skill")
public class SkillController {
    //@Autowired
    //public IntSkillService intSkillService;
    @Autowired
    ImpSkillService impSkillService;



    @GetMapping("/get")
    public ResponseEntity<List<Skill>> getListSkill(){
        List<Skill> sksList = impSkillService.getListSkill();
        return new ResponseEntity(sksList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveSkill(@RequestBody DtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNameSkill())){
            return new ResponseEntity<>(new Mensaje("the name is required"), HttpStatus.BAD_REQUEST);
        }
        if( impSkillService.existByNameSkill(dtoSkill.getNameSkill())){
            return new ResponseEntity(new Mensaje("that name Skill already exist"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(dtoSkill.getNameSkill(), dtoSkill.getTypeSoft(), dtoSkill.getTypeHard(), dtoSkill.getSkillDomain());
        impSkillService.saveSkill(skill);
        return new ResponseEntity(new Mensaje("Skill data saved succesfully"), HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkillById(@PathVariable("id") int id){
        if(!impSkillService.existsById(id)){
            new ResponseEntity(new Mensaje("Skill id not exist"), HttpStatus.BAD_REQUEST);
        }
        impSkillService.deleteSkillById(id);
        return new ResponseEntity(new Mensaje("deleted Skill"), HttpStatus.OK);
    }

    @GetMapping("/getaSkill/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") int id){
        if(!impSkillService.existsById(id)){
            new ResponseEntity(new Mensaje("Skill id not exist"), HttpStatus.BAD_REQUEST);
        }
        Skill sks = impSkillService.findSkillById(id).get();
        return new ResponseEntity(sks, HttpStatus.OK);
    }

    //http://localhost:8080/skill/edit/1? PARA PEDIR CON ID 1
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editSkillById(@PathVariable("id") int id,
                                           @RequestBody DtoSkill dtoSkill){
        if(!impSkillService.existsById(id)){
            new ResponseEntity(new Mensaje("Skill id not exist"), HttpStatus.BAD_REQUEST);
        }
        if(impSkillService.existByNameSkill(dtoSkill.getNameSkill()) && impSkillService.getByNameSkill(dtoSkill.getNameSkill()).get().getId() != id){
            new ResponseEntity(new Mensaje("Skill already exist"), HttpStatus.BAD_REQUEST) ;
        }
        if(StringUtils.isBlank(dtoSkill.getNameSkill())){
            new ResponseEntity(new Mensaje("skill name is required"), HttpStatus.BAD_REQUEST) ;
        }

        Skill editSks = impSkillService.findSkillById(id).get();
        editSks.setNameSkill(dtoSkill.getNameSkill());
        editSks.setSkillDomain(dtoSkill.getSkillDomain());
        editSks.setTypeHard(dtoSkill.getTypeHard());
        editSks.setTypeSoft(dtoSkill.getTypeSoft());

        impSkillService.saveSkill(editSks);
        return new ResponseEntity(new Mensaje("updated and saved Skill"), HttpStatus.OK) ;
    }
}
