package cn.carlsky.nlr.mcsm.Basics.Account;

import cn.carlsky.nlr.lib.io;
import cn.carlsky.nlr.mcsm.System.Ask;
import cn.carlsky.nlr.mcsm.System.MainThread;
import cn.carlsky.nlr.mcsm.System.ThreadLogger;
import cn.carlsky.nlr.lib.data;
import cn.carlsky.nlr.lib.net;
import cn.carlsky.nlr.mcsm.System.VariableLibrary;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.sun.tools.javac.Main;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Ark {
    public static void Guider() throws IOException {

        ThreadLogger.NoLine.INFO.Scanner("请输入方块盒子用户名：");
        String username = data.Scan();

        ThreadLogger.NoLine.INFO.Scanner("请输入方块盒子密码：");
        String password = data.Scan();

        ThreadLogger.NoLine.INFO.Scanner("是否记住此账户？(Y/N)：");
        String remember_account = data.Scan();

        ArkAccountVerifyTool(username, password, remember_account);

    }

    private static void ArkAccountVerifyTool(String USERNAME, String PASSWORD, String REMEMBER_ACCOUNT) throws IOException {

        Boolean remember;
        if (REMEMBER_ACCOUNT.equals("Y")) {
            remember = true;
        } else {
            remember = false;
        }

        String AuthServer = net.fetch("https://auth.arkpowered.cn");
        JSONObject AuthServerJSON = JSON.parseObject(AuthServer);
        String AuthStatus = AuthServerJSON.getString("Status");

        if (AuthStatus.equals("NO")) {
            ThreadLogger.WARN.Output("登录没有成功，身份验证服务器正在停机维护");
        } else {

            String authURL = "https://auth.arkpowered.cn/api/account/arkpowered";
            String getInfo = "?method=login&username=" + USERNAME + "&password=" + PASSWORD;


            String URL = authURL + getInfo;

            String AuthURL = net.fetch(URL);
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

                if (remember) {
                    // 把已存在的 main.properties 读到 VariableLibrary 中
                    Properties MainSetting = new Properties();
                    InputStream PropertiesStream = io.Properties.GetStream("MCServerManager/Setting/main.properties");
                    MainSetting.load(PropertiesStream);

                    MainSetting.setProperty("username", USERNAME);
                    MainSetting.setProperty("usertoken", Token);

                    try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("MCServerManager/Setting/main.properties"))){
                        MainSetting.store(bos, "MCSM Properties");
                    }
                }

                ThreadLogger.INFO.Output("登录成功！");
            }
        }
        Ask.Continue();
        MainThread.Run();
    }

    public static JSONObject ArkAccountVerify(String USERNAME, String PASSWORD){

        JSONObject RETURN = new JSONObject();

        String AuthServer = net.fetch("https://auth.arkpowered.cn");
        JSONObject AuthServerJSON = JSON.parseObject(AuthServer);
        String AuthStatus = AuthServerJSON.getString("Status");

        ThreadLogger.INFO.Output(" 验证服务器状态：" + AuthServerJSON);

        if (AuthStatus.equals("NO")) {
            RETURN.put("Status", "NO");
            RETURN.put("msg", " 自动登录没有成功，身份验证服务器正在停机维护");
        } else {

            String authURL = "https://auth.arkpowered.cn/api/account/arkpowered";
            String getInfo = "?method=login&username=" + USERNAME + "&password=" + PASSWORD;

            String URL = authURL + getInfo;

            String AuthURL = net.fetch(URL);
            JSONObject AuthURLJSON = JSON.parseObject(AuthURL);
            String UserStatus = AuthURLJSON.getString("Status");

            if (UserStatus.equals("NO")) {

                RETURN.put("Status", "NO");
                RETURN.put("msg", " 自动登录没有成功，请检查您的用户名和密码");

            } else {

                String Token = AuthURLJSON.getString("userVerifyToken");

                VariableLibrary.Storage.UserLoginStatus = true;
                VariableLibrary.Storage.UserName = USERNAME;
                VariableLibrary.Storage.UserLoginToken = Token;

                RETURN.put("Status", "OK");
                RETURN.put("msg", " 自动登录成功");
            }
        }
        return RETURN;
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
