package cn.sky.basics;

import cn.sky.method.getURL;
import cn.sky.system.askContinue;
import cn.sky.system.output.ThreadsOut;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckIPAddress {
    /**
     * 仅工作于 Windows 系统
     * 使用 Linux 系统可能会导致内网IP地址输出 127.0.0.1（localhost）
     */
    public static void getIpAddressInWindows() {
        try {
            ThreadsOut.outNormal(" 输出中...","INFO" , "Main Thread", "Output");
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(" 主机名：" + address.getHostName());
            System.out.println(" IP地址：");
            System.out.println(" " + address.getHostAddress());
            System.out.println(" 公网IP地址查询：" + getURL.get("https://api.arkpowered.cn/library/public/network/getip"));
            askContinue.Pause();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
