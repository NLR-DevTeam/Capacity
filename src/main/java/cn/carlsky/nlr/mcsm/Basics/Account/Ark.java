package cn.carlsky.nlr.mcsm.Basics.Account;

import cn.carlsky.nlr.mcsm.System.Ask;
import cn.carlsky.nlr.mcsm.System.MainThread;
import cn.carlsky.nlr.mcsm.System.ThreadLogger;
import cn.carlsky.nlr.lib.data;
import cn.carlsky.nlr.lib.net;
import cn.carlsky.nlr.mcsm.System.VariableLibrary;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.io.IOException;

public class Ark {
    public static void Guider() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner("请输入方块盒子用户名：");
        String username = data.Scan();
        ThreadLogger.NoLine.INFO.Scanner("请输入方块盒子密码：");
        String password = data.Scan();

        ArkAccountVerifyTool(username, password);
    }

    public static void ArkAccountVerifyTool(String USERNAME, String PASSWORD) throws IOException {
        String AuthServer = net.fetch("https://auth.arkpowered.cn");
        JSONObject AuthServerJSON = JSON.parseObject(AuthServer);
        String AuthStatus = AuthServerJSON.getString("Status");

        if (AuthStatus.equals("NO")) {
            ThreadLogger.WARN.Output("登录没有成功，身份验证服务器正在停机维护");
        } else {

            String AuthURL = net.fetch("https://auth.arkpowered.cn");
            JSONObject AuthURLJSON = JSON.parseObject(AuthURL);
            String UserStatus = AuthURLJSON.getString("Status");

            if (UserStatus.equals("NO")) {

                ThreadLogger.WARN.Output("登录没有成功，请检查您的用户名和密码");

            } else {

                String ServerBack = GetUserStatusFromServer(USERNAME, PASSWORD);
                JSONObject ServerBackJSON = JSON.parseObject(ServerBack);
                String Token = ServerBackJSON.getString("userVerifyToken");

                VariableLibrary.Storage.UserLoginStatus = true;
                VariableLibrary.Storage.UserName = USERNAME;
                VariableLibrary.Storage.UserLoginToken = Token;

                ThreadLogger.INFO.Output("登录成功！");
            }
        }
        Ask.Continue();
        MainThread.Run();
    }

    public static String GetUserStatusFromServer(String Username, String Password) {
        String authURL = "https://auth.arkpowered.cn/api/account/arkpowered";
        String getInfo = "?method=login&username=" + Username + "&password=" + Password;


        String URL = authURL + getInfo;
        return net.fetch(URL);
    }

    public static void Logout() throws IOException {
        VariableLibrary.Storage.UserLoginStatus = false;
        VariableLibrary.Storage.UserName = null;
        VariableLibrary.Storage.UserLoginToken = null;

        ThreadLogger.INFO.Output("退出登录成功！");
        Ask.Continue();
    }
}
