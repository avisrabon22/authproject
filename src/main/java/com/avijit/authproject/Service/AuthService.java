package com.avijit.authproject.Service;

import com.avijit.authproject.Repo.SessionRepo;
import com.avijit.authproject.Repo.UserRepo;

public class AuthService implements AuthInterface{

    private final UserRepo userRepo;
    private SessionRepo sessionRepo;

    public AuthService(UserRepo userRepo, SessionRepo sessionRepo) {
        this.userRepo = userRepo;
        this.sessionRepo = sessionRepo;
    }


    @Override
    public String login(String emailId, String password) {

        return null;
    }

    @Override
    public boolean validate(String token) {


        return false;
    }
}
