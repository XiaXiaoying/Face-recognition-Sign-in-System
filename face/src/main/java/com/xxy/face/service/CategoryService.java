package com.xxy.face.service;

import com.xxy.face.dao.CategoryDAO;
import com.xxy.face.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list() {
        Sort sort = JpaSort.unsafe(Sort.Direction.DESC, "cid");
        return categoryDAO.findAll(sort);
    }

    public Category get(int cid) {
        Category c = categoryDAO.findById(cid).orElse(null);
        return c;
    }
}
