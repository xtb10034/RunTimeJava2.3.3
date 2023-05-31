package com.xtb.restful;

import com.xtb.restful.Service.Service;
import com.xtb.restful.Service.TestSerializable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RestfulApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(RestfulApplication.class, args);
		Service service = context.getBean(Service.class);
//		TestSerializable service = context.getBean(TestSerializable.class);

		try{
//            service.testSerial();
			service.printLian();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
