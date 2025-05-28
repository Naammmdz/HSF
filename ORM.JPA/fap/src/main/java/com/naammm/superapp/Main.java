package com.naammm.superapp;


import com.naammm.superapp.entity.Lecturer;
import com.naammm.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.List;

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.orm-PU"); //gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JBDC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL Server

    public static void main(String[] args) {
//        insertStudent(); //gọi hàm insert để thêm mới sinh viên vào CSDL
//        selectAllStudents(); //gọi hàm select để lấy hết sinh viên trong CSDL
        insertLecturer();
        getAllLecturers();
    }

    //Học thêm về JPQL: JAVA PERSISTENCE QUERY LANGUAGE
    //LÀ PHIÊN BẢN ĐỘ TỪ SQL NHƯNG DÀNH RIÊNG CHO THẾ GIỚI OOP, OBJECT
    //HIBERNATE CX CÓ PHIÊN BẢN RIÊNG NỮA CỦA NÓ GỌI LÀ HQL
    //SQL: SELECT * FORM LECTURER
    //JPQL: FROM LECTURER
    //      SELECT lec FROM LECTUTER lec
    //                      với mỗi dòng/ record lấy từ table Lecturer
    //                      ta new nó trong ram, new Lecturer() và gọi vùng new này là lec, tức là Lec = new Lecturer()
    //                      và lặp lại cho toàn bộ record trong table Lecturer
    //ADD KẾT QUẢ ĐỌC TÙ TABLE VÀO KẾT QUR CUỐI CÙNG DÙNG LỆNH SELECT lec
    //SELECT lec tức là lấy từng object lec được new từng dòng trong table lecturer

    //WHERE
    //SQL: SELECT x FROM Lecturer WHERE Salary = 200000000// tên cột trong table
    //JPQL: SELECT x FROM Lecturer WHERE x
    public static void getAllLecturers() {
        EntityManager em = emf.createEntityManager();
        // luôn cần có ngừời quản lí các entity
        // viết câu SQL style object, gọi là JPQL, HQL khá giống SQL truền thống, nhưng là làm việc, select, thao tác trên object,
        //trên cái class Entity chứ không quan tâm tên cột trong table như JBDC đã học
        List<Lecturer> result = em.createQuery("from Lecturer", Lecturer.class).getResultList();
        //Lecturer là class từ đó sinh ra ibject, class Lecturer đã dc map thành table Lecturer ở bên khai baoas @Entity
        //in kq
        System.out.println("The list of lecturer (" + result.size() + ") is " + result);
        for (Lecturer lecturer : result) {
            System.out.println(lecturer);
        }

        //Biểu thức LAMBDA - LAMBDA EXPRESSION, DÍNH CỰC KÌ CHẶT CHẼ VỚI STREAM-API
        //CƠ CHẾ XỬ LÍ NHIỀU DỮ LIỆU TRONG RAM
        //LAMBDA EXPRESSION LÀ HÀM VÔ DANH, HÀM ẨN DANH!!! HÀM KHÔNG CÓ TÊN
        //DÍNH ĐẾN KHÁI NIỆM LẬP TRÌNH HÀM - FUNCTIONAL PROGRAMMING
        //HÀM DDC XEM LÀ 1 DATA, VÀ HÀM LÀ THAM SỐ CHUYỂN VÀO HÀM KHÁC
        System.out.println("The list of student printed b lambda");
        result.forEach(x  -> {
            System.out.println(x);
        });

        em.close();
    }

    public static void insertLecturer() {
        EntityManager em = emf.createEntityManager();
        Lecturer lecturer = new Lecturer("Hehe", 1989, 100_000_000);
        em.getTransaction().begin();
        em.persist(lecturer);
        em.getTransaction().commit();
        em.close();
    }

    //INSERT/TẠO MỚI SINH VIÊN
    public static void insertStudent() {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.orm-PU"); //gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JBDC cho JPA class lo để tạo kết nối tới CSDL cụ thể SQL Server
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
        //emf.close(); //đóng kết nối tới CSDL, giải phóng tài nguyên
    }
    //SELECT * ĐỂ LẤY HẾT DATA
    public static void selectAllStudents() {

        EntityManager em = emf.createEntityManager();
        List<Student> result = em.createQuery("FROM Student", Student.class).getResultList();
        System.out.println("The list of students: ");
        for (Student x : result) {
            System.out.println(x);
        }
        //dùng biểu thức Lambda để in cx được

        em.close();
        emf.close();
    }
}