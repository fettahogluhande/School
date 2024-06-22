package com.hafnium.School.converter;

import com.hafnium.School.dto.request.SchoolRequest;
import com.hafnium.School.dto.response.SchoolCreateResponse;
import com.hafnium.School.model.School;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchoolConverter {
    public static School converToSchool(SchoolRequest request) {

        School school = new School();
        school.setSchoolName(request.getSchoolName());
        return school;
    }
    public static SchoolCreateResponse converToSchoolCreateResponse(School school) {
        SchoolCreateResponse schoolCreateResponse = new SchoolCreateResponse();
        schoolCreateResponse.setSchoolName(school.getSchoolName());
        schoolCreateResponse.setCreatedDate(school.getCreatedDate());
        return schoolCreateResponse;
    }
}
