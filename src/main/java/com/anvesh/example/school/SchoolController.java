package com.anvesh.example.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
//    private final SchoolRepository schoolRepository;
//
//    public SchoolController(SchoolRepository schoolRepository) {
//        this.schoolRepository = schoolRepository;
//    }
    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools") //we changed this from getting all the information about the school and its students to just getting the info about the school by using SchoolDto
    public SchoolDto create(@RequestBody SchoolDto dto){
        return schoolService.create(dto);
    }
//    public School toSchool(SchoolDto dto){
//        return new School(dto.name());
//    }
//    public SchoolDto schoolDto(School school){
//        return new SchoolDto(school.getName());
//    }
    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return schoolService.findAllSchools();
    }
}
