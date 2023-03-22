package com.backAP.j.service;

import com.backAP.j.entity.Person;
import com.backAP.j.interfaces.IntPersonService;
import com.backAP.j.repository.IntPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImpPersonService implements IntPersonService {

    @Autowired
    public IntPersonRepository intPersonRepository;


    @Override
    public List<Person> getListPerson() {
        List<Person> persons = intPersonRepository.findAll();
        return persons;
    }

    @Override
    public void savePerson(Person person) {
        intPersonRepository.save(person);
    }

    @Override
    public void deletePersonById(Integer id) {
        intPersonRepository.deleteById(id);
    }

    @Override
    public Person findPersonById(Integer id) {
        Person person = intPersonRepository.findById(id).orElse(null);
        return person;
    }


}
