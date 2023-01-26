package cn.sky.mcsm.method;

import cn.sky.mcsm.system.askContinue;

import java.io.File;
import java.io.IOException;

public class listDirFiles {
    public static void listDirFiles(String path) throws IOException {
        File file = new File(path);
        showList(file);
        askContinue.Pause();
    }

    private static void showList(File file) {
        if (file.isDirectory()) {
            System.out.println("文件夹:" + file.getPath());
            File[] listFiles = file.listFiles();
            for (File f : listFiles) {
                showList(f);
            }
        } else if (file.isFile()) {
            System.out.println("文件:" + file.getPath());
        }else{
            System.out.println("目录目前不存在：可能未运行服务端/不是相应API的客户端");
        }
    }

    public static void showList_JAR(File file) {
        if (file.isDirectory()) {
            System.out.println("文件夹:" + file.getPath());
            File[] listFiles = file.listFiles();
            for (File f : listFiles) {
                showList(f);
            }
        } else if (file.isFile()) {
            if(checkLast()){
                System.out.println("服务端文件:" + file.getPath());
            }
        }else{
            System.out.println("目录目前不存在：可能未运行服务端/不是相应API的客户端");
        }
    }

    public static boolean isValid(String contentType, String... allowTypes) {
        if (null == contentType || "".equals(contentType)) {
            return false;
        }
        for (String type : allowTypes) {
            if (contentType.indexOf(type) > -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLast() {
        String[] allowTypes = new String[] { ".jar"};
        Boolean CanUploaded = isValid("/", allowTypes);
        if (CanUploaded) {
            return true;
        } else {
            return false;
        }
    }
}
