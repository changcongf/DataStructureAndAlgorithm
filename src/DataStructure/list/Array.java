package DataStructure.list;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] a = {1, 2, 3,5,7,3,9,11,23,4};
        Array array = new Array(a);
        //System.out.println(array.findIndex(23));
        array.insert(11, 999);
        array.print();
        while (true) {}
    }


    private int length;
    private int[] array;
    private static final int DEFAULTSIZE = 100;
    private int maxSize;

    public Array() {
        this.array = new int[DEFAULTSIZE];
        this.length = 0;
        maxSize = DEFAULTSIZE;
    }

    public Array(int[] array) {
        this.length = array.length;
        this.array = new int[DEFAULTSIZE];
        System.arraycopy(array, 0, this.array, 0, length);
        maxSize = DEFAULTSIZE;
    }

    public Array(int size) {
        maxSize = size;
        this.array = new int[size];
        this.length = 0;
    }

    public int findIndex(int target) {
        if (length <= 0) return -1;
        int i = 0;
        for (; i < length && array[i] != target; i++) {
        }

        return i != length ? i + 1 : -1;
    }

    public boolean insert(int index, int target) {
        if (index > length + 1 || length == maxSize || index < 1) return false;

        for (int i = length; i >= index; i--) {
            array[i] = array[i - 1];
        }
        array[index - 1] =  target;
        length++;
        return true;
    }

    public int delete(int index) {
        if (index < 1 || index > length) {
            System.out.println("输入不合法");
            return Integer.MIN_VALUE;
        }
        int ret = array[index - 1];
        for (int i = index - 1; i < length - 1; i++) {
            array[i] = array[i - 1];
        }
        length--;
        return ret;
    }

    public void print() {
        int[] b = new int[length];
        System.arraycopy(array, 0, b, 0, length);
        System.out.println(Arrays.toString(b));
    }

    public int getLength() {
        return length;
    }


}
