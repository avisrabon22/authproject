package com.avijit.authproject.Controller;


import com.avijit.authproject.DTO.RequestLoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("login")
    public void login(@RequestBody RequestLoginDto requestLoginDto){

    }

    @PostMapping("/valid"  )
    public void validate(){

    }
}
