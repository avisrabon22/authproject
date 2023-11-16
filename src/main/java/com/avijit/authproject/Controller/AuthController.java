package com.avijit.authproject.Controller;


import com.avijit.authproject.DTO.RequestLoginDto;
import com.avijit.authproject.DTO.ResponseLoginDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class AuthController {
    @PostMapping("/auth")
    public ResponseLoginDto login(){
//        System.out.println("In log");

        ResponseLoginDto responseLoginDto = new ResponseLoginDto();
        responseLoginDto.setToken("mytoken");

        return responseLoginDto;
    }


    @GetMapping("/check")
    public ResponseLoginDto validate(){
        return  null;
    }


}
