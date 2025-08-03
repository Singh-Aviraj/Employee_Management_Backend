package com.project.EmployeeManagement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/employees")
public class Controller {
    public final Services services;
    public Controller(Services services) {
        this.services = services;
    }

    @PostMapping("/create")
    public Entities createEmployee(@RequestBody Entities employee) {
        return services.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public  Entities getEmployee(@PathVariable int id) {
        return services.getEmployeeById((long) id);
    }

    @GetMapping
    public List<Entities> getAllEmployees() {
        return services.getAllEmployees();
    }
    @PutMapping("/{id}")
    public Entities updateEmployee(@PathVariable int id, @RequestBody Entities employeeDetails) {
        return services.updateEmployee((long) id, employeeDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        services.deleteEmployee((long) id);
    }
    @GetMapping("/search")
    public List<Entities> searchEmployees(@RequestParam String name) {
        return services.findByName(name);
    }
}
