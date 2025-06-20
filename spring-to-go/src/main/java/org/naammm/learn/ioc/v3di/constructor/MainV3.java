package org.naammm.learn.ioc.v3di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainV3 {

    public static void main(String[] args) {
        // Create the application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ContractService contractService = (ContractService) context.getBean("contractService");
        contractService.processContract();
    }
}
