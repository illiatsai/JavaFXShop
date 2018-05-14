package com.teachMeSkills.shop.services;

import com.teachMeSkills.shop.dao.categoriesDao.ICategoriesDao;
import com.teachMeSkills.shop.dao.categoriesDao.CategoriesDaoImpl;
import com.teachMeSkills.shop.models.Category;
import javafx.scene.control.ChoiceBox;

import java.util.List;

public class CategoryService implements ICategoryService{
    private static CategoryService categoryInstance = new CategoryService();
    private ICategoriesDao dao = new CategoriesDaoImpl();

    public static CategoryService getInstance() {
        return categoryInstance;
    }

    private CategoryService() {

    }


    @Override
    public List<Category> getAllCategories() {
        return dao.getCategories();
    }

    @Override
    public void createCategory(Category category){
        dao.createCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        dao.updateCategory(category);
    }

    @Override
    public void deleteCategory(Category category) {
        dao.deleteCategory(category);
    }

    @Override
    public List<Category> listCategoriesByName(String name) {
        return dao.getCategoryByName(name);
    }

    @Override
    public List<Category> listCategoriesByAmount(ChoiceBox newOperator, String amount) {
        return dao.getCategoryByAmount(newOperator, amount);
    }
}
