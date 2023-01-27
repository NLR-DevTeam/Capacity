package cn.sky.mcsm.basics;

import cn.sky.mcsm.system.BaseManager;
import cn.sky.mcsm.system.askContinue;
import cn.sky.mcsm.system.output.ThreadsOut;

import java.io.*;
import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerManager {
    public static void runServer() throws IOException {
        if(!BaseManager.SERVER_RUN_STATUS){
            ThreadsOut.outWithNoLine("请输入执行服务端版本和类型，用下划线连接（例：1.8.9_original，1.16.5_mohistmc）：","INFO" , "Main Thread", "Scanner");

            Scanner coderun = new Scanner(System.in);
            String runjar_mcsm = coderun.next();

            BaseManager.SERVER_RUN_STATUS = true;

            List<String> commandList = new ArrayList();
                commandList.add("java");
                commandList.add("-jar");
                commandList.add("server_" + runjar_mcsm + "_mcsm.jar");

            try {
                Process MCProcess = new ProcessBuilder(commandList).inheritIO().start();

                OutputStream OutputMCProcess = MCProcess.getOutputStream();

                OutputMCProcess.flush();
                OutputMCProcess.close();

                MCProcess.waitFor();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            BaseManager.SERVER_RUN_STATUS = false;
            askContinue.Pause();
        }else{
            System.out.println("服务器已经启动，请不要再次启动");

            askContinue.Pause();
        }
    }

    public static void runCustomServer() throws IOException {
        if(!BaseManager.SERVER_RUN_STATUS){
            ThreadsOut.outWithNoLine("请输入执行服务端名称（同一目录或完整路径）：","INFO" , "Main Thread", "Scanner");

            Scanner coderun = new Scanner(System.in);
            String runjar = coderun.next();

            BaseManager.SERVER_RUN_STATUS = true;

            List<String> commandList = new ArrayList();
            commandList.add("java");
            commandList.add("-jar");
            commandList.add(runjar);

            try {
                Process MCProcess = new ProcessBuilder(commandList).inheritIO().start();

                OutputStream OutputMCProcess = MCProcess.getOutputStream();

                OutputMCProcess.flush();
                OutputMCProcess.close();

                MCProcess.waitFor();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            BaseManager.SERVER_RUN_STATUS = false;
            askContinue.Pause();
        }else{
            System.out.println("服务器已经启动，请不要再次启动");

            askContinue.Pause();
        }
    }
}