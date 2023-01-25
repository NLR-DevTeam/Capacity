package cn.sky.lib;

import cn.sky.system.output.ThreadsOut;

import java.io.*;
import java.util.Properties;

public class RewriteProperties {
    public static void MCSM_Properties_Write_Last_Server_Jar(String filepath, String Key, String Value) throws IOException {
        // Properties格式文件写入
        Properties props=new Properties();
        InputStream is=new FileInputStream(filepath);
        props.load(is);
        try {
            props.setProperty(Key, Value);
            // 使用"输出流"，将Properties集合中的KV键值对，写入*.properties文件
            try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath))){
                props.store(bos, "Properties");
                ThreadsOut.outNormal("\n 修改MCSM配置文件成功","INFO" , "Main Thread", "Checker");
                ThreadsOut.outNormal(" Successful to rewrite MCSM properties at the same folders.\n","INFO" , "Main Thread", "Checker");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
