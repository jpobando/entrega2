package com.ias.crudjp.controller;

import com.ias.crudjp.dto.StudentDTO;
import com.ias.crudjp.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) { this.iStudentService = iStudentService; }

    @GetMapping()
    public ResponseEntity<?> getStudentAll(){
        return ResponseEntity
                .ok()
                .body(iStudentService.getAllStudents());
    }

    @PostMapping()
    public ResponseEntity<?>
    saveStudent(@RequestBody StudentDTO student){
        iStudentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?>
    updateStudent(@RequestBody StudentDTO student){
        return new ResponseEntity<>( iStudentService.updateStudent(student), HttpStatus.CREATED );
    }

}
