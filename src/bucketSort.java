import java.util.ArrayList;
import java.util.Collections;

public class bucketSort {

    public static void bucketSort(int[] array) {
        if (array.length == 0) return;

        int maxVal = array[0];
        for (int num : array) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int numBuckets = (int) Math.sqrt(array.length);
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int num : array) {
            int bucketIndex = (num * numBuckets) / (maxVal + 1);
            buckets[bucketIndex].add(num);
        }

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }


        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
    }

    public static void main(String[] args) {
        int[] array = {42, 32, 23, 52, 25, 47, 51};
        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        bucketSort(array);

        System.out.println("\nSorted array:");
        printArray(array);
    }
}
