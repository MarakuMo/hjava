package org.huys.algo.search;

class SequentialSearchGeneric<T> {
    public int search(T[] array, T target) {
        for (int i=0; i<array.length; ++i) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}

public class SequentialSearch {
    public static void main(String[] args) {

        SequentialSearchGeneric<Integer> sh = new SequentialSearchGeneric<Integer>();

        Integer[] array = {1, 2, 3, 4, 5};

        System.out.println(sh.search(array, 4));

    }
}
