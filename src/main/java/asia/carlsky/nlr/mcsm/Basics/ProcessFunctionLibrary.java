package asia.carlsky.nlr.mcsm.Basics;

import asia.carlsky.nlr.mcsm.System.Ask;
import asia.carlsky.nlr.mcsm.System.MainThread;
import asia.carlsky.nlr.mcsm.System.ThreadsOut;
import asia.carlsky.nlr.mcsm.System.VariableLibrary;
import asia.carlsky.nlr.lib.data;
import asia.carlsky.nlr.lib.random;
import com.alibaba.fastjson2.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProcessFunctionLibrary extends java.lang.Thread {
    public static String runjar_mcsm;
    public static Process MCProcess;
    public static String Only_ID;
    public static void CreateNewMCThread() throws IOException {
        ThreadsOut.NoLine.INFO.Scanner("请输入服务器名称：");
        String SERVER_NAME = data.Scan();

        ThreadsOut.NoLine.INFO.Scanner("请输入JAR服务端名称：");
        String runjar_mcsm = data.Scan();

//        Thread MCThread = new Thread(() -> {
            List<String> commandList = new ArrayList();
            commandList.add("java");
            commandList.add("-jar");
            commandList.add(runjar_mcsm);
            commandList.add("-nogui");

            try {
                MCProcess = new ProcessBuilder(commandList).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        });

        Thread BufferedReaderThread = new Thread(() -> {
            readProcessOutput(MCProcess);
        });

            BufferedReaderThread.start();

        Only_ID = String.valueOf(random.RandomOnlyID());

        JSONObject NewServerJSON = new JSONObject();
        NewServerJSON.put("ServerName", SERVER_NAME);
        NewServerJSON.put("ServerJarName", runjar_mcsm);
        NewServerJSON.put("CreateTime", VariableLibrary.System.DATE);
        VariableLibrary.Storage.HashMapServerJSONObject.put(Only_ID, NewServerJSON);
        VariableLibrary.Storage.HashMapServerOutput.put(Only_ID, "");
        VariableLibrary.Storage.HashMapServerProcess.put(Only_ID, MCProcess);

        MainThread.RunServerPart();
    }
    public static void WriteCommandToThread(String Only_ID, String COMMAND) throws IOException {
        Process ChangedProcess = (Process) VariableLibrary.Storage.HashMapServerProcess.get(Only_ID);
        OutputStream ProcessOutStream = ChangedProcess.getOutputStream();

        ProcessOutStream.write(COMMAND.getBytes());
    }
    public static void ProcessOutput(String Only_ID) throws IOException {
        System.out.println(VariableLibrary.Storage.HashMapServerOutput.get(Only_ID));
        Ask.Continue();
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
