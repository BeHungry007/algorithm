package face;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SafeSingleton {

    private static SafeSingleton s1 = new SafeSingleton();
    private static SafeSingleton s2 = null;

    private SafeSingleton() {

    }

    public static SafeSingleton getInstance1() {
        return s1;
    }

    public synchronized static SafeSingleton getInstance2() {
        if (s2 == null) {
            s2 = new SafeSingleton();
        }
        return s2;
    }


}
