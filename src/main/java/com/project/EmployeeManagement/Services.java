package com.project.EmployeeManagement;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {
    private final Repository repository;

    public Services(Repository repository) {
        this.repository = repository;
    }
    public Entities createEmployee(Entities employee) {
        return repository.save(employee);
    }
    public Entities getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow();
    }
    public Entities updateEmployee(Long id, Entities employeeDetails) {
        Entities employee = repository.findById(id).orElseThrow();
        employee.setName(employeeDetails.getName());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
        return repository.save(employee);
    }
    public List<Entities> getAllEmployees() {
        return repository.findAll();
    }

    public void deleteEmployee(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        repository.deleteById(id);

    }
    public List<Entities> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }



}
