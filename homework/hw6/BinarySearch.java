package homework.hw6;

public class BinarySearch {
    public static int count;

    public static int iterativeSearch(int[] array, int key) {
        count = 0;
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            count++;
            int mid = (lo + hi) / 2;

            if (array[mid] > key) {
                hi = mid - 1;
            } else if (array[mid] < key) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int recursiveSearch(int[] array, int key) {
        count = 0;
        return recursiveSearch(array, key, 0, array.length - 1);
    }

    private static int recursiveSearch(int[] array, int key, int lo, int hi) {
        count++;
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        if (array[mid] > key) {
            return recursiveSearch(array, key, lo, mid - 1);
        } else if (array[mid] < key) {
            return recursiveSearch(array, key, mid + 1, hi);
        } else {
            return mid;
        }
    }
}