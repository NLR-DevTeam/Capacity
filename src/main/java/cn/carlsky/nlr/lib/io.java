package cn.carlsky.nlr.lib;

import java.io.*;
import java.util.Properties;

public class io {
    public static void FileWriter(String filepath, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.append(content);
        }
    }
    public static String FileReader(String filepath) throws IOException {

        FileInputStream InputStream = null;
        try {
            InputStream = new FileInputStream(filepath);
            byte[] buff = new byte[1024];
            int length = InputStream.read(buff);
            String Content = new String(buff, 0, length);

            return Content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (InputStream != null) {
                InputStream.close();
            }
        }
    }

    public class Properties{
        public static InputStream GetStream(String Path) throws FileNotFoundException {
            InputStream Stream=new FileInputStream(Path);
            return Stream;
        }
    }
}
