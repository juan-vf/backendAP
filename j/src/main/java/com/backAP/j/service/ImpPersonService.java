package com.backAP.j.service;

import com.backAP.j.entity.Person;
import com.backAP.j.interfaces.IntPersonService;
import com.backAP.j.repository.IntPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ImpPersonService{

    @Autowired
    public IntPersonRepository intPersonRepository;


    public List<Person> getListPerson() {
        List<Person> persons = intPersonRepository.findAll();
        return persons;
    }

    public void savePerson(Person person) {
        intPersonRepository.save(person);
    }

    public void deletePersonById(Integer id) {
        intPersonRepository.deleteById(id);
    }

    public Optional<Person> findPersonById(Integer id) {
        return intPersonRepository.findById(id);
    }

    public boolean existsByName(String name){
        return intPersonRepository.existsByName(name);
    }

    public boolean existsById(int id){
        return intPersonRepository.existsById(id);
    }

    public Optional<Person> getByName(String name){
        return intPersonRepository.findByName(name);
    }

}
