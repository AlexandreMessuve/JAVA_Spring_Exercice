package org.exercice05_furniture.service;

import java.util.List;

public interface BaseService <T>{
    void save(T t);
    void update(T t);
    void delete(T t);
    T findById(Long id);
    List<T> findAll();
}
