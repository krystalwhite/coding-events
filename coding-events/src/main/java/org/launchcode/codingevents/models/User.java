package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity{
    @NotNull
    private String username;

    @NotNull
    private String pwHash;

//    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = password;
    }

    public String getUsername() {
        return username;
    }

}

