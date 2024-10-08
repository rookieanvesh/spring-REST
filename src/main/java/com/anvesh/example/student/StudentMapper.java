package com.anvesh.example.student;

import com.anvesh.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto){
        if(dto == null){
            throw new NullPointerException("The studentDto should not be null");
        }
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());//mapping the dto to the respective school_id and similarly below to the respective school
        student.setSchool(school);
        return student;
    }//logic to convert entity to dto
    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}
