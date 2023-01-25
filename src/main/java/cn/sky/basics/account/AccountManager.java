package cn.sky.basics.account;

import cn.sky.system.BaseManager;
import cn.sky.system.askContinue;
import cn.sky.system.output.ThreadsOut;

import java.io.IOException;
import java.util.Scanner;

public class AccountManager {
    public static void Login() throws IOException {
        String returnInfo;
        String Token;
        String Result;
        Result = "NO";

        ThreadsOut.outWithNoLine(" 请输入方块盒子用户名：", "INFO", "Main Thread", "Scanner");
        Scanner codeload = new Scanner(System.in);
        String username = codeload.nextLine();

        ThreadsOut.outWithNoLine(" 请输入方块盒子密码：", "INFO", "Main Thread", "Scanner");
        Scanner code = new Scanner(System.in);
        String password = code.nextLine();

        returnInfo = GetLogin.LoginToArkPowered(username, password);

        if (returnInfo.equals(Result)) {
            ThreadsOut.outNormal(" 登录没有成功，请检查您的用户名和密码", "WARN", "Main Thread", "Output");
            askContinue.Pause();
        }else{
            Token = returnInfo;
            BaseManager.LOGIN_STATUS = true;
            BaseManager.USERTOKEN = Token;
            BaseManager.USERNAME = username;

            ThreadsOut.outNormal(" 登录方块盒子账户成功！", "INFO", "Main Thread", "Output");
            askContinue.Pause();
        }
    }

    public static void Logout() throws IOException {
        BaseManager.LOGIN_STATUS = false;
        BaseManager.USERTOKEN = null;
        BaseManager.USERNAME = null;

        ThreadsOut.outNormal(" 成功退出登录！", "INFO", "Main Thread", "Output");
        askContinue.Pause();
    }
}
