package com.anvesh.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    public StudentResponseDto saveStudent(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentRepository.save(student);
        //returning the dto with the aggregated entities, we only display the entities that are necessary
        return studentMapper.toStudentResponseDto(savedStudent);
    }
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    public List<StudentResponseDto> findStudentByFirstname(String firstname){
        return studentRepository.findAllByFirstname(firstname)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }
    public StudentResponseDto findStudentById(Integer id){
        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }
    void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        studentRepository.save(student);
        return student;
    }
    public List<StudentResponseDto> findAllStudent(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

}
