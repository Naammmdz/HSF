package org.naammm.learn.ioc.v1scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//class này là nơi khai baáo các object dependency của riêng ta
//và gửi cho Spring container nó giữ
//Cũng là nơi khai baáo các thông tin về các dêependency khác mà ta ko tự tạo, IoC cho Spring lo giùm
// Tóm lại: class này là nơi lưu giữ các thông tin về dependency mà ta nhờ Spring quản lý
//Các object dependency new PdfGenerator(), new ContractService() sẽ được khai báo trong class này
@Configuration
@ComponentScan("org.naammm.learn.ioc.v1scan") // Chỉ định package để quét các bean
public class AppConfig {
    // Các phương thức khai báo bean sẽ được thêm vào đây
    // Ví dụ:
//     @Bean
//     public PdfGenerator pdfGenerator() {
//         return new PdfGenerator();
//     }

    // @Bean
    // public ContractService contractService() {
    //     return new ContractService(pdfGenerator());
    // }
}
