package cn.carlsky.nlr.lib;

import java.util.HashMap;
import java.util.Random;

public class random {
    public static int RandomOnlyID() {
        Random RandomBuilder = new Random();

        int only_id = RandomBuilder.nextInt(99999999);

        return only_id;
    }
}
