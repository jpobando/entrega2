package com.ias.crudjp.controller;

import com.ias.crudjp.dto.SubjectDTO;
import com.ias.crudjp.service.ISubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final ISubjectService iSubjectService;

    public SubjectController(ISubjectService iSubjectService) { this.iSubjectService = iSubjectService; }

    @GetMapping()
    public ResponseEntity<?> getSubjectAll(){
        return ResponseEntity
                .ok()
                .body(iSubjectService.getAllSubjects());
    }

    @PostMapping()
    public ResponseEntity<?>
    saveSubject(@RequestBody SubjectDTO subject) {
        iSubjectService.saveSubject(subject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?>
    updateSubject(@RequestBody SubjectDTO subject){
        return new ResponseEntity<>( iSubjectService.updateSubject(subject), HttpStatus.CREATED);
    }
}
