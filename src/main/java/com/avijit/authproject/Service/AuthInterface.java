package com.avijit.authproject.Service;

public interface AuthInterface {
    String login(String emailId,String password,String fullName);
    boolean validate(String token);
}
