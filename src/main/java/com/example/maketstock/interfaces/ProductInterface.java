package com.example.maketstock.interfaces;


import com.example.maketstock.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductInterface {
    List<Product> list() throws SQLException;
    void create(Product product) throws SQLException;
    void update(Product product) throws SQLException;
    void delete(int id) throws SQLException;
}
