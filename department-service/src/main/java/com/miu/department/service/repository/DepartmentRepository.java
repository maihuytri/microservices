package com.miu.department.service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.miu.department.service.service.Department;

@Repository
public class DepartmentRepository {
    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departments.stream().filter(d -> d.getId() == id).findFirst().orElseThrow();
    }

    public List<Department> findAll() {
        return departments;
    }
}