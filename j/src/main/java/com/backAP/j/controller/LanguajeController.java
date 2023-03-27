package com.backAP.j.controller;

import com.backAP.j.entity.Languaje;
import com.backAP.j.interfaces.IntLanguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@Controller
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendap-90374.web.app"})

@RequestMapping("/languaje")
public class LanguajeController {
    @Autowired
    public IntLanguajeService intLanguajeService;

    @GetMapping("/get")
    public List<Languaje> getListLanguaje(){
        List<Languaje> sksList = intLanguajeService.getListLanguaje();
        return sksList;
    }

    @PostMapping("/save")
    public String saveLanguaje(@RequestBody Languaje languaje){
        intLanguajeService.saveLanguaje(languaje);
        return "Skill data saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLanguajeById(@PathVariable Integer id){
        intLanguajeService.deleteLanguajeById(id);
        return "Skill data deleted succesfully";
    }

    @GetMapping("/getaLanguaje/{id}")
    public Languaje getLanguajeById(Integer id){
        Languaje lan = intLanguajeService.findLanguajeById(id);
        return lan;
    }

    //http://localhost:8080/languaje/edit/1? PARA PEDIR CON ID 1
    @PutExchange("/edit/{id}")
    public Languaje editLanguajeById(@PathVariable Integer id,
                                     @RequestParam("languaje") String newLanguaje,
                                     @RequestParam("lanjuageDomain") String newLanjuageDomain,
                                     @RequestParam("lanjuageDomainNumber") Integer newLanjuageDomainNumber){
        Languaje editLan = intLanguajeService.findLanguajeById(id);

        editLan.setLanguaje(newLanguaje);
        editLan.setLanjuageDomain(newLanjuageDomain);
        editLan.setLanjuageDomainNumber(newLanjuageDomainNumber);

        intLanguajeService.saveLanguaje(editLan);
        return editLan;
    }
}
