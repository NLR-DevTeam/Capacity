package cn.carlsky.nlr.mcsm.Basics;

import cn.carlsky.nlr.mcsm.System.Ask;
import cn.carlsky.nlr.mcsm.System.MainThread;
import cn.carlsky.nlr.mcsm.System.ThreadLogger;
import cn.carlsky.nlr.mcsm.System.VariableLibrary;
import cn.carlsky.nlr.lib.data;

import java.io.IOException;

public class ProcessControl {
    public static void ReadThreadOutputStream() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner(" 请输入进程唯一识别ID：");
        String ONLY_ID = data.Scan();
        ThreadLogger.INFO.Output("");
        ThreadLogger.INFO.Output("");
        ThreadLogger.INFO.Output("");
        ThreadLogger.INFO.Output("=============================== 输出页面 ===============================");
        System.out.println(VariableLibrary.Storage.HashMapServerOutput.get(ONLY_ID));
        System.out.println("");
        ThreadLogger.INFO.Output("============================= 输出页面结束 ==============================");
        ThreadLogger.INFO.Output("");
        ThreadLogger.INFO.Output("");
        ThreadLogger.INFO.Output("");
        Ask.Continue();
        MainThread.RunServerPart();
    }

    public static void RunCommandInThread() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner(" 请输入进程唯一识别ID：");
        String ONLY_ID = data.Scan();
        if (ProcessChecker.CheckBasics(ONLY_ID)) {
            ThreadLogger.NoLine.INFO.Scanner(" 请输入执行命令：");
            String COMMAND = data.Scan();
            ProcessFunctionLibrary.WriteCommandToThread(ONLY_ID, COMMAND);
            ThreadLogger.INFO.Output(" 执行命令已发送...");
            Ask.Continue();
            MainThread.RunServerPart();
        } else {
            ThreadLogger.INFO.Output(" 未知的唯一识别ID/进程已结束？即将返回主菜单...");
        }
    }

    public static void StopServer() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner(" 请输入进程唯一识别ID：");
        String ONLY_ID = data.Scan();
        if (ProcessChecker.CheckBasics(ONLY_ID)) {
            VariableLibrary.Storage.HashMapServerProcess.get(ONLY_ID).destroy();
            ThreadLogger.INFO.Output(" 命令已发送...");
        } else {
            ThreadLogger.INFO.Output(" 未知的唯一识别ID/进程已结束？即将返回主菜单...");
        }
        Ask.Continue();
        MainThread.RunServerPart();
    }

    public static void DestroyServer() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner(" 请输入进程唯一识别ID：");
        String ONLY_ID = data.Scan();
        if (ProcessChecker.CheckBasics(ONLY_ID)) {
            VariableLibrary.Storage.HashMapServerProcess.get(ONLY_ID).destroy();
            VariableLibrary.Storage.HashMapServerProcess.remove(ONLY_ID);
            VariableLibrary.Storage.HashMapServerOutput.remove(ONLY_ID);
            VariableLibrary.Storage.HashMapServerJSONObject.remove(ONLY_ID);
        } else {
            if(VariableLibrary.Storage.HashMapServerOutput.containsKey(ONLY_ID)) {
                if(!VariableLibrary.Storage.HashMapServerProcess.get(ONLY_ID).isAlive()) {
                    VariableLibrary.Storage.HashMapServerProcess.remove(ONLY_ID);
                    VariableLibrary.Storage.HashMapServerOutput.remove(ONLY_ID);
                    VariableLibrary.Storage.HashMapServerJSONObject.remove(ONLY_ID);
                } else {
                    ThreadLogger.INFO.Output(" 错误有点奇怪...即将返回主菜单...");
                }
            } else {
                ThreadLogger.INFO.Output(" 未知的唯一识别ID？即将返回主菜单...");
            }
        }
    }

//    public static void RunOutput() throws IOException {
//        ThreadLogger.NoLine.INFO.Scanner(" 请输入进程唯一识别ID：");
//        String ONLY_ID = data.Scan();
//        if (ProcessChecker.CheckBasics(ONLY_ID)) {
//            ProcessFunctionLibrary.ProcessOutput(ONLY_ID);
//        } else {
//            ThreadLogger.INFO.Output(" 未知的唯一识别ID/进程已结束？即将返回主菜单...");
//        }
//        Ask.Continue();
//        MainThread.RunServerPart();
//    }

    public static class ProcessChecker {
        public static Boolean CheckBasics(String ONLY_ID) {
            if (VariableLibrary.Storage.HashMapServerOutput.containsKey(ONLY_ID)) {
                if (VariableLibrary.Storage.HashMapServerProcess.get(ONLY_ID).isAlive()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static void ListAllProcess() {
        for (String key : VariableLibrary.Storage.HashMapServerProcess.keySet()) {
            System.out.println("Key = " + key);
        }
        for (Process value : VariableLibrary.Storage.HashMapServerProcess.values()) {
            System.out.println("Value = " + value);
        }
    }
}
