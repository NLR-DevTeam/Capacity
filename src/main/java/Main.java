// 这里是程序入口
// Now Using Java JDK 17.0.5

import cn.sky.mcsm.system.Initialization;
import cn.sky.mcsm.system.MainEntrance;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 初始化
        Initialization.Start();
        // 进入主程序
        MainEntrance.MainEntrance();
    }
}