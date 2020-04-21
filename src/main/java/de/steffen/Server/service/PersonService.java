package de.steffen.Server.service;

import de.steffen.Server.dao.PersonDao;
import de.steffen.Server.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService { //Here is whatever logic that the service requires
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }



    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }


}
