package cn.carlsky.nlr.mcsm.System;

import cn.carlsky.nlr.lib.data;
import cn.carlsky.nlr.mcsm.Basics.Account.Ark;
import cn.carlsky.nlr.mcsm.Basics.Download.DownloadRequire;
import cn.carlsky.nlr.mcsm.Basics.MCProperties.SetProperties;
import cn.carlsky.nlr.mcsm.Basics.NormalControl;
import cn.carlsky.nlr.mcsm.Basics.ProcessControl;
import cn.carlsky.nlr.mcsm.Basics.ProcessFunctionLibrary;
import com.sun.tools.javac.Main;

import java.io.IOException;

public class MainThread {

    private static String dir;

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
                MainThread.Run();
                break;
            case "4":
                NormalControl.CheckIP();
                MainThread.Run();
                break;
            case "5":
                NormalControl.SearchMods();
                MainThread.Run();
                break;
            case "6":
                NormalControl.SearchPlugins();
                MainThread.Run();
                break;
            case "7":
                SetProperties.Guider();
                MainThread.Run();
                break;
            case "8":
                DeveloperPart();
                Ask.Continue();
                Run();
                break;
            case "97":
                if(VariableLibrary.Storage.UserLoginStatus.equals(true)){
                    Ark.Logout();
                } else {
                    Ark.Guider();
                }
                break;
            case "98":
                ThreadLogger.INFO.Output("\n 反馈请前往Issue（反馈任何问题，也许最快）：https://github.com/CarlSkyCoding/ArkPowered\n 或方块盒子反馈工具：https://id.arkpowered.cn/panel/support\n 或发送邮箱到：skygod@arkpowered.cn\n 或加群：705439821\n");
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
                ProcessControl.DestroyServer();
                break;
            case "3":
                ProcessControl.ReadThreadOutputStream();
                break;
            case "4":
                ProcessControl.RunCommandInThread();
                Ask.Continue();
                RunServerPart();
                break;
            case "5":
                ProcessControl.StopServer();
                break;
            case "99":
                Run();
                break;
            default:
                MainThread.RunServerPart();
                break;
        }
    }

    public static void DeveloperPart() throws IOException {

        GUI.DeveloperGUI();

        String CODE = data.Scan();

        switch (CODE) {
            case "1":
                ProcessControl.ListAllProcess();
                Ask.Continue();
                break;
            case "99":
                MainThread.Run();
                break;
            default:
                MainThread.DeveloperPart();
                break;
        }
    }
}
