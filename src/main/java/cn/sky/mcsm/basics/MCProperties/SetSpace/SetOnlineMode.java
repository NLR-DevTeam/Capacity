package cn.sky.mcsm.basics.MCProperties.SetSpace;

import cn.sky.mcsm.lib.RewriteMCProperties;
import cn.sky.mcsm.system.askContinue;

import java.io.IOException;
import java.util.Scanner;

public class SetOnlineMode {
    public static void Set() throws IOException {
        System.out.print(" 请输入是否开启正版验证（true/false）：");

        Scanner code_input = new Scanner(System.in);
        String code = code_input.nextLine();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("online-mode","true");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("online-mode",code);
        }
        askContinue.Pause();
    }
}
