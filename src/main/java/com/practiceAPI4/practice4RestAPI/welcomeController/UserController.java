package com.practiceAPI4.practice4RestAPI.welcomeController;

import com.practiceAPI4.practice4RestAPI.entity.Users;
import com.practiceAPI4.practice4RestAPI.exception.UserNotFoundException;
import com.practiceAPI4.practice4RestAPI.services.UserDoaService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.MvcLink;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {
    private UserDoaService userDoaService;

    public UserController(UserDoaService userDoaService) {
        this.userDoaService = userDoaService;
    }
    @GetMapping("/users")
    public List<Users> retrieveAllUsers(){
        return userDoaService.findAll();
    }
    @GetMapping("/users/{id}")
    public EntityModel<Users> findAllById(@PathVariable int id) throws UserNotFoundException {
        Users user = userDoaService.findeById(id);
        EntityModel entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-user"));
        return entityModel;
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable int id) throws UserNotFoundException {
        userDoaService.deleteById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user){

       Users savedUser= userDoaService.save(user);
//       when the new user cdreate retune the new url users/new id
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
