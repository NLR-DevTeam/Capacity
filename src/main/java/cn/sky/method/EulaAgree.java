package cn.sky.method;

import cn.sky.basics.WriteFiles;
import cn.sky.system.MainEntrance;

import java.io.IOException;

public class EulaAgree {
    public static void EulaAgree() throws IOException {
        WriteFiles.fileWriterMethod("eula.txt", "eula=true");
        MainEntrance.MainEntrance();
    }
}
