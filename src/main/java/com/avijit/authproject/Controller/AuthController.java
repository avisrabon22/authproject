package com.avijit.authproject.Controller;

import com.avijit.authproject.DTO.RequestLoginDto;
import com.avijit.authproject.DTO.RequestSessionDto;
import com.avijit.authproject.DTO.ResponseLoginDto;
import com.avijit.authproject.Service.AuthInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class AuthController {
    private final AuthInterface authInterface;

    @Autowired
    public AuthController(AuthInterface authInterface) {
        this.authInterface = authInterface;
    }


    @PostMapping("/auth")
    public ResponseEntity<ResponseLoginDto> login(@RequestBody RequestLoginDto requestLoginDto){
        System.out.println("In log");
        ResponseLoginDto responseLoginDto = new ResponseLoginDto();
        responseLoginDto.setToken(authInterface.login(requestLoginDto.getEmailId(),requestLoginDto.getPassword(),requestLoginDto.getFullName()));



        return new ResponseEntity<> (responseLoginDto, HttpStatus.CREATED);
    }

    @GetMapping("/check/{token}")
    public boolean validate(@PathVariable("token") String token){
        return authInterface.validate(token);
    }

}
