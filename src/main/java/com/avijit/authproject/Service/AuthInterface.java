package com.avijit.authproject.Service;

public interface AuthInterface {
    String login(String emailId,String password);
    boolean validate(String emailId,String password);
}
