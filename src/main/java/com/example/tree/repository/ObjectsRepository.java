package com.example.tree.repository;

import com.example.tree.model.Objects;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjectsRepository {

    private final CrudObjectsRepository crudRepository;

    public ObjectsRepository(CrudObjectsRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Objects> getAll() {
        return crudRepository.findAll();
    }
}