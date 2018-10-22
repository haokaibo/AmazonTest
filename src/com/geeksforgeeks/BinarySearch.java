package com.geeksforgeeks;

public class BinarySearch {

    /*
    Binary Search with recursive method which takes O(logn) call stack space.
     */
    public static int binarySearch(int[] arr, int l, int r, int x) {
        if (arr == null || arr.length == 0 || r < l)
            return -1;
        int mid = l + (r - 1) / 2;
        if (arr[mid] == x)
            return mid;
        else if (arr[mid] < x) {
            return binarySearch(arr, mid + 1, r, x);
        } else {
            return binarySearch(arr, l, mid - 1, x);
        }
    }

    /*
    Binary Search with iterative binary search which take O(1) auxiliary search.
     */
    public static int binarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - 1) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = BinarySearch.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " +
                    result);

        result = BinarySearch.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " +
                    result);
    }
}
