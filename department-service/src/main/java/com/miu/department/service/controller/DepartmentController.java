package com.miu.department.service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.miu.department.service.client.EmployeeClient;
import com.miu.department.service.repository.DepartmentRepository;
import com.miu.department.service.service.Department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping()
    public Department addDepartment(@RequestBody Department department) {
        return departmentRepository.addDepartment(department);
    }

    @GetMapping()
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployee() {
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
        return departments;
    }
}
