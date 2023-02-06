import cn.carlsky.nlr.mcsm.System.Initialization;
import cn.carlsky.nlr.mcsm.System.MainThread;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 执行初始化程序，请不要删除此行
        Initialization.Start();
        // 进入正式入口
        MainThread.Run();
    }
}