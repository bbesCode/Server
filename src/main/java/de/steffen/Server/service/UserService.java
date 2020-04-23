package de.steffen.Server.service;

import de.steffen.Server.dao.MongoDataAccessService;
import de.steffen.Server.dao.PersonDao;
import de.steffen.Server.model.Person;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService { //Here is whatever logic that the service requires
    private final MongoDataAccessService MongoDao;

    @Autowired
    public UserService(@Qualifier("Mongodao") MongoDataAccessService MongoDao) {
        this.MongoDao = MongoDao;
    }



    public int addUser(String id, String name){
        return MongoDao.insertUser(id,name);
    }

    public List<Document> getAllUsers(){
        return MongoDao.selectAllUsers();
    }

    public Document getUserById(String id){
        return MongoDao.selectUserById(id);
    }

    public int deleteUser(String id){
        return MongoDao.deleteUserById(id);
    }

    /*public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }*/


}
