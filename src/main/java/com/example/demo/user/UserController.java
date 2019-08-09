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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    UserRepository userRepo;

    //    @GetMapping(value = "/all")
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().forEach(list::add);
        return list;
    }

    //    @GetMapping(value = "/{id}")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<User> get(@PathVariable int id) {
        return userRepo.findById(id);
    }

    //    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userRepo.save(user);
    }

    //    @PutMapping
    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        return userRepo.save(user);
    }

    //    @DeleteMapping
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody User user) {
        userRepo.delete(user);
    }

    //    @DeleteMapping(value = "/{id}")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable int id) {
        userRepo.deleteById(id);
    }
}