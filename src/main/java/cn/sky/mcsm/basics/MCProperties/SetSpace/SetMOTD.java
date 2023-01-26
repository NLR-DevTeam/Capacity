package cn.sky.mcsm.basics.MCProperties.SetSpace;

import cn.sky.mcsm.lib.RewriteMCProperties;
import cn.sky.mcsm.system.askContinue;

import java.io.IOException;
import java.util.Scanner;

public class SetMOTD {
    public static void Set() throws IOException {
        System.out.print(" 请输入MOTD信息：");

        Scanner code_input = new Scanner(System.in);
        String code = code_input.nextLine();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("motd","A Minecraft Server");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("motd",code);
        }
        askContinue.Pause();
    }
}
