package com.amazon;

import java.util.Arrays;

/**
 * Created by kaibohao on 2016-11-12.
 */
public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    public MinIntHeap() {

    }

    public MinIntHeap(int capacity) {
        this.capacity = capacity;
        this.items = new int[this.capacity];
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int getSize() {
        return size;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public int removeByValue(int value) {
        if (size == 0)
            return -1;
        int index = binarySearchIndexByValue(0, value);
        items[index] = items[size - 1];
        size--;
        heapifyDown(index);
        return index;
    }

    private int binarySearchIndexByValue(int index, int value) {
        int result = -1;
        if (items[index] == value)
            return index;
        if (items[index] > value)
            return -1;
        if (hasLeftChild(index)) {
            if (items[leftChild(index)] == value) {
                return leftChild(index);
            }
        }
        if (hasRightChild(index)) {
            if (items[rightChild(index)] == value) {
                return rightChild(index);
            }
        }
        if (hasLeftChild(index) && value > leftChild(index)) {
            result = binarySearchIndexByValue(leftChild(index), value);
        }
        if (result == -1 && hasRightChild(index) && value > rightChild(index)) {
            result = binarySearchIndexByValue(rightChild(index), value);
        }
        return result;
    }

    public void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
}
