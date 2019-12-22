package com.xxy.face.service;

import com.xxy.face.dao.StudentDAO;
import com.xxy.face.pojo.Student;
import com.xxy.face.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    CategoryService categoryService;

    public List<Student> list() {
        Sort sort = JpaSort.unsafe(Sort.Direction.DESC,"id");
        return studentDAO.findAll(sort);
    }

    public void addOrUpdate(Student student) {
        studentDAO.save(student);
    }

    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }

    public List<Student> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        Sort sort = JpaSort.unsafe(Sort.Direction.DESC, "cid");
        return studentDAO.findAllByCategory(category);
    }
}

