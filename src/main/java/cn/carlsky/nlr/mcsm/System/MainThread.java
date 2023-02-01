package cn.carlsky.nlr.mcsm.System;

import cn.carlsky.nlr.lib.data;
import cn.carlsky.nlr.mcsm.Basics.Account.Ark;
import cn.carlsky.nlr.mcsm.Basics.Download.DownloadRequire;
import cn.carlsky.nlr.mcsm.Basics.MCProperties.SetProperties;
import cn.carlsky.nlr.mcsm.Basics.NormalControl;
import cn.carlsky.nlr.mcsm.Basics.ProcessControl;
import cn.carlsky.nlr.mcsm.Basics.ProcessFunctionLibrary;

import java.io.IOException;

public class MainThread {
    public static void Run() throws IOException {
        // 主菜单

        GUI.MainGUI();

        String CODE = data.Scan();

        switch (CODE) {
            case "1":
                RunServerPart();
                break;
            case "2":
                NormalControl.AgreeEULA();
                break;
            case "3":
                DownloadRequire.DownloadMCServerVersion();
                break;
            case "4":
                NormalControl.CheckIP();
                break;
            case "5":
                NormalControl.CheckDirFiles.listDirFiles("mods");
                break;
            case "6":
                NormalControl.CheckDirFiles.listDirFiles("plugins");
                break;
            case "7":
                SetProperties.Guider();
                break;
            case "97":
                if(VariableLibrary.Storage.UserLoginStatus.equals(true)){
                    Ark.Logout();
                } else {
                    Ark.Guider();
                }
                break;
            case "98":
                ThreadsOut.INFO.Output("\n 反馈请前往Issue（反馈任何问题，也许最快）：https://github.com/CarlSkyCoding/ArkPowered\n 或方块盒子反馈工具：https://id.arkpowered.cn/panel/support\n 或发送邮箱到：skygod@arkpowered.cn\n 或加群：705439821\n");
                Ask.Continue();
                MainThread.Run();
                break;
            case "99":
                Ask.Exit();
                break;
            default:
                MainThread.Run();
                break;
        }
    }

    public static void RunServerPart() throws IOException {

        GUI.ServerListGUI();

        String CODE = data.Scan();

        switch (CODE) {
            case "1":
                ProcessFunctionLibrary.CreateNewMCThread();
                RunServerPart();
                break;
            case "2":
                ThreadsOut.INFO.Output("\n 现版本暂不支持删除实例功能，想停止实例，请关闭此程序后重新开启 \n");
                break;
            case "3":
                ProcessControl.RunOutput();
                break;
            case "4":
                ProcessControl.RunCommandInThread();
                break;
            case "99":
                Run();
                break;
            default:
                MainThread.RunServerPart();
                break;
        }
    }
}
