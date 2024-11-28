package com.example.maketstock.interfaces;

import com.example.maketstock.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserInterface {
    List<User> list() throws SQLException;
}
