package com.miu.employee.service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.miu.employee.service.model.Employee;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee Employee) {
        employees.add(Employee);
        return Employee;
    }

    public Employee findById(Long id) {
        return employees.stream().filter(d -> d.id() == id).findFirst().orElseThrow();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream().filter(a -> a.departmentId() == departmentId).toList();
    }
}
