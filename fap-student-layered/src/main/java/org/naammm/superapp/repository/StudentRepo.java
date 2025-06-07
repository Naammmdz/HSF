package org.naammm.superapp.repository;

import jakarta.persistence.EntityManager;
import org.naammm.superapp.entity.Student;
import org.naammm.superapp.infra.JpaUtil;

import java.util.List;

public class StudentRepo {
    //Class này chứa các crud trực tiếp table student
    //Các hàm crud ở đây thường đặt tên ngắn gọn, hướng hành động giống như lệnh SQL
    //tên hàm gợi ý: save(), update(), delete(), remove()

    //DÙNG TRANSACTION VÌ THAY ĐỔI TABLE
    public void save(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        //chạy duy nhất 1 lần,khởi động heavy CONNECTON
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();// giám đốc xong việc
    }

    public List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("from Student", Student.class).getResultList();
    }

    //Update
    public void update(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    public void delete(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    public void delete(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        Student obj = em.find(Student.class, id);
        em.remove(obj);
        em.getTransaction().commit();
    }
}
