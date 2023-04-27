package com.backAP.j.controller;

import com.backAP.j.Dto.DtoLanguaje;
import com.backAP.j.Dto.DtoSkill;
import com.backAP.j.entity.Languaje;
import com.backAP.j.entity.Skill;
import com.backAP.j.interfaces.IntLanguajeService;
import com.backAP.j.security.entity.Mensaje;
import com.backAP.j.service.ImpLanguajeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendap-90374.web.app"})
@RequestMapping("/languaje")
public class LanguajeController {
    //@Autowired
    //public IntLanguajeService intLanguajeService;
    @Autowired
    ImpLanguajeService impLanguajeService;

    @GetMapping("/get")
    public ResponseEntity<List<Languaje>> getListLanguaje(){
        List<Languaje> langList = impLanguajeService.getListLanguaje();
        return new ResponseEntity(langList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveLanguaje(@RequestBody DtoLanguaje dtoLanguaje){
        if(StringUtils.isBlank(dtoLanguaje.getLanguaje())){
            return new ResponseEntity<>(new Mensaje("the Languaje is required"), HttpStatus.BAD_REQUEST);
        }
        if(impLanguajeService.existByLanguaje(dtoLanguaje.getLanguaje())){
            return new ResponseEntity(new Mensaje("that languaje already exist"), HttpStatus.BAD_REQUEST);
        }
        Languaje languaje = new Languaje(dtoLanguaje.getLanguaje(), dtoLanguaje.getLanjuageDomain(), dtoLanguaje.getLanjuageDomainNumber());
        impLanguajeService.saveLanguaje(languaje);
        return new ResponseEntity(new Mensaje("Languaje data saved succesfully"), HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLanguajeById(@PathVariable("id") int id){
        if(!impLanguajeService.existsById(id)){
            new ResponseEntity(new Mensaje("Languaje id not exist"), HttpStatus.BAD_REQUEST);
        }
        impLanguajeService.deleteLanguajeById(id);
        return new ResponseEntity(new Mensaje("deleted languaje"), HttpStatus.OK);
    }

    @GetMapping("/getaLanguaje/{id}")
    public ResponseEntity<Languaje> getLanguajeById(@PathVariable("id") int id){
        if(!impLanguajeService.existsById(id)){
            new ResponseEntity(new Mensaje("Languaje id not exist"), HttpStatus.BAD_REQUEST);
        }
        Languaje lan = impLanguajeService.findLanguajeById(id).get();
        return new ResponseEntity(lan, HttpStatus.OK);
    }

    //http://localhost:8080/languaje/edit/1? PARA PEDIR CON ID 1
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editLanguajeById(@PathVariable("id") int id,
                                              @RequestBody DtoLanguaje dtoLanguaje){

        if(!impLanguajeService.existsById(id)){
            new ResponseEntity(new Mensaje("Languaje id not exist"), HttpStatus.BAD_REQUEST);
        }
        if(impLanguajeService.existByLanguaje(dtoLanguaje.getLanguaje()) && impLanguajeService.getByLanguaje(dtoLanguaje.getLanguaje()).get().getId() != id){
            new ResponseEntity(new Mensaje("Languaje already exist"), HttpStatus.BAD_REQUEST) ;
        }

        if(StringUtils.isBlank(dtoLanguaje.getLanguaje())){
            new ResponseEntity(new Mensaje("the Languaje is required"), HttpStatus.BAD_REQUEST) ;
        }

        Languaje editLan = impLanguajeService.findLanguajeById(id).get();

        editLan.setLanguaje(dtoLanguaje.getLanguaje());
        editLan.setLanjuageDomain(dtoLanguaje.getLanjuageDomain());
        editLan.setLanjuageDomainNumber(dtoLanguaje.getLanjuageDomainNumber());

        impLanguajeService.saveLanguaje(editLan);
        return new ResponseEntity(new Mensaje("updated and saved Languaje"), HttpStatus.OK) ;
    }
}
