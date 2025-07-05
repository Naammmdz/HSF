package org.naammm.coffee.config;

import org.naammm.coffee.entity.Category;
import org.naammm.coffee.service.CategoryService;
import org.naammm.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//TỰ CHẠY 1 LẦN DUY NHẤT KHI TOMCAT ĐƯỢC CHẠY, LÀ IOC CONTAINER NÓ CHẠY, DÙNG ĐỂ TẠO TABLE, TẠO SẴN DATA TRONG TABLE
@Component
public class DataInitializer implements CommandLineRunner {

    //nhờ vả 3 service giúp tạo table, chèn sẵn data
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        //Tạo object nhờ service đẩy xuống
        //Tạo table 1 trước, N sau (Do khó ngoại tham chiếu khóa chính)
        Category cat1 = new Category("Trà sữa", "Trà sữa ngon nhất");
        Category cat2 = new Category("Cà phê", "Cà phê thơm ngon");
        Category cat3 = new Category("Nước ép", "Nước ép trái cây tươi ngon");
        Category cat4 = new Category("Đồ ăn vặt", "Đồ ăn vặt ngon miệng");
        //Lưu vào DB
        categoryService.saveCategory(cat1);
        categoryService.saveCategory(cat2);
        categoryService.saveCategory(cat3);
        categoryService.saveCategory(cat4);
    }
}
