package cn.carlsky.nlr.mcsm.Basics.MCProperties;

import cn.carlsky.nlr.mcsm.System.Ask;
import cn.carlsky.nlr.mcsm.System.ThreadsOut;
import cn.carlsky.nlr.lib.data;
import cn.carlsky.nlr.mcsm.lib.RewriteMCProperties;

import java.io.IOException;

public class Set {
    public static void SetFly() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入是否允许飞行（true/false）：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("allow-flight","false");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("allow-flight",code);
        }
        Ask.Continue();
    }

    public static void SetDifficulty() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入难度等级：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("difficulty","1");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("difficulty",code);
        }
        Ask.Continue();
    }

    public static void SetMaxMapHeight() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入最大高度：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("max-build-height","256");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("max-build-height",code);
        }
        Ask.Continue();
    }

    public static void SetMaxPlayers() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入最大人数：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("max-players","20");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("max-players",code);
        }
        Ask.Continue();
    }

    public static void SetMOTD() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入MOTD信息：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("motd","A Minecraft Server");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("motd",code);
        }
        Ask.Continue();
    }

    public static void SetOnlineMode() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入是否开启正版验证（true/false）：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("online-mode","true");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("online-mode",code);
        }
        Ask.Continue();
    }

    public static void SetPort() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入端口：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("server-port","25565");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("server-port",code);
        }
        Ask.Continue();
    }

    public static void SetPVP() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入PVP状态（true/false）：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("pvp","true");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("pvp",code);
        }
        Ask.Continue();
    }

    public static void SetSeed() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入种子：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("level-seed","25565");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("level-seed",code);
        }
        Ask.Continue();
    }

    public static void SetWhiteList() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入是否白名单（true/false）：");

        String code = data.Scan();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("white-list","false");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("white-list",code);
        }
        Ask.Continue();
    }
}
