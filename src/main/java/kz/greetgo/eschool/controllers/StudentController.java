package kz.greetgo.eschool.controllers;

import kz.greetgo.eschool.exception.StudentNotFoundException;
import kz.greetgo.eschool.model.Login;
import kz.greetgo.eschool.model.Student;
import kz.greetgo.eschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController() {
    }

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student studentToAdd){
        studentService.addNewStudent(studentToAdd);
        return new ResponseEntity<>(studentToAdd, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> checkLogin(@RequestBody Login login){
        // trivial check
        if (login.getUsername().equals("admin") && login.getPassword().equals("admin"))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @GetMapping("/test")
    public Student method(){
        Student student = new Student("Name", "Surname", 11, "Math");
        student.setId(1000L);
        return student;
    }

}
