package com.projections.example.service;

import com.projections.example.entity.Department;
import com.projections.example.model.DepartmentProjection;
import com.projections.example.model.HelloResponse;
import com.projections.example.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Service
@Slf4j
@RequiredArgsConstructor
public class HelloService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentProjection> fetch() {

        return departmentRepository.findDepartmentByDepartmentId("ff8080817b8ece9b017b8eceb15e0000");


    }

    public List<DepartmentProjection> fetchAsync() {

        return supplyAsync(() -> departmentRepository.findDepartmentByDepartmentId("ff8080817b8ece9b017b8eceb15e0000"))
                .thenApplyAsync(departments -> {
                    return departments;
                }).join();


    }
}
