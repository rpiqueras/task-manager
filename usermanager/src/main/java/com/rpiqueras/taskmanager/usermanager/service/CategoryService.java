package com.rpiqueras.taskmanager.usermanager.service;
import java.util.ArrayList;
import java.util.List;

public final class CategoryService {
    public enum CategoryLevel {
        LEVEL_1("level1"), LEVEL_2("level2"), LEVEL_3("level3"), LEVEL_4("level4"), LEVEL_5("level5"), LEVEL_6("level6");

        public final String categoryLevelName;
        CategoryLevel(String categoryLevelName) {
    this.categoryLevelName = categoryLevelName;
    }
    }

    public CategoryLevel calculateLevel(CategoryModel categoryModel) throws QueryException {
        int levelCounter = 0;
        CategoryModel parentCategory = getParentCategory(categoryModel);

        while (parentCategory != null) {
            levelCounter++;
            parentCategory = getParentCategory(parentCategory);
        }

        if (levelCounter >= CategoryLevel.values().length) {
            throw new QueryException(String.format("cannot calculate CategoryLevel for %s, only 6 levels are supported", categoryModel.getCode()));
        }

        return CategoryLevel.values()[levelCounter];
    }

    private CategoryModel getParentCategory(CategoryModel categoryModel) {
        List<CategoryModel> superCategories = categoryModel.getSupercategories();

        if (superCategories.isEmpty()) {
            return null;
        }

        return superCategories.get(0);
    }

    // inner classes for interview purposes only
    static class CategoryModel {
        private List<CategoryModel> supercategories = new ArrayList<>();
        private String code;
        public String getCode() {
        return code;
        }
        public void setCode(String code) {
        this.code = code;
        }
        public List<CategoryModel> getSupercategories() {
        return supercategories;
        }
        public void setSupercategories(List<CategoryModel> supercategories) {
    this.supercategories = supercategories;
    }
    }

    static class QueryException extends Exception {
        public QueryException(String message) {
    super(message);
    }
    }
}