package cn.carlsky.nlr.mcsm.Basics;

import cn.carlsky.nlr.mcsm.System.MainThread;
import cn.carlsky.nlr.mcsm.System.ThreadLogger;
import cn.carlsky.nlr.mcsm.System.VariableLibrary;
import cn.carlsky.nlr.lib.data;
import com.alibaba.fastjson2.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProcessFunctionLibrary extends java.lang.Thread {
    public static String runjar_mcsm;
    public static Process MCProcess;
    public static String Only_ID;
    public static void CreateNewMCThread() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner("请输入服务器名称：");
        String SERVER_NAME = data.Scan();

        ThreadLogger.NoLine.INFO.Scanner("请输入JAR服务端名称：");
        String runjar_mcsm = data.Scan();

        ThreadLogger.NoLine.INFO.Scanner("您想运行哪个文件夹下的服务端（例如Server/1.8.9/目录下的就输入Server/1.8.9，当前目录则留空）：");
        String dir = data.Scan();

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread BufferedReaderThread = new Thread(() -> {
            readProcessOutput(MCProcess);
        });

        BufferedReaderThread.start();

        Only_ID = String.valueOf(data.random.RandomOnlyID());

        JSONObject NewServerJSON = new JSONObject();
        NewServerJSON.put("ServerName", SERVER_NAME);
        NewServerJSON.put("ServerJarName", runjar_mcsm);
        NewServerJSON.put("CreateTime", data.Time.getDate());
        VariableLibrary.Storage.HashMapServerJSONObject.put(Only_ID, NewServerJSON);
        VariableLibrary.Storage.HashMapServerOutput.put(Only_ID, "");
        VariableLibrary.Storage.HashMapServerProcess.put(Only_ID, MCProcess);

        MainThread.RunServerPart();
    }
    public static void WriteCommandToThread(String Only_ID, String COMMAND) throws IOException {
        String Now_Write = COMMAND + "\n";
        VariableLibrary.Storage.HashMapServerProcess.get(Only_ID).getOutputStream().write(Now_Write.getBytes());
        VariableLibrary.Storage.HashMapServerProcess.get(Only_ID).getOutputStream().flush();
    }
    public static void ProcessOutput(String Only_ID) throws IOException {
        System.out.println(VariableLibrary.Storage.HashMapServerOutput.get(Only_ID));
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
