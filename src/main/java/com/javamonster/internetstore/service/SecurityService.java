package com.javamonster.internetstore.service;

public interface SecurityService {
    String findLoggedInName();

    void autologin(String name, String password);
}
