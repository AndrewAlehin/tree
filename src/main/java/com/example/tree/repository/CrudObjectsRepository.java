package com.example.tree.repository;

import com.example.tree.model.Objects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public interface CrudObjectsRepository extends JpaRepository<Objects, Integer> {
}
