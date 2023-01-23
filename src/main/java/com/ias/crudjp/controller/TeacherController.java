package com.ias.crudjp.controller;

import com.ias.crudjp.dto.TeacherDTO;
import com.ias.crudjp.service.ITeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final ITeacherService iTeacherService;

    //Inyección de dependencias
    public TeacherController(ITeacherService iTeacherService) { this.iTeacherService = iTeacherService; }

    @GetMapping()
    public ResponseEntity<?> getTeacherAll(){
        return ResponseEntity
                .ok()
                .body(iTeacherService.getAllTeachers());
    }

    @PostMapping()
    public ResponseEntity<?>
    saveTeacher(@RequestBody TeacherDTO teacher){
        iTeacherService.saveTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?>
    updateTeacher(@RequestBody TeacherDTO teacher){
        return new ResponseEntity<>( iTeacherService.updateTeacher(teacher), HttpStatus.CREATED);
    }
}
