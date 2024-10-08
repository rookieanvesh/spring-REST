package com.anvesh.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools") //we changed this from getting all the information about the school and its students to just getting the info about the school by using SchoolDto
    public SchoolDto create(@RequestBody SchoolDto dto){
        var school = toSchool(dto);//converting school_dto to school entity
        var savedSchool = schoolRepository.save(school);//saving to database with all the fields
        return dto;//just return the dto
    }
    public School toSchool(SchoolDto dto){
        return new School(dto.name());
    }
    @GetMapping("/schools")
    public List<School> findAll(){
        return schoolRepository.findAll();
    }
}
