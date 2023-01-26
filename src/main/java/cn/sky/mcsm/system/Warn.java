package cn.sky.mcsm.system;

import java.io.IOException;
import java.util.Scanner;

public class Warn {
    public static void WarnForUser(String Text) throws IOException {
        System.out.print(" " + Text + "\n");
        System.out.print(" 按回车键继续...");

        // 扫描 Code
        Scanner codeload = new Scanner(System.in);
        String code = codeload.nextLine();

        MainEntrance.MainEntrance();
    }
}
