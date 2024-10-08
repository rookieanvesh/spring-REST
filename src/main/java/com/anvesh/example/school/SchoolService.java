package com.anvesh.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    //field injection
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public List<SchoolDto> findAllSchools(){
        return schoolRepository.findAll() //after finding all the students which will return a list of schools
                .stream() //this will transform our list to stream of schools and then we will do mapping
                .map(schoolMapper::schoolDto) //for each element we will do transformation of object into school_dto by calling schooldto on every element
                .collect(Collectors.toList()); //and lastly we collect all of this as list
    }
    public SchoolDto create(SchoolDto dto){
        var school = schoolMapper.toSchool(dto);//converting school_dto to school entity
        schoolRepository.save(school);//saving to database with all the fields
        return dto;//just return the dto
    }
}
