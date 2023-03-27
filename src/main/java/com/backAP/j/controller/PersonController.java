package com.backAP.j.controller;

import com.backAP.j.entity.Person;
import com.backAP.j.interfaces.IntPersonService;
import com.backAP.j.security.entity.Mensaje;
import com.backAP.j.service.ImpPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/persons")
//CORS ERROR, ES PORQUE NO TIENE DIRECCION PERMITIDA PARA ACCEDER AL BACK
//@CrossOrigin//(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendap-90374.web.app"})

public class PersonController {
    //@Autowired
    //public IntPersonService intPersonService;

    @Autowired
    private ImpPersonService impPersonService;

    @GetMapping("/get")
    public List<Person> getPersons(){
        return impPersonService.getListPerson();
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public String savePerson(@RequestBody Person person){
        impPersonService.savePerson(person);
        return "person saved succesfully";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deletePersonById(@PathVariable Integer id){
        impPersonService.deletePersonById(id);
        return "person deleted succesfully";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Person editPersonById(@PathVariable Integer id,
                                 @RequestParam("name") String newName,
                                 @RequestParam("lastName") String newLastName){

        Person person = impPersonService.findPersonById(id).get();
        person.setName(newName);
        person.setLastName(newLastName);

        impPersonService.savePerson(person);
        return person;
    }



    //http://localhost:8080/persons/findperson/1? PARA PEDIR CON ID 1
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findperson/{id}")
    public ResponseEntity<?> findPersonById(@PathVariable("id")int id){
        if(!impPersonService.existsById(id)){
            return new ResponseEntity(new Mensaje("persona no existe"), HttpStatus.BAD_REQUEST);
        }
        Person person = impPersonService.findPersonById(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
}
