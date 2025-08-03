package com.project.EmployeeManagement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Entities, Long> {
    List<Entities> findByNameContainingIgnoreCase(String name);
}
