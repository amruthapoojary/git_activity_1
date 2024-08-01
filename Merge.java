import java.util.Random;
import java.util.Scanner;

public class Merge {
    static final int MAX = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the array size: ");
        int n = scanner.nextInt();
        if (n > MAX) {
            System.out.println("Size exceeds maximum allowed.");
            return;
        }

        int[] array = new int[n];
        Random rand = new Random();

        // Fill the array with random values
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(10000);
        }

        // Print array before sorting
        System.out.println("Array before sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Measure the time taken for sorting
        long start = System.currentTimeMillis();
        mergeSort(array, 0, n - 1);
        long end = System.currentTimeMillis();

        // Print array after sorting
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        double elapsedTime = (double) (end - start);
        System.out.println("Time taken to sort array is: " + elapsedTime + " milliseconds");

        scanner.close();
    }

    // Function to merge two halves
    static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= high) {
            temp[k++] = array[j++];
        }

        for (i = low; i <= high; i++) {
            array[i] = temp[i - low];
        }
    }

    // Function to perform merge sort
    static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }
}