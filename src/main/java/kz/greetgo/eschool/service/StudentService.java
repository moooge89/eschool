package kz.greetgo.eschool.service;

import kz.greetgo.eschool.exception.StudentNotFoundException;
import kz.greetgo.eschool.mapper.StudentMapper;
import kz.greetgo.eschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getAllStudents() {
        return studentMapper.findAll();
    }

    public void addNewStudent(Student student) {
        studentMapper.insert(student);
    }

    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    public void deleteStudent (Long id) {
        studentMapper.delete(id);
    }

}
