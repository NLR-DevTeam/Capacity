package cn.carlsky.nlr.mcsm.Basics.MCProperties;

import cn.carlsky.nlr.mcsm.System.GUI;
import cn.carlsky.nlr.mcsm.System.MainThread;
import cn.carlsky.nlr.lib.data;

import java.io.IOException;

public class SetProperties {
    public static void Guider() throws IOException {

        GUI.SetProperties();

        String CODE = data.Scan();

        switch (CODE) {
            case "1":
                Set.SetSeed();
                break;
            case "2":
                Set.SetPort();
                break;
            case "3":
                Set.SetMOTD();
                break;
            case "4":
                Set.SetMaxPlayers();
                break;
            case "5":
                Set.SetMaxMapHeight();
                break;
            case "6":
                Set.SetPVP();
                break;
            case "7":
                Set.SetOnlineMode();
                break;
            case "8":
                Set.SetDifficulty();
                break;
            case "9":
                Set.SetWhiteList();
                break;
            case "10":
                Set.SetFly();
                break;
            case "11":
                MainThread.Run();
                break;
        }
    }
}
