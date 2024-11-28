package com.example.maketstock.interfaces;

import com.example.maketstock.models.User;

import java.sql.SQLException;

public interface AuthInterface {
    void register(User user) throws SQLException;
    boolean signIn(User user) throws  SQLException;

}
