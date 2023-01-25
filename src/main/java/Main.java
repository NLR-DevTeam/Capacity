// 这里是程序入口
// Now Using Java JDK 17.0.5

import cn.sky.basics.FileGenerate;
import cn.sky.system.MainEntrance;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 重置位置
        MainEntrance.Preposition();

        FileGenerate.checkSettingFileExist();
        FileGenerate.checkMCFileExist();

        MainEntrance.MainEntrance();
    }
}