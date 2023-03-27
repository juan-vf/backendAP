package com.backAP.j.controller;

import com.backAP.j.Dto.DtoExperience;
import com.backAP.j.entity.Experience;
import com.backAP.j.interfaces.IntExperienceService;
import com.backAP.j.repository.IntExperienceRepository;
import com.backAP.j.security.entity.Mensaje;
import com.backAP.j.service.ImpExperienceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/experience")
public class ExperienceController {
    //@Autowired
    //private IntExperienceService intExperienceService;

    //@Autowired
    //private IntExperienceRepository intExperienceRepository;


    @Autowired
    private ImpExperienceService impExperienceService;


    @GetMapping("/getList")
    public ResponseEntity<List<Experience>> getListExperience(){
        List<Experience> expList = impExperienceService.getListExperience();
        return new ResponseEntity(expList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveExperience(@RequestBody DtoExperience dtoExperience){
        if(StringUtils.isBlank(dtoExperience.getPositionTitle())){
            return new ResponseEntity(new Mensaje("the name is required"), HttpStatus.BAD_REQUEST);
        }
        if(impExperienceService.existByPositionTitle(dtoExperience.getPositionTitle())){
            return new ResponseEntity(new Mensaje("that name experience already exist"), HttpStatus.BAD_REQUEST);
        }
        Experience exp = new Experience(dtoExperience.getPositionTitle(), dtoExperience.getCompanyLogo(), dtoExperience.getDescriptionOfActivities(), dtoExperience.getStartActivityDate(), dtoExperience.getEndActivityDate());
        impExperienceService.saveExperience(exp);
        return new ResponseEntity(new Mensaje("Experience data saved succesfully"), HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperienceById(@PathVariable("id") int id){

        if(!impExperienceService.existsById(id)){
            new ResponseEntity(new Mensaje("Experience id not exist"), HttpStatus.BAD_REQUEST) ;
        }

        impExperienceService.deleteExperienceById(id);
        return new ResponseEntity(new Mensaje("deleted experience"), HttpStatus.OK);
    }

    @GetMapping("/getaExperience/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable("id") int id){
        if(!impExperienceService.existsById(id)){
            new ResponseEntity(new Mensaje("Experience id not exist"), HttpStatus.BAD_REQUEST);
        }
        Experience exp = impExperienceService.findExperienceById(id).get();
        return new ResponseEntity(exp, HttpStatus.OK);
    }

    //http://localhost:8080/experience/edit/1? PARA PEDIR CON ID 1
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editExperienceById(@PathVariable("id") Integer id,
                                                @RequestBody DtoExperience dtoExperience){


        if(!impExperienceService.existsById(id)){
            new ResponseEntity(new Mensaje("Experience id not exist"), HttpStatus.BAD_REQUEST);
        }

        if(impExperienceService.existByPositionTitle(dtoExperience.getPositionTitle()) && impExperienceService.getByPositionTitle(dtoExperience.getPositionTitle()).get().getId() != id){
            new ResponseEntity(new Mensaje("Experience already exist"), HttpStatus.BAD_REQUEST) ;
        }

        if(StringUtils.isBlank(dtoExperience.getPositionTitle())){
            new ResponseEntity(new Mensaje("Experience name is required"), HttpStatus.BAD_REQUEST) ;
        }

        Experience exp = impExperienceService.findExperienceById(id).get();

        exp.setPositionTitle(dtoExperience.getPositionTitle());
        exp.setCompanyLogo(dtoExperience.getCompanyLogo());
        exp.setDescriptionOfActivities(dtoExperience.getDescriptionOfActivities());
        exp.setStartActivityDate(dtoExperience.getStartActivityDate());
        exp.setEndActivityDate(dtoExperience.getEndActivityDate());

        impExperienceService.saveExperience(exp);
        return new ResponseEntity(new Mensaje("updated and saved experience"), HttpStatus.OK) ;
    }
}
