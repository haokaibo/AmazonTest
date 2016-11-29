package com.amazon;

/**
 * Created by kaibohao on 2016-11-29.
 */
public class MergeSort {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] helpArray = new int[array.length];
        for (int i = low; i <= high; i++) {
            helpArray[i] = array[i];
        }
        int current = low;
        int helpLeft = low;
        int helpRight = mid + 1;
        while (helpLeft <= mid && helpRight <= high) {
            if (helpArray[helpLeft] < helpArray[helpRight]) {
                array[current] = helpArray[helpLeft];
                helpLeft++;
            } else {
                array[current] = helpArray[helpRight];
                helpRight++;
            }
            current++;
        }
        // move the rest element from the left array to the remaining mid position.
        for (int i = 0; i <= mid - helpLeft; i++) {
            array[current + i] = helpArray[helpLeft + i];
        }
    }
}
