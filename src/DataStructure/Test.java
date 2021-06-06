package DataStructure;

import DataStructure.list.Array;

public class Test {
    public static void main(String[] args) {

    }

    public void arrayTest() {
        int[] a = {1, 2, 3,5,7,3,9,11,23,4};
        Array array = new Array(a);
        //System.out.println(array.findIndex(23));
        array.insert(11, 999);
        array.print();
        while (true) {}
    }
}
