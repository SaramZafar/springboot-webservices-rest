package com.sarim.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
         List<User> users = userDaoService.findAll();
         if(users.isEmpty()){
             throw new UserNotFoundException("No user found");
         }
         return users;

    }
    @GetMapping("users/{id}")
    public User retrieveUser(@PathVariable int id){
         User user = userDaoService.findOne(id);

         if(user == null){
             throw new UserNotFoundException("id-"+id);
         }
         return user;

    }

    //Post request with http response type - 201 Created
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDaoService.save(user);


    //TO return the saved user(Created response) URI back to the client
        //1: creating URI
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();//created status code

    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.deleteById(id);

        if(user == null){
            throw new UserNotFoundException("id-"+id);
        }


    }





}
