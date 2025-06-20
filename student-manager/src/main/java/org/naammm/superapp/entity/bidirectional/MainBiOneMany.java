package org.naammm.superapp.entity.bidirectional;

import jakarta.persistence.EntityManager;
import org.naammm.superapp.infra.JpaUtil;

import java.util.List;

public class MainBiOneMany {
    public static void main(String[] args) {
//        createMajorStudent();
        getAll();
    }

    public static void createMajorStudent() {
        // Code to create a Major entity
        Major se = new Major("SE", "Software Engineering | Kỹ thuật phần mềm");
        Major gd = new Major("GD", "Graphic Design | Thiết kế đồ họa");

        // Code to create Student entities
        Student an = new Student("SE100", "An Nguyen", 2004, 8.6);
        Student binh = new Student("SE101", "Binh Le", 2006, 9.6);
        Student cuong = new Student("GD100", "Cuong Tran", 2005, 7.5);
        Student linh = new Student("GD101", "Linh Pham", 2003, 9.0);

        //Kết nối chuyên ngành, style object
        se.addStudent(an);
        se.addStudent(binh);
        gd.addStudent(cuong);
        gd.addStudent(linh);


        //Thêm xóa sửa db phải có transaction
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        //Lưu Major
        em.persist(se);
        em.persist(gd);
        //Lưu sinh viên
        em.persist(an);
        em.persist(binh);
        em.persist(cuong);
        em.persist(linh);
        em.getTransaction().commit();
        em.close(); //Đóng EntityManager sau khi hoàn thành công việc
    }

    public static void getAll() {
        EntityManager em = JpaUtil.getEntityManager();

        Major se = em.find(Major.class, "SE");
        System.out.println("Major SE: " + se);

        List<Student> students = se.getStudents();
        System.out.println("Students in SE Major:");
        students.forEach(nt -> System.out.println(nt));
    }
}
