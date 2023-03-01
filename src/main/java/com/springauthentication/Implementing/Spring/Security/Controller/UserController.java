package com.springauthentication.Implementing.Spring.Security.Controller;

import com.springauthentication.Implementing.Spring.Security.Exception.UserNotFoundException;
import com.springauthentication.Implementing.Spring.Security.Model.User;
import com.springauthentication.Implementing.Spring.Security.Repository.GetUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/user")
public class UserController {
    @Autowired
private GetUsersRepository userRepo;

//    Fetch all users
    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepo.findAll());
    }
    //Update users
    @PutMapping("/update/users/{id}")
    @CrossOrigin("http://localhost:3000")
    User updateUsers(@RequestBody User newUser, @PathVariable Integer id){
        return userRepo.findById(id).map(users -> {
            users.setFirstName(newUser.getFirstName());
            users.setLastName(newUser.getLastName());
            users.setEmail(newUser.getEmail());
            users.setPassword(newUser.getPassword());

            return userRepo.save(users);
        }).orElseThrow(()->new UserNotFoundException(id));
    }
//    Fetch user based on id
    @GetMapping("/users/{id}")
    @CrossOrigin("http://localhost:3000")
    User getUserById(@PathVariable Integer id){
        return userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }
    //Delete user method
    @DeleteMapping("/delete/user/{id}")
    @CrossOrigin("http://localhost:3000")
    String deleteUser(@PathVariable Integer id){
        if(!userRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepo.deleteById(id);
        return "User with id " +id+ " has been deleted sucessfully. ";
    }
}
