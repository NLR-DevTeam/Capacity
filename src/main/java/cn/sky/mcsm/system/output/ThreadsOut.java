package cn.sky.mcsm.system.output;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadsOut {
    public static void outNormal(String TEXT, String OUTTYPE, String TYPES ,String THREADSNAME) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("[" + formatter.format(date) + "] [MCSManager/" + OUTTYPE + "] [" + TYPES + "/" + THREADSNAME + "] " + TEXT);
    }

    public static void outWithNoLine(String TEXT, String OUTTYPE, String TYPES ,String THREADSNAME) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        Date date = new Date(System.currentTimeMillis());
        System.out.print("[" + formatter.format(date) + "] [MCSManager/" + OUTTYPE + "] [" + TYPES + "/" + THREADSNAME + "] " + TEXT);
    }
}
