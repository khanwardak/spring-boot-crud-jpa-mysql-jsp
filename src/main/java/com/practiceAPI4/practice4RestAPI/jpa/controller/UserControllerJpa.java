package com.practiceAPI4.practice4RestAPI.jpa.controller;

import com.practiceAPI4.practice4RestAPI.entity.Post;
import com.practiceAPI4.practice4RestAPI.entity.Users;
import com.practiceAPI4.practice4RestAPI.exception.UserNotFoundException;
import com.practiceAPI4.practice4RestAPI.jpa.repository.PostRepository;
import com.practiceAPI4.practice4RestAPI.jpa.userRepository;
import com.practiceAPI4.practice4RestAPI.services.UserDoaService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
public class UserControllerJpa {
    private UserDoaService userDoaService;
    private userRepository repository;
    private PostRepository postRepository;

    public UserControllerJpa(UserDoaService userDoaService, userRepository repository, PostRepository postRepository) {
        this.userDoaService = userDoaService;
        this.repository =repository;
        this.postRepository= postRepository;
    }
    @GetMapping("jpa/users")
    public List<Users> retrieveAllUsers(){
        return repository.findAll();
    }
    @GetMapping("jpa/users/{id}")
    public EntityModel<Users> findAllById(@PathVariable int id) throws UserNotFoundException {
        Optional<Users> user = repository.findById(id);
        EntityModel entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-user"));
        return entityModel;
    }

    @DeleteMapping("jpa/users/{id}")
    public void deleteById(@PathVariable int id) throws UserNotFoundException {
        repository.deleteById(id);
    }
//    get posts for a user method
    @GetMapping("jpa/users/{id}/post")
    public List<Post> getPostForAuser(@PathVariable int id) throws UserNotFoundException {

        Optional<Users> user = repository.findById(id);
        if (user.isEmpty())
            throw  new UserNotFoundException("the user with"+" "+id+" "+ "not found");

        return user.get().getPosts();

    }

//    create posts for a user method

    @PostMapping ("jpa/users/{id}/post")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post ) throws UserNotFoundException {

        Optional<Users> user = repository.findById(id);
        if (user.isEmpty())
            throw  new UserNotFoundException("the user with"+" "+id+" "+ "not found");
        post.setUser(user.get());
        Post savePost=  postRepository.save(post);

//        create url to retrieve the current user

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savePost.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }
    @PostMapping("jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user){

        Users savedUser= repository.save(user);
//       when the new user cdreate retune the new url users/new id
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
