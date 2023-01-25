package cn.sky.system;

import cn.sky.basics.FileGenerate;

import java.io.IOException;

public class Initialization {
    public static void Start() throws IOException {
        // 重置位置
        MainEntrance.Preposition();

        // 检查文件
        FileGenerate.checkSettingFileExist();
        FileGenerate.checkMCFileExist();
    }
}
