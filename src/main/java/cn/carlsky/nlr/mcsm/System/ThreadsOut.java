package cn.carlsky.nlr.mcsm.System;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadsOut {
    public class INFO {
        public static void Output(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [MCSManager/INFO] [Output] " + TEXT);
        }

        public static void Scanner(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [MCSManager/INFO] [Scanner] " + TEXT);
        }

        public static void Checker(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [MCSManager/INFO] [Checker] " + TEXT);
        }
    }
    public class WARN {
        public static void Output(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [MCSManager/WARN] [Output] " + TEXT);
        }

        public static void Scanner(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [MCSManager/WARN] [Scanner] " + TEXT);
        }

        public static void Checker(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [MCSManager/WARN] [Checker] " + TEXT);
        }
    }

    public class NoLine {
        public class INFO {
            public static void Output(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [MCSManager/INFO] [Output] " + TEXT);
            }

            public static void Scanner(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [MCSManager/INFO] [Scanner] " + TEXT);
            }

            public static void Checker(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [MCSManager/INFO] [Checker] " + TEXT);
            }
        }
        public class WARN {
            public static void Output(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [MCSManager/WARN] [Output] " + TEXT);
            }

            public static void Scanner(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [MCSManager/WARN] [Scanner] " + TEXT);
            }

            public static void Checker(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [MCSManager/WARN] [Checker] " + TEXT);
            }
        }
    }
}
