package cn.sky.mcsm.basics.MCProperties.SetSpace;

import cn.sky.mcsm.lib.RewriteMCProperties;
import cn.sky.mcsm.system.askContinue;

import java.io.IOException;
import java.util.Scanner;

public class SetSeed {
    public static void Set() throws IOException {
        System.out.print(" 请输入种子：");

        Scanner code_input = new Scanner(System.in);
        String code = code_input.nextLine();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("level-seed","25565");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("level-seed",code);
        }
        askContinue.Pause();
    }
}
