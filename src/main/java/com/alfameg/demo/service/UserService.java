package com.alfameg.demo.service;

import com.alfameg.demo.model.User;
import com.alfameg.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public Page<User> findUsers(int size, int page){
        return userRepository.findAll(Pageable.ofSize(size).withPage(page));
    }

    public Page<User> findByPlaceOfBirth(int size, int page, String placeOfBirth) {
        return userRepository.findByPlaceOfBirth(placeOfBirth, Pageable.ofSize(size).withPage(page));
    }

    public Optional<User> updateUser(User newUser) {

        if(userRepository.existsById(newUser.getId())) {
            User userToUpdate = userRepository.findById(newUser.getId()).get();
            userRepository.save(newUser);
            return Optional.of(newUser);
        }

        return Optional.empty();
    }

    public Boolean deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
