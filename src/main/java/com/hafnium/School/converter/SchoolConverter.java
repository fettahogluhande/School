package com.hafnium.School.converter;

import com.hafnium.School.dto.request.SchoolRequest;
import com.hafnium.School.dto.response.SchoolResponse;
import com.hafnium.School.model.School;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchoolConverter {
    public static School converToSchool(SchoolRequest request) {

        School school = new School();
        school.setSchoolName(request.getSchoolName());
        return school;
    }
    public static SchoolResponse converToSchoolResponse(School school) {
        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setSchoolName(school.getSchoolName());
        schoolResponse.setCreatedDate(school.getCreatedDate());
        return schoolResponse;
    }
}
