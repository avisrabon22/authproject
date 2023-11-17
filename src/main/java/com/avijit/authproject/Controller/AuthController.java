package com.avijit.authproject.Controller;

import com.avijit.authproject.DTO.RequestLoginDto;
import com.avijit.authproject.DTO.RequestSessionDto;
import com.avijit.authproject.DTO.ResponseLoginDto;
import com.avijit.authproject.Service.AuthService;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/home")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth")
    public ResponseLoginDto login(@RequestBody RequestLoginDto requestLoginDto){
//        System.out.println("In log");
        String emailId=requestLoginDto.getEmailId();
        String password  = requestLoginDto.getPassword();
        String fullName = requestLoginDto.getFullName();


        ResponseLoginDto responseLoginDto = new ResponseLoginDto();
        responseLoginDto.setToken(authService.login(emailId,password,fullName));

        return responseLoginDto;
    }


    @GetMapping("/check/{token}")
    public ResponseLoginDto validate(@PathVariable RequestSessionDto token){
        ResponseLoginDto responseLoginDto = new ResponseLoginDto();
        String myToken = token.getToken();
        responseLoginDto.setToken(myToken);

        if(authService.validate(myToken)){
            return responseLoginDto;
        }
        responseLoginDto.setToken("No token exist");
        return  responseLoginDto;
    }

}
