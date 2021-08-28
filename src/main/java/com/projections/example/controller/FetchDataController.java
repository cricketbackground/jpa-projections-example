package com.projections.example.controller;

import com.projections.example.model.DepartmentProjection;
import com.projections.example.model.HelloResponse;
import com.projections.example.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@RequiredArgsConstructor
@Slf4j
public class FetchDataController {

    private final HelloService helloService;

    @GetMapping(path = "fetch")
    public ResponseEntity<List<DepartmentProjection>> fetch() {
        log.info("Fetch service called");
        return ResponseEntity.ok(helloService.fetch());
    }

    @GetMapping(path = "fetchasync")
    public ResponseEntity<List<DepartmentProjection>> fetchAsync() {
        log.info("Fetch service called");
        return ResponseEntity.ok(helloService.fetchAsync());
    }

}