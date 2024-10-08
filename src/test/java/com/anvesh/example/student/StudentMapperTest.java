package com.anvesh.example.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {

/*
    @BeforeAll
    static void beforeAll() {
        System.out.println("inside the before all method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("inside the after all method");
    }

    @BeforeEach
    void setUp() {
        System.out.println("inside the before each method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("inside the after each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("my first test method");
    }

    @Test
    public void testMethod2(){
        System.out.println("my second test method");
    }
*/
    public StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        //firstly we will need an object of type student_dto
        StudentDto dto = new StudentDto("John",
                "Doe",
                "j@gmail.com",
                1);
        Student student = mapper.toStudent(dto);
        Assertions.assertEquals(dto.firstname(), student.getFirstname());//here we need to make sure that the first name in dto is same as that of the class student
        Assertions.assertEquals(dto.lastname(), student.getLastname());
        Assertions.assertEquals(dto.email(), student.getEmail());
        Assertions.assertNotNull(student.getSchool());//an assertion that school is not null
        Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());
    }
    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        //first we added the coverage to our toStudent method, in case we change from nullpointerexception to some other exception in our StudentMapper it will be automatically detected by our test
        //and even we change our exception message it will also be detected
       var exp =  Assertions.assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
       Assertions.assertEquals("The studentDto should not be null", exp.getMessage());
    }
    @Test
    public void shouldMapDtoStudentToStudent(){
        //given
        Student student = new Student(
                "xyz",
                "abc",
                "abc@gmail.com",
                22
        );
        //when
        StudentResponseDto studentResponseDto = mapper.toStudentResponseDto(student);
        //then
        Assertions.assertEquals(student.getFirstname(), studentResponseDto.firstname());
        Assertions.assertEquals(student.getLastname(), studentResponseDto.lastname());
        Assertions.assertEquals(student.getEmail(), studentResponseDto.email());
    }

}