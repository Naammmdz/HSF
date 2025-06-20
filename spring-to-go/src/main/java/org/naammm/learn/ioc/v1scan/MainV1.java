package org.naammm.learn.ioc.v1scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainV1 {
    public static void main(String[] args) {
        //khởi taọ contain, thùng chứa object, thùng chứa bean
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //context thuộc class ApplicationContext là trùm cuối quản lí các object - bean, qua lí luôn việc tiêm vào các object khác
        // muốn đc tiêm vào thì phải là bean, phải đc @Component hoặc @Bean
        //TRÙM CUỐI NÀY GIỐNG ENTITY-MANAGER-FACTORY TRONG JPA, GIỐNG APPLICATION CONTEXT TRONG SPRING BOOT
        //TRÙM CUỐI CONTEXT - CHƠI TRONG RAM

        //Lấy bean từ context
        PdfGenerator pdfGenerator1 = (PdfGenerator) context.getBean("pdfGenerator");
        pdfGenerator1.generatePdf("Hello, World!");

        //Lấy bean từ context
        PdfGenerator pdfGenerator2 = context.getBean("pdfGenerator", PdfGenerator.class);
        pdfGenerator2.generatePdf("Hello, World!");

        //Lấy bean từ context
        PdfGenerator pdfGenerator3 = context.getBean(PdfGenerator.class);
        pdfGenerator3.generatePdf("Hello, World!");
    }
}
