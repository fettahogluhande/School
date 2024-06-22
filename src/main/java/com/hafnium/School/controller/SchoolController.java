package com.hafnium.School.controller;

import com.hafnium.School.dto.request.SchoolRequest;
import com.hafnium.School.dto.response.SchoolCreateResponse;
import com.hafnium.School.model.School;
import com.hafnium.School.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;
    @PostMapping
    public SchoolCreateResponse createSchool(@RequestBody SchoolRequest request){
        return schoolService.createSchool(request);
    }
    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id){
        schoolService.deleteSchool(id);
    }

}
