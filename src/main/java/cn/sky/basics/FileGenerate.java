package cn.sky.basics;

import cn.sky.lib.GenerateDefaultProperties;
import cn.sky.system.output.ThreadsOut;

import java.io.File;
import java.io.IOException;

public class FileGenerate {
    public static void checkSettingFileExist() throws IOException {
        ThreadsOut.outNormal("检查配置文件...","INFO" , "Main Thread", "Checker");
        File Setting_JSON = new File("mcsm_set.properties");

        if(!Setting_JSON.exists()){
            GenerateDefaultProperties.MCSM_Properties_Write_Default();
        }else{
            ThreadsOut.outNormal("已存在文件 mcsm_set.properties","INFO" , "Main Thread", "Checker");
        }
    }

    public static void checkMCFileExist() throws IOException {
        ThreadsOut.outNormal("检查MC配置文件...","INFO" , "Main Thread", "Checker");
        File MC_JSON = new File("server.properties");

        if(!MC_JSON.exists()){
            GenerateDefaultProperties.CheckMCProperties();
        }else{
            ThreadsOut.outNormal("已存在文件 server.properties","INFO" , "Main Thread", "Checker");
        }
    }
}
