package com.avijit.authproject.Service;


import com.avijit.authproject.Model.Session;
import com.avijit.authproject.Model.User;
import com.avijit.authproject.Repo.SessionRepo;
import com.avijit.authproject.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService implements AuthInterface{
    private final SessionRepo sessionRepo;
    private final UserRepo userRepo;

    public AuthService(SessionRepo sessionRepo, UserRepo userRepo) {
        this.sessionRepo = sessionRepo;
        this.userRepo = userRepo;
    }


    @Override
    public String login(String emailId,String password,String fullName) {
        User user = new User();
        user.setEmailId(emailId);
        user.setPassword(password);
        user.setFullName(fullName);
        userRepo.save(user);
        String token=TokenGenrator.generateRandomString(20);
        Session session = new Session();
        session.setToken(token);
        session.setUser(user);
        sessionRepo.save(session,user);
        return token;
    }

    @Override
    public boolean validate(String token) {
        List<Session> sessions = new ArrayList<>();
        sessions = sessionRepo.findAll();
        for(Session session:sessions){
            if(session.getToken().equals(token)){
                return false;
            }
        }
        return true;
    }
}
