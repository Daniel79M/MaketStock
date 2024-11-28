package com.example.maketstock.interfaces;

import com.example.maketstock.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryInterface {
    List<Category> list() throws SQLException;
    void create(Category category) throws SQLException;
    void update(Category category) throws SQLException;
    void delete(int id) throws SQLException;
}
