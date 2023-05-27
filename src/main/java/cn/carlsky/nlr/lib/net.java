package cn.carlsky.nlr.lib;

import cn.carlsky.nlr.mcsm.System.ThreadLogger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class net {
    public static String fetch(String url) {
        StringBuilder json = new StringBuilder();
        try {
            // 输入URL
            URL urlObject = new URL(url);
            // 创建连接一个 Connection
            URLConnection uc = urlObject.openConnection();
            uc.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            ThreadLogger.WARN.Output(" 网络连接已断开... 正在退出程序");
            System.exit(0);
        }
        return json.toString();
    }
}
