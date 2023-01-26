package cn.sky.mcsm.basics.Download.Node;

import cn.sky.mcsm.system.askContinue;
import cn.sky.mcsm.system.output.ThreadsOut;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class VanillaServer {
    public static void AskVersion() throws IOException {
        ThreadsOut.outWithNoLine("请输入下载原版服务端版本（例：1.19.3）：","INFO" , "Main Thread", "Scanner");

        Scanner code = new Scanner(System.in);
        String code_input = code.nextLine();

        if(!(code_input == null)){
            System.out.println("正在下载......");
            DownloadServer(code_input);
        }
    }
    public static void DownloadServer(String version) throws IOException {
        String FILE_URL = "https://bmclapi2.bangbang93.com/version/" + version + "/server";

        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("server_" + version + "_original_mcsm.jar")) {
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
