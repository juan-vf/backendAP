package com.backAP.j.security.service;

import com.backAP.j.security.entity.User;
import com.backAP.j.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService{
    @Autowired
    UserRepository userRepository;

    public Optional<User> getByUserName(String userName){

        return userRepository.findByUserName(userName);
    }

    public boolean existByUserName(String userName){

        return userRepository.existsByUserName(userName);
    }
    public boolean existByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
