package com.projections.example.controller;

import com.projections.example.entity.Department;
import com.projections.example.entity.Employee;
import com.projections.example.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.stream.IntStream;

@RestController
@RequestMapping(path = "api")
@RequiredArgsConstructor
public class CreateTestDataController {

    private final DepartmentRepository departmentRepository;

    @PostMapping(path = "insertdata")
    public ResponseEntity<String> create() {
        Department department = Department.builder().departmentId(getUuid()).name("D-" + random()).createdBy("john.doe").build();
        IntStream.range(1, 80).forEach(index -> {
            department.addEmployee(Employee.builder().employeeId(getUuid()).name("E-" + random() + "-" + 1).createdBy("john.doe").build());
        });
        departmentRepository.save(department);

        return ResponseEntity.ok("hello");
    }

    private String getUuid() {
        return UUID.randomUUID().toString();
    }

    private String random() {
        return RandomStringUtils.randomAlphabetic(20);
    }


}