package com.rpiqueras.taskmanager.usermanager.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoryServiceTest {

    private static CategoryService categoryService;

    @BeforeAll
    public static void setUp(){
        categoryService = new CategoryService();
    }

    @Test
    public void calculateLeveltestWithNoChilds() throws CategoryService.QueryException {
        CategoryService.CategoryLevel response = categoryService.calculateLevel(new CategoryService.CategoryModel());

        assertEquals(CategoryService.CategoryLevel.LEVEL_1, response);
    }

    @Test
    public void calculateLeveltestWithTwoLevels() throws CategoryService.QueryException {
        CategoryService.CategoryLevel response = categoryService.calculateLevel(buildTwoLevelsCategoryModel());

        assertEquals(CategoryService.CategoryLevel.LEVEL_2, response);
    }

    @Test
    public void calculateLeveltestWithTwoChilds() throws CategoryService.QueryException {
        CategoryService.CategoryLevel response = categoryService.calculateLevel(buildTwoChildsCategoryModel());

        assertEquals(CategoryService.CategoryLevel.LEVEL_2, response);
    }

    @Test
    public void calculateLeveltestWithSixLevels() throws CategoryService.QueryException {
        CategoryService.CategoryLevel response = categoryService.calculateLevel(buildSixLevelsCategoryModel());

        assertEquals(CategoryService.CategoryLevel.LEVEL_6, response);
    }

    @Test
    public void calculateLeveltestWithOutOfBoundsCategoryModel() throws CategoryService.QueryException {
        assertThrows(CategoryService.QueryException.class, () -> categoryService.calculateLevel(buildOutOfBoundsCategoryModel()));
    }

    private CategoryService.CategoryModel buildTwoLevelsCategoryModel(){
        CategoryService.CategoryModel categoryModel = new CategoryService.CategoryModel();
        List<CategoryService.CategoryModel> supercategories = new ArrayList<>();
        supercategories.add(new CategoryService.CategoryModel());
        categoryModel.setSupercategories(supercategories);
        return categoryModel;
    }

    private CategoryService.CategoryModel buildTwoChildsCategoryModel(){
        CategoryService.CategoryModel categoryModel = new CategoryService.CategoryModel();
        List<CategoryService.CategoryModel> supercategories = new ArrayList<>();

        CategoryService.CategoryModel categoryModelChild = new CategoryService.CategoryModel();
        List<CategoryService.CategoryModel> supercategoriesChild = new ArrayList<>();
        supercategoriesChild.add(new CategoryService.CategoryModel());
        categoryModelChild.setSupercategories(supercategoriesChild);

        supercategories.add(new CategoryService.CategoryModel());
        supercategories.add(categoryModelChild);
        categoryModel.setSupercategories(supercategories);

        return categoryModel;
    }

    private CategoryService.CategoryModel buildSixLevelsCategoryModel(){
        CategoryService.CategoryModel categoryModel = new CategoryService.CategoryModel();
        return buildCategoryModel(0, categoryModel, 4);
    }

    private CategoryService.CategoryModel buildOutOfBoundsCategoryModel(){
        CategoryService.CategoryModel categoryModel = new CategoryService.CategoryModel();
        return buildCategoryModel(0, categoryModel, 5);
    }

    private CategoryService.CategoryModel buildCategoryModel(int levels, CategoryService.CategoryModel categoryModel, int maxLevels){
        CategoryService.CategoryModel categoryModelParent = new CategoryService.CategoryModel();
        List<CategoryService.CategoryModel> supercategories = new ArrayList<>();
        supercategories.add(categoryModel);
        categoryModelParent.setSupercategories(supercategories);
        return (levels > (maxLevels-1)) ? categoryModelParent : buildCategoryModel(levels + 1, categoryModelParent, maxLevels);
    }
}
