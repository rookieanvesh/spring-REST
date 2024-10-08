package com.anvesh.example.student;

import com.anvesh.example.Order;
import com.anvesh.example.OrderRecord;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//this rest controller is used at the class level and it indicates that the annotated class is used as a rest controller,
//spring's component scanning mechanism detects these classes and creates the beans of them in the application context
public class FirstController {
    //@GetMapping("/hello") //sayHello method is already mapped to /hello that ia why we get error for ambiguous mapping
    public String sayHello(){
        return "hello from 1st controller";
    }
    private final StudentRepository studentRepository;
    private StudentService studentService;
    private final StudentMapper studentMapper;
    public FirstController(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }
    @PostMapping("/students") //here we return StudentResponseDto so that we dont expose extra info
    public StudentResponseDto postStudent(@RequestBody StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentService.saveStudent(dto);
        //returning the dto with the aggregated entities, we only display the entities that are necessary
        return studentMapper.toStudentResponseDto(student);
    }//dto to entity
/*
    private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());//mapping the dto to the respective school_id and similarly below to the respective school
        student.setSchool(school);
        return student;
    }//logic to convert entity to dto
    private StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
*/
    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer id){
        return studentService.findStudentById(id);
    }
    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents(){
        return studentService.findAllStudent();
    }
    @GetMapping("/student/{firstname}")
    public List<StudentResponseDto> findStudentByFirstname(@PathVariable("firstname") String firstname){
        return studentService.findStudentByFirstname(firstname);
    }

/*
    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)//this is an enum class which has http objects and gives us status codes, by convention we should use this
    public String sayHello2(){
        return "hello from 2nd controller";
    }
*/
    @PostMapping("/post")
    public String post(@RequestBody String message){//in order to send a message we give it a body message
        return "request accepted and message" + message;
    }
    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order){
        return "request accepted and message" + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(@RequestBody OrderRecord order){
        return "request accepted and message" + order.toString();
    }
    //http
    //@GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName){
        //we would always want to use @PathVariable inside the parameter as this would tell spring that this is the variable that is used in the path
        return "my value = " + userName;
    }
    //http://localhost:8080/hello?param_name=paramvalue&param_name_2=value2
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name")String userFirstName,
            @RequestParam("user-lastname")String userLastName
            ){
        return "my value = " + userFirstName + " " + userLastName;
    }
    @DeleteMapping("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteStudent(@PathVariable("student-id") Integer id){
        studentService.deleteStudent(id);
    }

}
