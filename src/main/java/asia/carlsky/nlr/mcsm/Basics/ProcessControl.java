package asia.carlsky.nlr.mcsm.Basics;

import asia.carlsky.nlr.mcsm.System.MainThread;
import asia.carlsky.nlr.mcsm.System.ThreadsOut;
import asia.carlsky.nlr.mcsm.System.VariableLibrary;
import asia.carlsky.nlr.lib.data;

import java.io.IOException;

public class ProcessControl {
    public static void ReadThreadOutputStream() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入进程唯一识别ID：");
        String ONLY_ID = data.Scan();
        ThreadsOut.INFO.Output("");
        ThreadsOut.INFO.Output("");
        ThreadsOut.INFO.Output("");
        ThreadsOut.INFO.Output("=============================== 输出页面 ===============================");
        System.out.println(VariableLibrary.Storage.HashMapServerOutput.get(ONLY_ID));
        ThreadsOut.INFO.Output("=============================== 输出页面 ===============================");
        ThreadsOut.INFO.Output("");
        ThreadsOut.INFO.Output("");
        ThreadsOut.INFO.Output("");
        MainThread.RunServerPart();
    }

    public static void RunCommandInThread() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入进程唯一识别ID：");
        String ONLY_ID = data.Scan();
        ThreadsOut.NoLine.INFO.Scanner(" 请输入执行命令：");
        String COMMAND = data.Scan();
        ProcessFunctionLibrary.WriteCommandToThread(ONLY_ID, COMMAND);
        MainThread.RunServerPart();
    }

    public static void RunOutput() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner(" 请输入进程唯一识别ID：");
        String ONLY_ID = data.Scan();
        ProcessFunctionLibrary.ProcessOutput(ONLY_ID);
        MainThread.RunServerPart();
    }
}
