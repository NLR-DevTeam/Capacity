package cn.sky.mcsm.basics.Download.Node;

import cn.sky.mcsm.system.output.ThreadsOut;
import cn.sky.mcsm.system.askContinue;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class MohistServer {
    public static void AskVersion() throws IOException {
        ThreadsOut.outWithNoLine("请输入下载Mohist服务端版本（例：1.19.3）：","INFO" , "Main Thread", "Scanner");

        Scanner code = new Scanner(System.in);
        String code_input = code.nextLine();

        if(!(code_input == null)){
            System.out.println("正在下载......");
            DownloadServer(code_input);
        }
    }
    public static void DownloadServer(String version) throws IOException {
        String FILE_URL = "https://mohistmc.com/api/" + version + "/latest/download";

        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("server_" + version + "_mohistmc_mcsm.jar")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("下载完成 Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        askContinue.Pause();
    }
}
