package cn.sky.system;

import cn.sky.basics.CheckIPAddress;
import cn.sky.basics.Download.DownloadRequire;
import cn.sky.basics.MCProperties.SetProperties;
import cn.sky.basics.MainGUI;
import cn.sky.basics.ServerManager;
import cn.sky.basics.account.AccountManager;
import cn.sky.method.EulaAgree;
import cn.sky.method.listDirFiles;
import cn.sky.system.output.ThreadsOut;

import java.io.IOException;
import java.util.Scanner;

public class MainEntrance {
    public static void MainEntrance() throws IOException{

        MainGUI.GUI();

        // 扫描 Code
        Scanner codeload = new Scanner(System.in);
        String code = codeload.nextLine();

        switch (code){
            case "1":
                ServerManager.runServer();
                break;
            case "2":
                ServerManager.runCustomServer();
                break;
            case "3":
                DownloadRequire.DownloadMCServerVersion();
                break;
            case "4":
                CheckIPAddress.getIpAddressInWindows();
                break;
            case "5":
                EulaAgree.EulaAgree();
                ThreadsOut.outNormal(" 操作执行完毕","INFO" , "Main Thread", "Output");
                break;
            case "6":
                ThreadsOut.outNormal("","INFO" , "Main Thread", "Output");
                listDirFiles.listDirFiles("mods");
                break;
            case "7":
                ThreadsOut.outNormal("","INFO" , "Main Thread", "Output");
                listDirFiles.listDirFiles("plugins");
                break;
            case "8":
                SetProperties.Guider();
                break;
            case "97":
                if (BaseManager.getLoginStatus() == true) {
                    AccountManager.Logout();
                }else{
                    AccountManager.Login();
                }
                break;
            case "98":
                ThreadsOut.outNormal("","INFO" , "Main Thread", "Output");
                Warn.WarnForUser("\n 反馈请前往Issue（反馈任何问题，也许最快）：https://github.com/CarlSkyCoding/ArkPowered\n 或方块盒子反馈工具：https://id.arkpowered.cn/panel/support\n 或发送邮箱到：skygod@arkpowered.cn\n 或加群：705439821\n");
                break;
            case "99":
                askExit.askExit();
                break;
            default:
                MainEntrance();
                break;
        }
    }

    public static void Preposition() {
        System.out.println("==========================================");
    }
}
