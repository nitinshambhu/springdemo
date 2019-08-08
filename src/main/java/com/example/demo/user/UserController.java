package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().forEach(list::add);
        return list;
    }

    @GetMapping(value = "/{id}")
    public Optional<User> get(@PathVariable int id) {
        return userRepo.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userRepo.save(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        userRepo.delete(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable int id) {
        userRepo.deleteById(id);
    }
}