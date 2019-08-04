package com.example.demo.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(value = "/all")
    public List<User> getUsers() {
        // List<User> list = new ArrayList<>();    @ResponseBody
        // userRepo.findAll().forEach(list::add);
        return Arrays.asList(new User(101, "Shri Hari", 100)) ;
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userRepo.findById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping
    public User updateUser(User user) {
        return userRepo.save(user);
    }
}