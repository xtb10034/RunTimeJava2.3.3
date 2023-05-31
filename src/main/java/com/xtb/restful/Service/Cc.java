package com.xtb.restful.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Cc {
//    @Bean
    public void printInfo(String msg){
        System.out.println("MSG "+ msg);
    }
}
