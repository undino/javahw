package org.itstep.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.itstep.data.StudentRepository;
import org.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentRestController {

    StudentRepository studentRepository;
//    ObjectMapper objectMapper;

    @Autowired
    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getOneStudent(@PathVariable int id) {
        return studentRepository.find(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        int id = studentRepository.save(student);
        return studentRepository.find(id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean updateStudent(@RequestBody Student student, @PathVariable int id) {
        if (student == null || studentRepository.find(id) == null)
            return false;
            Student newStudent = student;
            newStudent.setId(id);
            studentRepository.update(newStudent);
            return true;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteStudent(@PathVariable int id){
        return studentRepository.delete(studentRepository.find(id));
    }
}
