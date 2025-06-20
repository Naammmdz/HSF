package org.naammm.learn.ioc.v2bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainV2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Lấy bean từ context
        PdfGenerator pdfGenerator1 = (PdfGenerator) context.getBean("pdfGenerator");
        pdfGenerator1.generatePdf("Hello, World!");
    }
}
