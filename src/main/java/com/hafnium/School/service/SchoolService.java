package com.hafnium.School.service;

import com.hafnium.School.converter.SchoolConverter;
import com.hafnium.School.dto.request.SchoolRequest;
import com.hafnium.School.dto.response.SchoolResponse;
import com.hafnium.School.exception.SchoolAlreadyExistsException;
import com.hafnium.School.exception.SchoolNotFoundException;
import com.hafnium.School.model.School;
import com.hafnium.School.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    public SchoolResponse createSchool(SchoolRequest request) {
        Optional<School> schoolByName = schoolRepository.findBySchoolName(request.getSchoolName());
        if(schoolByName.isPresent()){
            throw new SchoolAlreadyExistsException("School already exists with name:" +
                    request.getSchoolName());
        }
        return SchoolConverter.converToSchoolResponse
                (schoolRepository.save(SchoolConverter.converToSchool(request)));
    }
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
    public SchoolResponse getSchoolById(Long id) {
        return SchoolConverter.converToSchoolResponse(findById(id));
    }
    private School findById(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new SchoolNotFoundException("School not found with id:" + id));
    }

    public void updateSchool(Long id,SchoolRequest request) {
        School oldSchool = findById(id);
        oldSchool.setSchoolName(request.getSchoolName());
        schoolRepository.save(oldSchool);
    }

    public List<School> getSchool(String name) {
        if(name == null){
            return schoolRepository.findAll();
        }else{
            return schoolRepository.findAllBySchoolName(name);
        }
    }

}
