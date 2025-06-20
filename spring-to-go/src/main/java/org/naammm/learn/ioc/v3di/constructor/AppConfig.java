package org.naammm.learn.ioc.v3di.constructor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("org.naammm.learn.ioc.v3di.constructor")
public class AppConfig {

    //Chủ động new bean, đặc biêt các bean có tham số đầu vào
}
