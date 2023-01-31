package asia.carlsky.nlr.mcsm.System;

public class Initialization {
    public static void Start() {
        ThreadsOut.INFO.Output("=========================== Initialization ============================");
        ThreadsOut.INFO.Output(" 正在初始化程序...");
        FileExist.CheckFolder();
    }
}