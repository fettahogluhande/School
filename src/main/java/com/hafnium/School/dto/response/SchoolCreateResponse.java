package com.hafnium.School.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SchoolCreateResponse {
    private String SchoolName;
    private Date createdDate;
}
