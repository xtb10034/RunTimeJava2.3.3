package com.xtb.restful.Service;


import com.xtb.restful.Dao.UserDao;
import com.xtb.restful.model.User;
import com.xtb.restful.model.User1;
import com.xtb.restful.selfAutowired.Lian;
import com.xtb.restful.selfAutowired.LianService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

@Component
public class Service {
    private static Log logger = LogFactory.getLog(Service.class);

    @Lian
    private LianService lianService;

    public void printLian(){
        lianService.show();
    }
    public void getMsg() throws Exception{

        Cc cc = new Cc();
        cc.printInfo("aaa");

//反射
        //1.基于Java反射机制创建对象
        Class cl =	Class.forName("com.xtb.restful.model.User1");
        User1 user;
        try {
            user = (User1)cl.newInstance();
            System.out.println("用户ID："+user.getId());
            System.out.println("姓名："+user.getName());
            System.out.println("年龄："+user.getAge());
            //2.基于Java的反射机制获取构造函数创建对象
            Constructor con = cl.getConstructor();
            User1 user2 =(User1)con.newInstance();
            System.out.println(user.getAge());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Class c2 = User1.class;
        Class c3 =cl.getClass();


    }




}
