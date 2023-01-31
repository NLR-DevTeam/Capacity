package asia.carlsky.nlr.mcsm.Basics.Download;



import asia.carlsky.nlr.mcsm.Basics.Download.Node.VanillaServer;
import asia.carlsky.nlr.mcsm.System.GUI;
import asia.carlsky.nlr.mcsm.Basics.Download.Node.MohistServer;

import java.io.IOException;
import java.util.Scanner;

public class DownloadRequire {
    public static void DownloadMCServerVersion() throws IOException {

        GUI.Download();

        Scanner code = new Scanner(System.in);
        String code_input = code.nextLine();
        switch (code_input) {
            case "1":
                VanillaServer.AskVersion();
                break;
            case "2":
                MohistServer.AskVersion();
                break;
            default:
                DownloadMCServerVersion();
                break;
        }
    }
}
