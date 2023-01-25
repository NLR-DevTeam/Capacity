package cn.sky.lib;

import cn.sky.system.output.ThreadsOut;

import java.io.*;
import java.util.Properties;

public class RewriteMCProperties {
    public static void MC_Properties_setProperty(String Key, String Value) throws IOException {
        Properties props=new Properties();
        InputStream is=new FileInputStream("server.properties");
        props.load(is);
        try {
            props.setProperty(Key, Value);
            try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("server.properties"))){
                props.store(bos, "MCSM Properties");
                ThreadsOut.outNormal("\n 修改MC配置文件成功","INFO" , "Main Thread", "Writer");
                ThreadsOut.outNormal(" Successful to rewrite Minecraft properties at the same folders.\n","INFO" , "Main Thread", "Writer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
