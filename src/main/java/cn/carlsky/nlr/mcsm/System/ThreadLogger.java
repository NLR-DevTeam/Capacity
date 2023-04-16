package cn.carlsky.nlr.mcsm.System;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLogger {
    public class use {
        public static class OutLine {
            public static void NoHead() {
                System.out.println("");
            }
            public static void WithHead() {
                INFO.Output("");
            }
        }
    }
    public class INFO {
        public static void Output(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [INFO] [Output] " + TEXT);
        }

        public static void Scanner(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [INFO] [TYPEIN] " + TEXT);
        }

        public static void Checker(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [INFO] [Checker] " + TEXT);
        }
    }
    public class WARN {
        public static void Output(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [WARN] [Output] " + TEXT);
        }

        public static void Scanner(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [WARN] [TYPEIN] " + TEXT);
        }

        public static void Checker(String TEXT) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("[" + formatter.format(date) + "] [WARN] [Checker] " + TEXT);
        }
    }

    public class NoLine {
        public class INFO {
            public static void Output(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [INFO] [Output] " + TEXT);
            }

            public static void Scanner(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [INFO] [TYPEIN] " + TEXT);
            }

            public static void Checker(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [INFO] [Checker] " + TEXT);
            }
        }
        public class WARN {
            public static void Output(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [WARN] [Output] " + TEXT);
            }

            public static void Scanner(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [WARN] [TYPEIN] " + TEXT);
            }

            public static void Checker(String TEXT) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.print("[" + formatter.format(date) + "] [WARN] [Checker] " + TEXT);
            }
        }
    }
}
