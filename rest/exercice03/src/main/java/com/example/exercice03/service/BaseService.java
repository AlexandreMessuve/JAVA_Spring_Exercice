package com.example.exercice03.service;

import java.util.List;

public interface BaseService <TGet,TPost> {
    TGet findById(int id);
    TGet create(TPost post);
    TGet update(int id,TPost post);
    boolean delete(int id);
    List<TGet> findAll();

}
