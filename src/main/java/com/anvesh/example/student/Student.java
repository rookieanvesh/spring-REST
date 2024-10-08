package com.anvesh.example.student;

import com.anvesh.example.school.School;
import com.anvesh.example.studentprofile.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_STUDENT")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "c_name")
    private String firstname;
    @Column(unique = true)//unique lastname only
    private String lastname;
    private String email;
    private int age;
    @Column(
            updatable = false,
            insertable = false
    )
    private String some_column;
    @OneToOne(mappedBy = "student",
    cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne //means many students to one school
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getSome_column() {
        return some_column;
    }

    public void setSome_column(String some_column) {
        this.some_column = some_column;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Student(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }
}
