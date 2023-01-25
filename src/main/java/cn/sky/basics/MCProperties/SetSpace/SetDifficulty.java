package cn.sky.basics.MCProperties.SetSpace;

import cn.sky.lib.RewriteMCProperties;
import cn.sky.system.askContinue;

import java.io.IOException;
import java.util.Scanner;

public class SetDifficulty {
    public static void Set() throws IOException {
        System.out.print(" 请输入难度等级：");

        Scanner code_input = new Scanner(System.in);
        String code = code_input.nextLine();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("difficulty","1");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("difficulty",code);
        }
        askContinue.Pause();
    }
}
