package com.xtb.restful.Service;

import com.xtb.restful.model.HolleDto;
import org.springframework.stereotype.Component;

import java.io.*;
@Component
public class TestSerializable {

    public void testSerial(){

        try{
            HolleDto dto = new HolleDto();
            dto.setId(2022);
            dto.setAge(35);
            dto.setName("王米兰");
            outPutStream(dto);
            HolleDto dto2 = outPutStreamBack();
            System.out.println(dto==dto);// 返回 true : 表明两个对象是相对的
            System.out.println(dto.equals(dto2));//返回: false
            System.out.println(dto.hashCode());// 865113938
            System.out.println(dto2.hashCode()); //1808253012
            System.out.println(dto.toString());// HolleDto [id=2022, name=王米兰, age=35]
            System.out.println(dto2.toString()); // HolleDto [id=2022, name=王米兰, age=35]
        }catch(ClassNotFoundException e){

        }
    }

    public void outPutStream(HolleDto dto){
        String path  = "D:\\bin\\test\\holle.txt";
        File file = new File(path);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //反序列化对象
    public HolleDto outPutStreamBack( ) throws ClassNotFoundException{
        String path  = "D:\\bin\\test\\holle.txt";
        HolleDto dto = null ;
        File file = new File(path);
        FileInputStream fis ;
        ObjectInputStream  ois;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            dto =(HolleDto) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dto;
    }
}
