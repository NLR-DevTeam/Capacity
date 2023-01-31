package asia.carlsky.nlr.lib;

import java.io.FileWriter;
import java.io.IOException;

public class io {
    public static void FileWriter(String filepath, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.append(content);
        }
    }
}
