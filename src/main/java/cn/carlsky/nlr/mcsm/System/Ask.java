package cn.carlsky.nlr.mcsm.System;

import cn.carlsky.nlr.lib.data;

import java.io.IOException;

public class Ask {
    public static void Exit() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner(" 您是否要退出此程序？(Y/N，输入其他为不退出)");
        String CODE = data.Scan();
        switch (CODE) {
            case "Y":
                System.exit(0);
                break;
            case "N":
                MainThread.Run();
                break;
            case "114514":
                ThreadLogger.INFO.Output(" 嗯！哼哼！啊啊啊啊啊啊啊啊啊啊啊啊！！");
                Ask.Continue();
                MainThread.Run();
                break;
        }
    }

    public static void Continue(){
        ThreadLogger.INFO.Output(" 按回车键继续...");
        String CODE = data.Scan();
    }
}
