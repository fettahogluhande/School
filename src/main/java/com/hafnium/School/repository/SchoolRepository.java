package com.hafnium.School.repository;

import com.hafnium.School.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School,Long> {
    Optional<School> findBySchoolName(String schoolName);
}
