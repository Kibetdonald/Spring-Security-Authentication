package com.springauthentication.Implementing.Spring.Security.Controller;

import jakarta.persistence.PostRemove;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @RestControllerAdvice
    public class CORSAdvice {

        @ModelAttribute
        public void setResponseHeader(HttpServletResponse response) {
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
    }

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
//piece of code
       return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    )
    {
        return ResponseEntity.ok(authenticationService.authenticate(request));


    }


}
