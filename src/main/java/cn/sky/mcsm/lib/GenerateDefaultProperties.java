package cn.sky.mcsm.lib;

import cn.sky.mcsm.system.output.ThreadsOut;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GenerateDefaultProperties {
    public static void MCSM_Properties_Write_Default() throws IOException {
        // Properties格式文件写入
        try {
            Properties props = new Properties();
            props.put("last_server_jar", "server.jar");

            // 使用"输出流"，将Properties集合中的KV键值对，写入*.properties文件
            try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("mcsm_set.properties"))){
                props.store(bos, "MCSM Properties");
                ThreadsOut.outNormal("写入配置文件成功！","INFO" , "Main Thread", "Checker");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void CheckMCProperties(){
        File MCP = new File("server.properties");
        if(!MCP.exists()){
            try {
                Properties props = new Properties();

                ThreadsOut.outNormal("正在将默认配置写入 server.properties......","INFO" , "Main Thread", "Checker");
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
                    ThreadsOut.outNormal("写入MC配置文件成功！","INFO" , "Main Thread", "Checker");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
