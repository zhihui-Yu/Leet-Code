package com.sort;

import java.util.Arrays;

/**
 * @author simple
 */
public class Bubble {
    // base : for each the arr and let the biggest num to the top every times.
    private void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }

    // optimization: decrease the cycle scope
    private void optimizationBubbleSort(int[] arr) {
        int len = arr.length;
        boolean sorted = true; // first step: if the array already sorted, then break the cycle.
        int sortedBorder = len - 1;  // second step: for decrease the cycle scope. (sometimes some numbers are sorted when they are given.)
        int lastExchangeIndex = 0;
        for (int i = 0; i < len; i++) {
            sorted = true;
            for (int j = 0; j < sortedBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    sorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortedBorder = lastExchangeIndex;
            if (sorted) break;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 12, 3, 4, 1, 6, 4, 5, 7};
        Bubble bubble = new Bubble();
//        bubble.bubbleSort(arr);
        bubble.optimizationBubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
