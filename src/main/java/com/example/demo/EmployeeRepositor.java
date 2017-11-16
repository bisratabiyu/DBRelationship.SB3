package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositor extends CrudRepository<Employee, Long> {
}
