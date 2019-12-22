package com.xxy.face.dao;

import com.xxy.face.pojo.Category;
import com.xxy.face.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student,Integer> {
    List<Student> findAllByCategory(Category category);
    List<Student> findAllByNameLikeOrDateLike(String keyword1, String keyword2);
}
