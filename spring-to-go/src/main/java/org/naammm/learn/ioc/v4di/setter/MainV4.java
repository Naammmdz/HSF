package org.naammm.learn.ioc.v4di.setter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV4 {
    public static void main(String[] args) {
        // Create the application context
        org.springframework.context.ApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the ContractService bean
        ContractService contractService = context.getBean(ContractService.class);

        // Process the contract, which will use the PdfGenerate bean
        contractService.processContract();
    }
}
