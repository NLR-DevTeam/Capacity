package cn.sky.mcsm.basics.account;

import cn.sky.mcsm.lib.Function.Fetcher;

public class GetLogin {
    public static String LoginToArkPowered(String Username, String Password) {
        String authURL = "https://auth.arkpowered.cn/api/account/arkpowered";
        String getInfo = "?method=login&username=" + Username + "&password=" + Password;


        String URL = authURL + getInfo;
        return Fetcher.fetch(URL);
    }
}