package com.hafnium.School.service;

import com.hafnium.School.converter.SchoolConverter;
import com.hafnium.School.dto.request.SchoolRequest;
import com.hafnium.School.dto.response.SchoolCreateResponse;
import com.hafnium.School.exception.SchoolAlreadyExistsException;
import com.hafnium.School.model.School;
import com.hafnium.School.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    public SchoolCreateResponse createSchool(SchoolRequest request) {
        Optional<School> schoolByName = schoolRepository.findBySchoolName(request.getSchoolName());
        if(schoolByName.isPresent()){
            throw new SchoolAlreadyExistsException("School already exists with name:" +
                    request.getSchoolName());
        }
        return SchoolConverter.converToSchoolCreateResponse
                (schoolRepository.save(SchoolConverter.converToSchool(request)));

    }
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

}
