package cn.sky.mcsm.basics.MCProperties;

import cn.sky.mcsm.basics.MCProperties.SetSpace.*;
import cn.sky.mcsm.system.output.ThreadsOut;
import cn.sky.mcsm.system.MainEntrance;
import cn.sky.mcsm.system.askContinue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SetProperties {
    public static void Guider() throws IOException {

        File file = new File("server.properties");
        if(!file.exists()){
            ThreadsOut.outNormal("\n 您并未启动过服务器，未生成配置文件，我们无法执行修改配置文件的操作\n","INFO" , "Main Thread", "ERROR");
            askContinue.Pause();
        }

        SetPropertiesGUI.GUI();

        // 扫描 Code
        Scanner code_input = new Scanner(System.in);
        String code = code_input.nextLine();

        switch (code) {
            case "1":
                SetSeed.Set();
                break;
            case "2":
                SetPort.Set();
                break;
            case "3":
                SetMOTD.Set();
                break;
            case "4":
                SetMaxPlayers.Set();
                break;
            case "5":
                SetMaxHeight.Set();
                break;
            case "6":
                SetPVPLegal.Set();
                break;
            case "7":
                SetOnlineMode.Set();
                break;
            case "8":
                SetDifficulty.Set();
                break;
            case "9":
                SetWhiteList.Set();
                break;
            case "10":
                SetAllowFlight.Set();
                break;
            case "11":
                MainEntrance.MainEntrance();
                break;
        }
    }
}
