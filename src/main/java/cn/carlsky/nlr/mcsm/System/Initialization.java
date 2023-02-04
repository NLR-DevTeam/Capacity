package cn.carlsky.nlr.mcsm.System;

public class Initialization {
    public static void Start() {
        ThreadLogger.INFO.Output("=========================== Initialization ============================");
        ThreadLogger.INFO.Output(" 正在初始化程序...");
        FileExist.CheckFolder();
    }
}