package com.alfameg.demo.controller;

import com.alfameg.demo.model.User;
import com.alfameg.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
public class UserResourceController {

    @Autowired
    UserService serv;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name="id") long id) {
        Optional<User> opt = serv.findUser(id);
        if(opt.isPresent()) return ResponseEntity.ok(opt.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity<User> insertUser (@RequestBody User user) {
        User userSaved  = serv.addUser(user);
        return ResponseEntity.ok(userSaved);
    }

    @GetMapping("/user")
    public ResponseEntity<Page<User>> getUsers (
            @RequestParam(name="size", defaultValue = "10")int size,
            @RequestParam(name="page", required = true) int page,
            @RequestParam(name="birthPlace", required = false)String placeOfBirth) {
        if(placeOfBirth != "" && placeOfBirth != null)
            return ResponseEntity.ok(serv.findByPlaceOfBirth(size, page, placeOfBirth));
        return ResponseEntity.ok(serv.findUsers(size,page));
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> opt = serv.updateUser(user);
        if(opt.isPresent()) return ResponseEntity.ok(opt.get());
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name="id") long id) {
        if(serv.deleteUser(id)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

}
