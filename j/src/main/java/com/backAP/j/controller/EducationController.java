package com.backAP.j.controller;

import com.backAP.j.entity.Education;
import com.backAP.j.interfaces.IntEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.Date;
import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/education")
public class EducationController {
    @Autowired
    public IntEducationService  intEducationService;

    @GetMapping("/get")
    public List<Education> getListExperience(){
        List<Education> expList = intEducationService.getListEducation();
        return expList;
    }

    @PostMapping("/save")
    public String saveExperience(@RequestBody Education education){
        intEducationService.saveEducation(education);
        return "Education data saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteExperienceById(@PathVariable Integer id){
        intEducationService.deleteEducationById(id);
        return "Education data deleted succesfully";
    }

    @GetMapping("/getEducation/{id}")
    public Education getExperienceById(Integer id){
        Education edu = intEducationService.findEducationById(id);
        return edu;
    }

    //http://localhost:8080/education/edit/1? PARA PEDIR CON ID 1
    @PutExchange("/edit/{id}")
    public Education editExperienceById(@PathVariable Integer id,
                                        @RequestParam("tittle") String newTittle,
                                        @RequestParam("instituteName") String newInstituteName,
                                        @RequestParam("instituteLogo") String newInstituteLogo,
                                        @RequestParam("instituteCertification") String newInstituteCertification,
                                        @RequestParam("startActivityDate") Date newStartActivityDate,
                                        @RequestParam("endActivityDate") Date newEndActivityDate,
                                        @RequestParam("descriptionOptional") String newDescriptionOptional){
        Education editEdu = intEducationService.findEducationById(id);

        editEdu.setTittle(newTittle);
        editEdu.setInstituteName(newInstituteName);
        editEdu.setInstituteLogo(newInstituteLogo);
        editEdu.setInstituteCertification(newInstituteCertification);
        editEdu.setStartActivityDate(newStartActivityDate);
        editEdu.setEndActivityDate(newEndActivityDate);
        editEdu.setDescriptionOptional(newDescriptionOptional);

        intEducationService.saveEducation(editEdu);
        return editEdu;
    }
}
