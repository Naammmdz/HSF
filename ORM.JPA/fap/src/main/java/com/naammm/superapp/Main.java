package com.naammm.superapp;


import com.naammm.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        insertStudent(); //gọi hàm insert để thêm mới sinh viên vào CSDL
        selectAllStudents(); //gọi hàm select để lấy hết sinh viên trong CSDL
    }

    //INSERT/TẠO MỚI SINH VIÊN
    public static void insertStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.orm-PU"); //gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JBDC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL Server
        EntityManager em = emf.createEntityManager();
        //tạo ra 1 object dùng để quản lí các entity class - map ngang sang table. Class Student chịu sự quản lí của em/EntityManager
        //em/EntityManager sẽ lo CRUD trên 1 table nào đó!
        //qua mấy hàm huyền thoại: persit() find(), remove(), merge(), refresh(), clear(), detach()...
        //Toàn chơi object, đằng sau là table bị ảnh hưởng

        Student an = new Student("SE1", "An", 2000, 8.5);
        Student binh = new Student("SE2", "Binh", 2001, 7.5);
        Student cuong = new Student("SE3", "Cuong", 2002, 6.5);
        //gọi sếp EntityMânge giúp CRUD
        em.getTransaction().begin(); //bắt đầu giao dịch, bắt đầu làm việc với CSDL BẮT BUỘC PHẢI CÓ
        em.persist(an); //thêm mới sinh viên An vào CSDL
        em.persist(binh); //thêm mới sinh viên Binh vào CSDL
        em.persist(cuong); //thêm mới sinh viên Cuong vào CSDL
        em.getTransaction().commit(); //kết thúc giao dịch, kết thúc làm việc với CSDL BẮT BUỘC PHẢI CÓ

        //SELECT KO CẦN, VÌ KO THAY ĐỔI TRẠNG THÁI TABLE
        em.close();
        emf.close(); //đóng kết nối tới CSDL, giải phóng tài nguyên
    }
    //SELECT * ĐỂ LẤY HẾT DATA
    public static void selectAllStudents() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.orm-PU"); //gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JBDC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL Server
        EntityManager em = emf.createEntityManager();
        List<Student> result = em.createQuery("FROM Student", Student.class).getResultList();
        System.out.println("The list òf students: ");
        for (Student x : result) {
            System.out.println(x);
        }
        //dùng biểu thức Lambda để in cx được

        em.close();
        emf.close();
    }
}