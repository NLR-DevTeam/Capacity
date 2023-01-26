package cn.sky.mcsm.system;

import cn.sky.mcsm.system.output.ThreadsOut;

import java.io.IOException;
import java.util.Scanner;

public class askExit {
    public static void askExit() throws IOException {
        ThreadsOut.outWithNoLine(" 您确定要退出程序？（1为退出，其他数字为不退出）：","INFO" , "Main Thread", "Scanner");

        // 扫描 Code
        Scanner codeload = new Scanner(System.in);
        int code = codeload.nextInt();

        switch (code){
            case 1:
                System.exit(0);
            case 114514:
                ThreadsOut.outNormal(" 臭死力（悲，赶紧回去罢","INFO" , "Main 臭", "田所浩二的会员制Output");
                MainEntrance.MainEntrance();
            default:
                MainEntrance.MainEntrance();
        }
    }
}
