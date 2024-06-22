package com.hafnium.School.controller;

import com.hafnium.School.dto.request.SchoolRequest;
import com.hafnium.School.dto.response.SchoolResponse;
import com.hafnium.School.exception.SchoolAlreadyExistsException;
import com.hafnium.School.exception.SchoolNotFoundException;
import com.hafnium.School.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;
    @PostMapping
    public SchoolResponse createSchool(@RequestBody SchoolRequest request){
        return schoolService.createSchool(request);
    }
    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id){
        schoolService.deleteSchool(id);
    }
    @GetMapping("/{id}")
    public SchoolResponse getSchoolById(@PathVariable Long id){
        return schoolService.getSchoolById(id);
    }
    @PutMapping("/{id}")
    public void updateSchool(@PathVariable Long id, @RequestBody SchoolRequest request){
        schoolService.updateSchool(id, request);

    }

    @ExceptionHandler(SchoolAlreadyExistsException.class)
    public ResponseEntity<String> handleSchoolAlreadyExistsException(SchoolAlreadyExistsException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(SchoolNotFoundException.class)
    public ResponseEntity<String> handleSchoolNotFoundException(SchoolNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
