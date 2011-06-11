package org.huys.algo.sort;

import java.util.Arrays;

public class ComparisionCountingSort {
    public static int[] sort(int[] aArray) {
        int n = aArray.length;
        int sArray[] = new int[n];
        int nCount[] = new int[n];
        Arrays.fill(sArray, 0);
        Arrays.fill(nCount, 0);

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (aArray[i]<aArray[j]) {
                    nCount[j]++;
                } else {
                    nCount[i]++;
                }
            }
        }

        for (int k=0; k<n; k++) {
            sArray[nCount[k]] = aArray[k];
        }

        return sArray;
    }

    public static void main(String[] args) {

        int cc[] = { 2, 3, 2, 4, 9, 0};

        System.out.println("Before sort:");
        for (int i=0; i<cc.length; i++) {
            System.out.println(cc[i]);
        }

        cc = ComparisionCountingSort.sort(cc);

        System.out.println("After sort:");
        for (int i=0; i<cc.length; i++) {
            System.out.println(cc[i]);
        }
    }
}

