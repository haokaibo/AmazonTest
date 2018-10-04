package com.google;

import java.util.HashMap;

public class Inversions {

    Element[] elements = null;

    class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }


    public int countInversions(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        elements = new Element[arr.length];
        for (int i = 0; i < arr.length; i++)
            elements[i] = new Element(arr[i], i);

        // quick sort the array
        int head = 0;
        int tail = arr.length - 1;
        quickSort(elements, head, tail);

        // compare the index of each element in the array and calculate the inversions for each element.
        int invertions = 0;
        for (int j = 0; j < elements.length; j++) {
            System.out.printf("v: %d o: %d c: %d o-c=%d\n",
                    elements[j].value,
                    elements[j].index,
                    j,
                    j - elements[j].index);
            if (elements[j].index < j)
                invertions += j - elements[j].index;
        }

        return invertions;
    }

    private void quickSort(Element[] elements, int head, int tail) {
        int mid = head + (tail - head) / 2;
        int pivot = elements[mid].value;
        int i = head;
        int j = tail;
        while (i <= j) {
            while (elements[i].value < pivot) {
                i++;
            }
            while (elements[j].value > pivot) {
                j--;
            }
            if (i <= j) {
                swap(elements, i, j);
                i++;
                j--;
            }
        }

        if (i < tail) {
            quickSort(elements, i, tail);
        }
        if (j > head) {
            quickSort(elements, head, j);
        }
    }

    private void swap(Element[] elements, int i, int j) {
        Element temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;

    }

}
