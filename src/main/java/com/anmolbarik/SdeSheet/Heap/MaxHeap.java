package com.anmolbarik.SdeSheet.Heap;
public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Get parent index
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Get left child index
    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    // Get right child index
    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    // Swap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert element
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        // Heapify Up
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Heapify Down
    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    // Extract max
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);
        return max;
    }

    // Print heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.insert(2);

        heap.printHeap();  // 30 20 5 10 2

        //System.out.println("Extract Max: " + heap.extractMax());
        heap.printHeap();  // 20 10 5 2
    }
}