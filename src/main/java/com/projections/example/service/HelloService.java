package com.projections.example.service;

import com.projections.example.entity.Department;
import com.projections.example.model.DepartmentProjection;
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

    public List<DepartmentProjection> fetch(String departmentId) {
        return departmentRepository.findDepartmentByDepartmentId(departmentId);
    }

    public List<DepartmentProjection> fetchAsync(String departmentId) {
        return supplyAsync(() -> departmentRepository.findDepartmentByDepartmentId(departmentId))
                .thenApplyAsync(departments -> departments).join();
    }

    public List<Department> fetchAsyncFull(String departmentId) {
        return supplyAsync(() -> departmentRepository.findByIdFetch(departmentId))
                .thenApplyAsync(departments -> departments).join();
    }
}
