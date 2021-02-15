package kr.ac.hs.se.controller;

import kr.ac.hs.se.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoriesApiController {

    private final CategoryService categoryService;

    @Autowired
    public CategoriesApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Map<String, Object> getCategories() {
        Map<String, Object> map = new HashMap<>();
        map.put("size", categoryService.getCategoriesSize());
        map.put("items", categoryService.getCategories());
        return map;
    }
}
