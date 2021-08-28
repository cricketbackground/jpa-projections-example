package com.projections.example.model;

import java.util.List;

public interface DepartmentProjection {

    String getDepartmentId();

    String getName();

    List<EmployeeProjection> getEmployees();

    interface EmployeeProjection {

        String getEmployeeId();

        String getName();
    }

}
