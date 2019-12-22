package com.xxy.face.controller;

import com.xxy.face.pojo.Student;
import com.xxy.face.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    StudentService studentService;
    @CrossOrigin
    @GetMapping("/api/students")
    public List<Student> list() throws Exception {
        return studentService.list();
    }
    @CrossOrigin
    @PostMapping("/api/students")
    public Student addOrUpdate(@RequestBody Student student) throws Exception {
        studentService.addOrUpdate(student);
        return student;
    }
    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Student student) throws Exception {
        studentService.deleteById(student.getId());
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/students")
    public List<Student> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return studentService.listByCategory(cid);
        } else {
            return list();
        }
    }
}

