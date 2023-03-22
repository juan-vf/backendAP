package com.backAP.j.interfaces;

import com.backAP.j.entity.Person;

import java.util.List;

public interface IntPersonService {
    //get person List
    public List<Person> getListPerson();

    //save person class
    public void savePerson(Person person);

    //delete person
    public void deletePersonById(Integer id);

    //find person by id
    public Person findPersonById(Integer id);
}
