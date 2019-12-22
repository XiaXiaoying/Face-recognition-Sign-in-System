package com.xxy.face.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.xxy.face.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}

