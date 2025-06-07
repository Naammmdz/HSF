package org.naammm.superapp.entity.unione;

import jakarta.persistence.EntityManager;
import org.naammm.superapp.infra.JpaUtil;

public class MainUniOne {
    //psvm tab để có hàm main
    //Nhờ vả JpaUtil, có hàm đọc file persistence.xml để kết nối đúng csdl, đúng driver, và giúp tạo ra ông quản lí
    public static void main(String[] args) {
        createMajorStudent();
    }

    public static void createMajorStudent() {
        //1. Tạo Major
        Major seMajor = new Major("SE", "SOFTWARE ENGINEERING | KỸ THUẬT PHẦN MỀM");

        //2. Tạo Student
        Student student1 = new Student("SE100", "AN NGUYEN", 2006, 8.6);
        Student student2 = new Student("SE101", "BINH LE", 2004, 9.6);

        //3. Thêm sinh viên vào danh sách của Major
        seMajor.addStudent(student1);
        seMajor.addStudent(student2);
        //OOP ĐÃ XONG VỀ RELATIONSHIP
        //XUỐNG TABLE, ĐỔ DOMING - CASCADE 1 MAJOR, N STUDENT XUÓNG LUÔN
        //

        //NHỜ JPAUTIL CHUẨN BỊ NHÀ XƯỞNG FACTORY, MỜI GIÁM ĐỐC VỀ QUẢN LÍ ENTITY ENTITYMANAGER

        //4. Lưu Major và sinh viên vào CSDL
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin(); //Bắt đầu giao dịch
        em.persist(seMajor); //Lưu Major, sẽ tự động lưu các sinh viên do CascadeType.ALL
        em.getTransaction().commit(); //Kết thúc giao dịch
        em.close(); //Đóng EntityManager sau khi hoàn thành công việc
    }
}
