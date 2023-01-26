package cn.sky.mcsm.basics.account;

import cn.sky.mcsm.lib.Function.Fetcher;
import cn.sky.mcsm.system.output.ThreadsOut;
import cn.sky.mcsm.system.BaseManager;
import cn.sky.mcsm.system.askContinue;

import java.io.IOException;
import java.util.Scanner;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

public class AccountManager {
    public static void Login() throws IOException {
        String returnAuthInfo;
        String returnInfo;
        String Token;

        ThreadsOut.outWithNoLine(" 请输入方块盒子用户名：", "INFO", "Main Thread", "Scanner");
        Scanner codeload = new Scanner(System.in);
        String username = codeload.nextLine();

        ThreadsOut.outWithNoLine(" 请输入方块盒子密码：", "INFO", "Main Thread", "Scanner");
        Scanner code = new Scanner(System.in);
        String password = code.nextLine();

        returnAuthInfo = Fetcher.fetch("https://auth.arkpowered.cn");
        JSONObject jsonObj = JSON.parseObject(returnAuthInfo);
        String AuthResult = jsonObj.getString("Status");

        if(AuthResult.equals("NO")) {
            ThreadsOut.outNormal(" 登录没有成功，身份验证服务器正在停机维护", "WARN", "Main Thread", "Output");
            askContinue.Pause();
        }else{
            String returnAccount = GetLogin.LoginToArkPowered(username, password);
            JSONObject AccountObj = JSON.parseObject(returnAccount);
            returnInfo = AccountObj.getString("Status");

            if (returnInfo.equals("NO")) {
                ThreadsOut.outNormal(" 登录没有成功，请检查您的用户名和密码", "WARN", "Main Thread", "Output");
                askContinue.Pause();
            }else{
                Token = AccountObj.getString("userVerifyToken");
                BaseManager.LOGIN_STATUS = true;
                BaseManager.USERTOKEN = Token;
                BaseManager.USERNAME = username;

                ThreadsOut.outNormal(" 登录方块盒子账户成功！", "INFO", "Main Thread", "Output");
                askContinue.Pause();
            }
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
