package cn.sky.mcsm.basics.MCProperties.SetSpace;

import cn.sky.mcsm.lib.RewriteMCProperties;
import cn.sky.mcsm.system.askContinue;

import java.io.IOException;
import java.util.Scanner;

public class SetWhiteList {
    public static void Set() throws IOException {
        System.out.print(" 请输入是否白名单（true/false）：");

        Scanner code_input = new Scanner(System.in);
        String code = code_input.nextLine();

        if(code.isEmpty()){
            RewriteMCProperties.MC_Properties_setProperty("white-list","false");
        }else{
            RewriteMCProperties.MC_Properties_setProperty("white-list",code);
        }
        askContinue.Pause();
    }
}
