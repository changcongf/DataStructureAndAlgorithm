package DataStructure.list;

import java.util.Arrays;

/*
 * 简单线性表实现
 */
public class Array {

    private int length;
    private int[] array;
    private static final int DEFAULT_SIZE = 100;
    private int maxSize;

    public Array() {
        this.array = new int[DEFAULT_SIZE];
        this.length = 0;
        maxSize = DEFAULT_SIZE;
    }

    public Array(int[] array) {
        this.length = array.length;
        this.array = new int[DEFAULT_SIZE];
        System.arraycopy(array, 0, this.array, 0, length);
        maxSize = DEFAULT_SIZE;
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
