package com.projections.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projections.example.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HelloResponse {

    private List<Department> departments;

}
