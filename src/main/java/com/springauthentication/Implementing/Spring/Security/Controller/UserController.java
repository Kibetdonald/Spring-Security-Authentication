package com.springauthentication.Implementing.Spring.Security.Controller;

import com.springauthentication.Implementing.Spring.Security.Model.User;
import com.springauthentication.Implementing.Spring.Security.Repository.GetUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth/user")
public class UserController {
    @Autowired
private GetUsersRepository userRepo;
    @GetMapping("hey")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hey there");
    }
    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepo.findAll());
    }



}
