package com.backAP.j.controller;

import com.backAP.j.entity.Person;
import com.backAP.j.interfaces.IntPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/persons")
//CORS ERROR, ES PORQUE NO TIENE DIRECCION PERMITIDA PARA ACCEDER AL BACK
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    @Autowired
    public IntPersonService intPersonService;

    @GetMapping("/get")
    public List<Person> getPersons(){
        return intPersonService.getListPerson();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public String savePerson(@RequestBody Person person){
        intPersonService.savePerson(person);
        return "person saved succesfully";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deletePersonById(@PathVariable Integer id){
        intPersonService.deletePersonById(id);
        return "person deleted succesfully";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Person editPersonById(@PathVariable Integer id,
                                 @RequestParam("name") String newName,
                                 @RequestParam("lastName") String newLastName){

        Person person = intPersonService.findPersonById(id);
        person.setName(newName);
        person.setLastName(newLastName);

        intPersonService.savePerson(person);
        return person;
    }



    //http://localhost:8080/persons/findperson/1? PARA PEDIR CON ID 1
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findperson/{id}")
    public Person findPersonById(@PathVariable Integer id){
        Person person = intPersonService.findPersonById(id);
        return person;
    }
}
