package com.bhanu.workbook.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class BooleanExampleController {
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Student student) {
        System.out.println(student.isAmended());
        System.out.println(student.isExpress());
        return ResponseEntity.ok(student);
    }
}
