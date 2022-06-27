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
        return userDaoService.findAll();

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


    //TO return the saved user URI back to the client
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();

    }

}
