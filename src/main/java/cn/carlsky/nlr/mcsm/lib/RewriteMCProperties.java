package cn.carlsky.nlr.mcsm.lib;

import cn.carlsky.nlr.mcsm.System.ThreadLogger;

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

                ThreadLogger.INFO.Output("\n 修改MC配置文件成功");
                ThreadLogger.INFO.Output(" Successful to rewrite Minecraft properties at the same folders.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
