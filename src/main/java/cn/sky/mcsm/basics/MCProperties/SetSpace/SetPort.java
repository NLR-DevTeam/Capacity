package cn.sky.mcsm.basics.MCProperties.SetSpace;

import cn.sky.mcsm.lib.RewriteMCProperties;
import cn.sky.mcsm.system.askContinue;

import java.io.IOException;
import java.util.Scanner;

public class SetPort {
    public static void Set() throws IOException {
        System.out.print(" 请输入端口：");

        Scanner code_input = new Scanner(System.in);
        String code = code_input.nextLine();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("server-port","25565");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("server-port",code);
        }
        askContinue.Pause();
    }
}
