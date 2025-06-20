package org.naammm.learn.ioc.v2bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //ko báo để quét thì new bean ở đây
     @Bean
     //chủ động new là mình, chủ động đặt tên object, nhưng đưa obj cho Container quản lý
     public PdfGenerator pdfGenerator() {
         return new PdfGenerator();
     }
}
