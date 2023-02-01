package cn.carlsky.nlr.mcsm.lib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerManager {
    public static Process NewServerProcess;

    public static Process CreateNewServer(String runjar) {
        List<String> commandList = new ArrayList();

        commandList.add("java");
        commandList.add("-jar");
        commandList.add(runjar);

        commandList.add("-nogui");
        commandList.add("-Xms4G");
        commandList.add("-Xmx4G");

        try {
            NewServerProcess = new ProcessBuilder(commandList).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return NewServerProcess;
    }
}
