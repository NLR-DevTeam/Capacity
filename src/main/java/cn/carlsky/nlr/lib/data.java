package cn.carlsky.nlr.lib;

import cn.carlsky.nlr.mcsm.System.VariableLibrary;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class data {
    public static String Scan() {

        Scanner codeload = new Scanner(System.in);
        String code = codeload.nextLine();

        return code;
    }

    public static class random {
        public static int RandomOnlyID() {
            Random RandomBuilder = new Random();

            int only_id = RandomBuilder.nextInt(99999);

            while(VariableLibrary.Storage.randIDMap.containsKey(only_id)) {
                only_id = RandomBuilder.nextInt(99999);
            }

            return only_id;
        }
    }

    public static class Time {
        public static String getDate() {
            return String.valueOf(new Date());
        }
        public static String getStartDate() {
            return String.valueOf(VariableLibrary.System.StartTime);
        }
    }
}
