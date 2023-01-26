package cn.sky.mcsm.basics.MCProperties.SetSpace;

import cn.sky.mcsm.lib.RewriteMCProperties;
import cn.sky.mcsm.system.askContinue;

import java.io.IOException;
import java.util.Scanner;

public class SetMaxPlayers {
    public static void Set() throws IOException {
        System.out.print(" 请输入最大人数：");

        Scanner code_input = new Scanner(System.in);
        String code = code_input.nextLine();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("max-players","20");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("max-players",code);
        }
        askContinue.Pause();
    }
}
