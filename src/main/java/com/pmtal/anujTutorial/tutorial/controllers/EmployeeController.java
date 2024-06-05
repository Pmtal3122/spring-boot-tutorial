package com.pmtal.anujTutorial.tutorial.controllers;

import com.pmtal.anujTutorial.tutorial.dto.EmployeeDTO;
import com.pmtal.anujTutorial.tutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Operations:
 * GET /employees
 * POST /employees
 * DELETE /employees/{id}
 */

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById (@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}
