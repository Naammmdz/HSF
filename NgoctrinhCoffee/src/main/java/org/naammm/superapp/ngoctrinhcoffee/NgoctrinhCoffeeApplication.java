package org.naammm.superapp.ngoctrinhcoffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication gồp sẵn 3 @khác
// @Configuration: đánh dấu class này là 1 class cấu hình, hứa các bean
// @EnableAutoConfiguration: tự động cấu hình ứng dụng, dựa trên các thư viện có trong classpath
// @ComponentScan: tự động quét các package con để tìm các class có @Component, @Service, @Repository, @Controller

public class NgoctrinhCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgoctrinhCoffeeApplication.class, args);
    }

}
