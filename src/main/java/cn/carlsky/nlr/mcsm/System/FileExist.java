package cn.carlsky.nlr.mcsm.System;

import cn.carlsky.nlr.lib.io;
import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class FileExist {
    public static void CheckFolder() {
        File MCServerManagerRoot = new File("MCServerManager/");
        File MCServerRunContainerRoot = new File("MCServerManager/Server container/");
        File MCServerManagerSettingRoot = new File("MCServerManager/Setting");

        if(!MCServerManagerRoot.exists()){
            Boolean Success = MCServerManagerRoot.mkdirs();
            if (Success) {
                ThreadLogger.INFO.Checker(" 创建基础目录成功！");
            } else {
                ThreadLogger.WARN.Checker(" 创建基础目录失败！");
            }
        }

        if(!MCServerRunContainerRoot.exists()){
            Boolean Success = MCServerRunContainerRoot.mkdirs();
            if (Success) {
                ThreadLogger.INFO.Checker(" 创建基础目录成功！");
                ThreadLogger.INFO.Checker(" 我们仍然强烈建议您把服务端文件夹放在 MCServerManager/Server container/ 中");
            } else {
                ThreadLogger.WARN.Checker(" 创建基础目录失败！");
            }
        }

        if(!MCServerManagerSettingRoot.exists()){
            Boolean Success = MCServerManagerSettingRoot.mkdirs();
            if (Success) {
                ThreadLogger.INFO.Checker(" 创建基础目录成功！");
            } else {
                ThreadLogger.WARN.Checker(" 创建基础目录失败！");
            }
        }
    }
    public static void CheckMCProperties(){
        File MCP = new File("server.properties");
        if(!MCP.exists()){
            try {
                Properties props = new Properties();

                ThreadLogger.INFO.Checker("正在将默认配置写入 server.properties......");
                props.put("allow-flight", "false");
                props.put("allow-nether", "true");
                props.put("announce-player-achievements","true");
                props.put("difficulty","1");
                props.put("enable-command-block","false");
                props.put("enable-query","false");
                props.put("enable-rcon","false");
                props.put("force-gamemode","false");
                props.put("gamemode","0");
                props.put("generate-structures","true");
                props.put("generator-settings","");
                props.put("hardcore","false");
                props.put("level-name","world");
                props.put("level-seed","");
                props.put("level-type","DEFAULT");
                props.put("max-build-height","256");
                props.put("max-players","20");
                props.put("max-tick-time","60000");
                props.put("max-world-size","29999984");
                props.put("motd","A Minecraft Server");
                props.put("network-compression-threshold","256");
                props.put("online-mode","true");
                props.put("op-permission-level","4");
                props.put("player-idle-timeout","0");
                props.put("pvp","true");
                props.put("resource-pack","");
                props.put("resource-pack-hash","");
                props.put("server-ip","");
                props.put("server-port","25565");
                props.put("snooper-enabled","true");
                props.put("spawn-animals","true");
                props.put("spawn-monsters","true");
                props.put("spawn-npcs","true");
                props.put("view-distance","10");
                props.put("white-list","false");

                // 使用"输出流"，将Properties集合中的KV键值对，写入*.properties文件
                try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("server.properties"))){
                    props.store(bos, "MCSM Properties");
                    ThreadLogger.INFO.Checker("写入MC配置文件成功！");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void CheckMCSMSetting(){
        File MCP = new File("MCServerManager/Setting/main.properties");
        if(!MCP.exists()){
            try {
                Properties props = new Properties();

                ThreadLogger.INFO.Checker("正在将默认配置写入 main.properties......");

                props.put("serverList", "{}");
                props.put("username", "{}");
                props.put("usertoken", "{}");

                // 使用"输出流"，将Properties集合中的KV键值对，写入*.properties文件
                try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("MCServerManager/Setting/main.properties"))){
                    props.store(bos, "MCSM Properties-Main");
                    ThreadLogger.INFO.Checker("写入MCSM配置文件成功！");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}