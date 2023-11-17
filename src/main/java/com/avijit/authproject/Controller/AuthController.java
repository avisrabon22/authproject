package com.avijit.authproject.Controller;


import com.avijit.authproject.DTO.RequestLoginDto;
import com.avijit.authproject.DTO.ResponseLoginDto;
import com.avijit.authproject.Service.AuthInterface;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class AuthController {
    private final AuthInterface authInterface;

    public AuthController(AuthInterface authInterface) {
        this.authInterface = authInterface;
    }


    @PostMapping("/auth")
    public ResponseLoginDto login(@RequestBody RequestLoginDto requestLoginDto){
//        System.out.println("In log");
        ResponseLoginDto responseLoginDto = new ResponseLoginDto();
        responseLoginDto.setToken(authInterface.login(requestLoginDto.getEmailId(),requestLoginDto.getPassword()));

        return responseLoginDto;

    }


    @GetMapping("/check")
    public ResponseLoginDto validate(){
        return  null;
    }


}
