package com.trudvsem.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/creds.properties")
public interface UserCredsConfig extends Config {

    @Key("user.login")
    String userLogin();

    @Key("user.password")
    String userPassword();

}
