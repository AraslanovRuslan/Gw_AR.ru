package com.trudvsem.config;

import org.aeonbits.owner.ConfigFactory;

public class UserCreds {

    private static final UserCredsConfig USER_CREDS_CONFIG = ConfigFactory
            .create(UserCredsConfig.class, System.getProperties());

    public static final String USER_LOGIN = USER_CREDS_CONFIG.userLogin();
    public static final String USER_PASSWORD = USER_CREDS_CONFIG.userPassword();
}
