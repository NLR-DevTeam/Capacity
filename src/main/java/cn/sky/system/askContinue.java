package cn.sky.system;

import java.io.IOException;
import java.util.Scanner;

public class askContinue {
    public static void Pause() throws IOException {
        System.out.print(" 按回车键继续...");

        // 扫描 Code
        Scanner codeload = new Scanner(System.in);
        String code = codeload.nextLine();

        MainEntrance.MainEntrance();
    }
}
