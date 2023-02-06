package cn.carlsky.nlr.mcsm.Basics;

import cn.carlsky.nlr.mcsm.System.MainThread;
import cn.carlsky.nlr.mcsm.System.ThreadLogger;
import cn.carlsky.nlr.mcsm.System.VariableLibrary;
import cn.carlsky.nlr.lib.data;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ProcessFunctionLibrary extends java.lang.Thread {
    public static Process MCProcess;
    public static String Only_ID;
    public static void CreateNewMCThread() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner("请输入服务器名称：");
        String SERVER_NAME = data.Scan();

        ThreadLogger.NoLine.INFO.Scanner("您想运行哪个文件夹下的服务端（例如 Server/1.8.9 目录下的就输入Server/1.8.9，当前目录则留空）：");
        String dir = data.Scan();

        ThreadLogger.NoLine.INFO.Scanner("请输入JAR服务端名称：");
        String runjar_mcsm = data.Scan();

        ThreadLogger.NoLine.INFO.Scanner("开启MCSM自动启动此服务器(Y/N)：");
        String Auto = data.Scan();

        Boolean AutoStart;

        if(Auto.equals("Y")) {
            AutoStart = true;
        } else {
            AutoStart = false;
        }

        List<String> commandList = new ArrayList();
            commandList.add("java");
            commandList.add("-jar");
            commandList.add(runjar_mcsm);
            try {
                if (dir.isEmpty()) {
                    MCProcess = new ProcessBuilder(commandList).start();
                } else {
                    MCProcess = new ProcessBuilder(commandList).directory(new File(dir)).start();
                }
            } catch (
                    IOException e
            ) {e.printStackTrace();}

        Thread BufferedReaderThread = new Thread(() -> {
            readProcessOutput(MCProcess);
        });

        BufferedReaderThread.start();

        Only_ID = String.valueOf(data.random.RandomOnlyID());

        JSONObject NewServerJSON = new JSONObject();
        NewServerJSON.put("ServerName", SERVER_NAME);
        NewServerJSON.put("ServerJarName", runjar_mcsm);
        NewServerJSON.put("CreateTime", data.Time.getDate());
        NewServerJSON.put("AuthStart", AutoStart);

        VariableLibrary.Storage.HashMapServerJSONObject.put(Only_ID, NewServerJSON);
        VariableLibrary.Storage.HashMapServerOutput.put(Only_ID, "我的世界服务器 输出记录仪记录中...\nMinecraft Server Output Recording...\n");
        VariableLibrary.Storage.HashMapServerProcess.put(Only_ID, MCProcess);
        VariableLibrary.Storage.HashMapServerStartCommand.put(Only_ID, commandList);

        JSONObject SetContent = new JSONObject();
        SetContent.put("ServerName",SERVER_NAME);
        SetContent.put("ServerDir",dir);
        SetContent.put("ServerJarName",runjar_mcsm);
        SetContent.put("AutoStart", AutoStart);

        // 写入 Server List

        Properties MainSetting = new Properties();
        InputStream PropertiesStream = new FileInputStream("MCServerManager/Setting/main.properties");

        MainSetting.load(PropertiesStream);
        String ServerList = MainSetting.getProperty("serverList");
        JSONObject SettingJSON = JSON.parseObject(ServerList);

        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("MCServerManager/Setting/main.properties"))){

            SettingJSON.put(Only_ID, SetContent);
            MainSetting.setProperty("serverList", SettingJSON.toJSONString());
            MainSetting.store(bos, "MCSM Properties");

        }

        MainThread.RunServerPart();
    }

    public static void RegisterNewMCThread(String SERVER_NAME, String dir, String runjar_mcsm, String Only_ID) throws IOException {

        List<String> commandList = new ArrayList();
        commandList.add("java");
        commandList.add("-jar");
        commandList.add(runjar_mcsm);

        try {
            if (dir.isEmpty()) {
                MCProcess = new ProcessBuilder(commandList).start();
            } else {
                MCProcess = new ProcessBuilder(commandList).directory(new File(dir)).start();
            }
        } catch (
                IOException e
        ) {e.printStackTrace();}

        Thread BufferedReaderThread = new Thread(() -> {
            readProcessOutput(MCProcess);
        });
        BufferedReaderThread.start();

        JSONObject NewServerJSON = new JSONObject();
        NewServerJSON.put("ServerName", SERVER_NAME);
        NewServerJSON.put("ServerJarName", runjar_mcsm);
        NewServerJSON.put("CreateTime", data.Time.getDate());
        NewServerJSON.put("AuthStart", true);

        VariableLibrary.Storage.HashMapServerJSONObject.put(Only_ID, NewServerJSON);
        VariableLibrary.Storage.HashMapServerOutput.put(Only_ID, "我的世界服务器 输出记录仪记录中...\nMinecraft Server Output Recording...\n");
        VariableLibrary.Storage.HashMapServerProcess.put(Only_ID, MCProcess);
        VariableLibrary.Storage.HashMapServerStartCommand.put(Only_ID, commandList);
    }
    public static void WriteCommandToThread(String Only_ID, String COMMAND) throws IOException {

        String Now_Write = COMMAND + "\n";
        VariableLibrary.Storage.HashMapServerProcess.get(Only_ID).getOutputStream().write(Now_Write.getBytes());
        VariableLibrary.Storage.HashMapServerProcess.get(Only_ID).getOutputStream().flush();

    }





    private static void readProcessOutput(Process process){
        read(process.getInputStream(), System.out);
        read(process.getErrorStream(), System.err);
    }
    private static void read (InputStream inputStream, PrintStream out) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                VariableLibrary.Storage.HashMapServerOutput.replace(Only_ID, VariableLibrary.Storage.HashMapServerOutput.get(Only_ID) + "\n" + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
