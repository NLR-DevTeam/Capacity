package cn.sky.mcsm.method;

import cn.sky.mcsm.basics.WriteFiles;
import cn.sky.mcsm.system.MainEntrance;

import java.io.IOException;

public class EulaAgree {
    public static void EulaAgree() throws IOException {
        WriteFiles.fileWriterMethod("eula.txt", "eula=true");
        MainEntrance.MainEntrance();
    }
}
