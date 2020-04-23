package de.steffen.Server.api;

import com.mongodb.util.JSON;
import de.steffen.Server.model.Person;
import de.steffen.Server.model.UserBox;
import de.steffen.Server.service.PersonService;
import de.steffen.Server.service.UserService;
import org.apache.catalina.User;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/verify")
@RestController
public class VerifyController {

    private final UserService userService;

    @Autowired
    public VerifyController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody UserBox user){

        userService.addUser(user.getId(),user.getName());
    }

    @GetMapping
    public List<Document> getAllPeople(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public Document getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") String id){
        userService.deleteUser(id);
    }

    /*@PutMapping(path = "{id}")
    public void updatePerson(@RequestBody Person person, @Valid @NotNull @PathVariable("id") UUID id){
        personService.updatePerson(id,person);
    }*/
}
