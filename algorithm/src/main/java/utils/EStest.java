package utils;

import org.junit.Test;
import utils.Node;

public class EStest implements Cloneable{

    public static void main(String[] args) {
        double i = 50000;

        double count = i;
        for (int j = 0; j < 12 * 19; j++) {
            i = i * 1.005 + 1500;
            count += 1500;
        }
        System.out.println(i);
        System.out.println(count);
    }
}