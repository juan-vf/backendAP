package com.backAP.j.controller;

import com.backAP.j.entity.Experience;
import com.backAP.j.interfaces.IntExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.Date;
import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private IntExperienceService intExperienceService;


    @GetMapping("/get")
    public List<Experience> getListExperience(){
        List<Experience> expList = intExperienceService.getListExperienceById();
        return expList;
    }

    @PostMapping("/save")
    public String saveExperience(@RequestBody Experience experience){
        intExperienceService.saveExperience(experience);
        return "Experience data saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteExperienceById(@PathVariable Integer id){
        intExperienceService.deleteExperienceById(id);
        return "Experience data deleted succesfully";
    }

    @GetMapping("/getaExperience/{id}")
    public Experience getExperienceById(Integer id){
        Experience exp = intExperienceService.findExperienceById(id);
        return exp;
    }

    //http://localhost:8080/experience/edit/1? PARA PEDIR CON ID 1
    @PutExchange("/edit/{id}")
    public Experience editExperienceById(@PathVariable Integer id,
                                         @RequestParam("positionTittle") String newPositionTittle,
                                         @RequestParam("companyLogo") String newCompanyLogo,
                                         @RequestParam("descriptionOfActivities") String newDescriptionOfActivities,
                                         @RequestParam("startActivityDate") Date newStartActivityDate,
                                         @RequestParam("endActivityDate") Date newEndActivityDate){
        Experience editExp = intExperienceService.findExperienceById(id);

        editExp.setPositionTitle(newPositionTittle);
        editExp.setCompanyLogo(newCompanyLogo);
        editExp.setDescriptionOfActivities(newDescriptionOfActivities);
        editExp.setStartActivityDate(newStartActivityDate);
        editExp.setEndActivityDate(newEndActivityDate);

        intExperienceService.saveExperience(editExp);
        return editExp;
    }
}
