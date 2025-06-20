package org.naammm.superapp.entity.unimany;

import jakarta.persistence.EntityManager;
import org.naammm.superapp.infra.JpaUtil;

public class MainUniMany {
    public static void main(String[] args) {
        createMajorStudent();
    }

    public static void createMajorStudent() {
        // Code to create a Major entity
        Major major = new Major("SE", "Software Engineering");

        Student an = new Student("SE100", "An Nguyen", 2004, 8.6);
        Student binh = new Student("SE101", "Binh Le", 2006, 9.6);

        an.setMajor(major);
        binh.setMajor(major);

        //Thêm xóa sửa db phải có transaction
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        //Lưu Major
        em.persist(major);
        //Lưu sinh viên
        em.persist(an);
        em.persist(binh);
        em.getTransaction().commit();
        em.close(); //Đóng EntityManager sau khi hoàn thành công việc
    }

}
