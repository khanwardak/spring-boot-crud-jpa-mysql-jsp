package com.practiceAPI4.practice4RestAPI.welcomeController;

import com.practiceAPI4.practice4RestAPI.entity.Users;
import com.practiceAPI4.practice4RestAPI.exception.UserNotFoundException;
import com.practiceAPI4.practice4RestAPI.services.UserDoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public List<Users> findAllById(@PathVariable int id) throws UserNotFoundException {
        return userDoaService.findById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody Users user){

       Users savedUser= userDoaService.save(user);
//       when the new user cdreate retune the new url users/new id
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
