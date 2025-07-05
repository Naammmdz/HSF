package org.naammm.coffee.service;

import org.naammm.coffee.entity.Category;
import org.naammm.coffee.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    //GUI/CONTROLLER --- SERVICE --- REPO --- SPRING JPA/HIBERNATE ---JBDC DRIVER --- TABLE
    //SERVICE LO CRUD TABLE TRONG RAM, LO LOGIC XỬ LÍ VỚI ENTITY/DTO
    //NẾU LO VIỆC CRUB TABLE THÌ PHẢI NHỜ VẢ REPO
    //BẢN CHẤT LÀ PHẢI KHAI BÁO REPO, NEW REPO, GỌI HÀM REPO
    //NHƯNG REPO HIỆN NAY ĐANG LÀ INTERFACE, VÀ LÀ BEAN
    //IOC CONTAINER INJECT VÀO SERVICE
    //VẬY SERVICE ĐƯỢC TIÊM REPO VÀO, VẬY SERVICE CŨNG PHẢI LÀ BEAN
    //@Component, @Service, @Repository, @Controller, @RestController

    //inject repo, 3 cách
    @Autowired
    private CategoryRepo categoryRepo;

    //inject qua constructor

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    //CRUD TRUYỀN THỐNG, GỌI HÀM DERIVED QUERY METHOOS TỰ SINH CỦA THẰNG REPO ĐƯỢC TIÊM VÀO TỰ ĐỘNG
    public void saveCategory(Category category) {
        categoryRepo.save(category); //save or update
        //categoryRepo.delete(category); //delete
        //categoryRepo.findById(id); //find by id
        //categoryRepo.findAll(); //find all
        //categoryRepo.existsById(id); //check exists by id
        //categoryRepo.count(); //count all
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll(); //lấy tất cả các category từ database
    }
}
