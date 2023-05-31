package com.xtb.restful.Service;

import org.springframework.stereotype.Component;

@Component
public class ss implements ServiceInterface{

    public String doIt(){
       return "implements1";
    }
}
