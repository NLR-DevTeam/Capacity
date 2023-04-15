package cn.carlsky.nlr.mcsm.Basics;

import cn.carlsky.nlr.lib.data;
import cn.carlsky.nlr.mcsm.System.*;
import com.alibaba.fastjson2.JSONObject;

import java.io.IOException;

public class PresetTasks {
    public static void CreateGUI() throws IOException {

        GUI.PresetTasksGUI();

        // 主要部分
        String CODE = data.Scan();

        switch (CODE) {
            case "1":
                CreateTasks();
            case "2":
                RunTask();
            case "99":
                MainThread.Run();
            default:
                CreateGUI();
        }
    }

    public static void CreateTasks() {
        ThreadLogger.NoLine.INFO.Scanner("请输入指定服务器的OnlyID：");
        String ONLY_ID = data.Scan();

        ThreadLogger.NoLine.INFO.Scanner("请输入执行命令：");
        String COMMAND = data.Scan();

        Create(ONLY_ID, COMMAND);
    }

    public static void RunTask() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner("请输入任务ID：");
        String CommandID = data.Scan();

        Run (CommandID);
    }

    // Private Control 部分
    private static void Create(String ONLY_ID, String COMMAND) {
        if(VariableLibrary.Storage.HashMapServerOutput.containsKey(ONLY_ID)) {

            String CommandID = String.valueOf(data.random.RandomOnlyID());

            JSONObject JSONValue = new JSONObject();
            JSONValue.put("command", COMMAND);
            JSONValue.put("only_id", ONLY_ID);
            VariableLibrary.Storage.HashMapPresetTaskManager.put(CommandID, JSONValue);
            ThreadLogger.INFO.Output(" 创建任务成功");
            Ask.Continue();
        } else {
            ThreadLogger.INFO.Output(" 未知的唯一识别ID？即将返回主菜单...");
        }
    }

    private static void Run(String CommandID) throws IOException {
        if (VariableLibrary.Storage.HashMapPresetTaskManager.containsKey(CommandID)) {

            JSONObject JSONValue = VariableLibrary.Storage.HashMapPresetTaskManager.get(CommandID);

            String COMMAND = JSONValue.getString("command");
            String ONLY_ID = JSONValue.getString("only_id");

            ProcessFunctionLibrary.WriteCommandToThread(ONLY_ID, COMMAND);
        }
    }
}