package ru.tele2.config;


public class UserCredsJen {

    private final String LOGIN = System.getProperty("login", "admin");
    private final String PASSWORD = System.getProperty("password", "admin");
}
