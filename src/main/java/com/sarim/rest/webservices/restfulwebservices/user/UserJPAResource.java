package com.sarim.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
         List<User> users = userRepository.findAll();
         if(users.isEmpty()){
             throw new UserNotFoundException("No user found");
         }
         return users;

    }

    //Entity model is to provide a link to other resources/controllers
    //Similarly WebMVcBuilder helps to build a link to another resource/controller
    @GetMapping("/jpa/users/{id}")
    public EntityModel<Optional<User>> retrieveUser(@PathVariable int id){
         Optional<User> user = userRepository.findById(id);

         if(!user.isPresent()){
             throw new UserNotFoundException("id-"+id);
         }
         EntityModel<Optional<User>> model = EntityModel.of(user);

         WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

         model.add(linkToUsers.withRel("all-users"));

         return model;

    }

    //Post request with http response type - 201 Created
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser( @RequestBody User user){
        User savedUser = userRepository.save(user);


    //TO return the saved user(Created response) URI back to the client
        //1: creating URI
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();//created status code

    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);

    }





}
