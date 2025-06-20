package org.naammm.superapp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    //Class này chịu trách nhiệm kết nối csdl thông qua đối tượng EntitManagerFactor
    /*
        kĩ thuật viết code mà khiến cho class ko new được nhiều lần
        STATIC + PRIVATE CONSTRUCTOR
     */

    private static EntityManagerFactory emf;
    //duy trì kết nối đến csdl, đọc file persistence.xml để tạo dựng/ update table
    //heavy load nằm ở biến này

    static {
        try {
            emf = Persistence.createEntityManagerFactory("com.giaolang.orm-PU");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //KĨ thuật singleton đã xong - 1 object heavy entity-manager-factory trong ram
    private JpaUtil() {
    }

    /*
        CÓ ÔNG NHÀ XƯỞNG  FACTOR RỒI, ĐI MỜI CÁC ÔNG MANAGER VỀ QUẢN LÍ CÁC @ENTITY
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //ĐÓNG CỬA NHÀ MÁY KHÔNG CẦN CHƠI VỚI CSDL NỮA
    public static void closeEntityManager(EntityManager em) {
        em.close();
    }
}
