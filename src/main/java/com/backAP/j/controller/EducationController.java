package com.backAP.j.controller;

import com.backAP.j.Dto.DtoEducation;
import com.backAP.j.entity.Education;
import com.backAP.j.interfaces.IntEducationService;
import com.backAP.j.security.entity.Mensaje;
import com.backAP.j.service.ImpEducationService;
import com.backAP.j.service.ImpPersonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Controller
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendap-90374.web.app"})

@RequestMapping("/education")
public class EducationController {
    @Autowired
    public ImpEducationService impEducationService;

    @GetMapping("/get")
    public ResponseEntity<List<Education>> getListEducation(){
        List<Education> expList = impEducationService.getListEducation();
        return new ResponseEntity(expList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveEducation(@RequestBody DtoEducation dtoEducation){
        try {

        if(StringUtils.isBlank(dtoEducation.getTittle())){
            return new ResponseEntity(new Mensaje("name is required"), HttpStatus.BAD_REQUEST);
        }
        if(impEducationService.exitsByTittle(dtoEducation.getTittle())){
            return new ResponseEntity(new Mensaje("that name already exists"), HttpStatus.BAD_REQUEST);
        }

        Education edu = new Education(
                dtoEducation.getTittle(),
                dtoEducation.getInstituteName(),
                dtoEducation.getInstituteLogo(),
                dtoEducation.getInstituteCertification(),
                dtoEducation.getStartActivityDate(),
                dtoEducation.getEndActivityDate(),
                dtoEducation.getDescriptionOptional()
        );
        impEducationService.saveEducation(edu);
        return new ResponseEntity(new Mensaje("education saved"), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Mensaje("error saving education: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducationById(@PathVariable("id") int id){

        if(!impEducationService.exitsById(id)){
            return new ResponseEntity<>(new Mensaje("no exist that id"), HttpStatus.NOT_FOUND);
        }
        impEducationService.deleteEducationById(id);
        return new ResponseEntity(new Mensaje("Education data deleted succesfully"), HttpStatus.OK);
    }

    @GetMapping("/getEducation/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable("id") int id){
        if(!impEducationService.exitsById(id)){
            return new ResponseEntity(new Mensaje("id not exist"), HttpStatus.BAD_REQUEST);
        }
        Education edu = impEducationService.findEducationById(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }

    //http://localhost:8080/education/edit/1? PARA PEDIR CON ID 1
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editEducationById(@PathVariable("id") int id,@RequestBody DtoEducation dtoEducation){

        if(!impEducationService.exitsById(id)){
            new ResponseEntity(new Mensaje("Experience id not exist"), HttpStatus.BAD_REQUEST);
        }

        if(impEducationService.exitsByTittle(dtoEducation.getTittle()) && impEducationService.getByTittle(dtoEducation.getTittle()).get().getId() != id){
            new ResponseEntity(new Mensaje("Education already exist"), HttpStatus.BAD_REQUEST) ;
        }

        if(StringUtils.isBlank(dtoEducation.getTittle())){
            new ResponseEntity(new Mensaje("Education name is required"), HttpStatus.BAD_REQUEST) ;
        }



        Education editEdu = impEducationService.findEducationById(id).get();

        editEdu.setTittle(dtoEducation.getTittle());
        editEdu.setInstituteName(dtoEducation.getInstituteName());
        editEdu.setInstituteLogo(dtoEducation.getInstituteLogo());
        editEdu.setInstituteCertification(dtoEducation.getInstituteCertification());
        editEdu.setStartActivityDate(dtoEducation.getStartActivityDate());
        editEdu.setEndActivityDate(dtoEducation.getEndActivityDate());
        editEdu.setDescriptionOptional(dtoEducation.getDescriptionOptional());

        impEducationService.saveEducation(editEdu);
        return new ResponseEntity(new Mensaje("updated and saved experience"), HttpStatus.OK) ;
    }
}
