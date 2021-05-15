package Algorithm.backtrace;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T_93 {
}

class Temple {
    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println(valid1("50"));
        StringBuilder s = new StringBuilder();
    }

    public static boolean valid1(String string) {
        Integer[] nums ={1,2,3};
        Set<Integer> set = new HashSet<>();
        set.addAll(new ArrayList<>(Arrays.asList(nums)));
        System.out.println(set);
        return false;

    }
}