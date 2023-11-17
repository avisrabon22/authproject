package com.avijit.authproject.Controller;

import com.avijit.authproject.DTO.RequestLoginDto;
import com.avijit.authproject.DTO.RequestSessionDto;
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
        responseLoginDto.setToken(authInterface.login(requestLoginDto.getEmailId(),requestLoginDto.getPassword(),requestLoginDto.getFullName()));

        return responseLoginDto;
    }

    @GetMapping("/check/{token}")
    public ResponseLoginDto validate(@PathVariable RequestSessionDto token){
        ResponseLoginDto responseLoginDto = new ResponseLoginDto();
        String myToken = token.getToken();
        responseLoginDto.setToken(myToken);

        if(authInterface.validate(myToken)){
            return responseLoginDto;
        }
        responseLoginDto.setToken("No token exist");
        return  responseLoginDto;
    }

}
