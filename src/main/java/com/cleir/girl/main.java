package com.cleir.girl;

import com.cleir.girl.domain.Girl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class main {
    public static void main(String[] args) {
        Girl flyPig = new Girl();
        flyPig.setCupSize("b");
        flyPig.setAge(8);
        flyPig.setMoney(12.0);
// ObjectOutputStream 对象输出流，将 flyPig 对象存储到E盘的 flyPig.txt 文件中，完成对 flyPig 对象的序列化操作
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/flyPig.txt")));
            oos.writeObject(flyPig);
            System.out.println("FlyPig 对象序列化成功！");
            oos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
