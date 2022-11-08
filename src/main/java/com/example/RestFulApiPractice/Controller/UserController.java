package com.example.RestFulApiPractice.Controller;

import com.example.RestFulApiPractice.Entities.User;
import com.example.RestFulApiPractice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> FindAllUser(){
        return userService.findallusers();
    }

    @GetMapping("/users/{id}")
    public User findone(@PathVariable int id) {
        User user=userService.FindOne(id);
         return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> SaveUser(@Valid @RequestBody User user){
        User saveduser=userService.saveuser(user);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(saveduser.getId())
                .toUri();
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
