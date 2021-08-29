package com.projections.example.repository;

import com.projections.example.entity.Department;
import com.projections.example.model.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query(" select department from Department department JOIN FETCH department.employees where department.departmentId = :departmentId")
    List<DepartmentProjection> findDepartmentByDepartmentId(String departmentId);

    @Query(" select department from Department department JOIN FETCH department.employees where department.departmentId = :departmentId")
    List<Department> findByIdFetch(String departmentId);

}
