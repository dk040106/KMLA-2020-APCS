public class QuickSort {
    public static void sort(int[] array) {
        recursiveSort(0, array.length - 1, array);
    }

    // lo, hi, pivot
    public static void recursiveSort(int begin, int end, int[] array) {
        if (begin >= end) {
            return;
        }

        int lo = begin, pivotIndex = end, hi = end - 1;
        int pivot = array[pivotIndex];

        while (lo < hi) {
            // while(array[lo] < pivot) {
            //     lo++;
            // }

            // while(lo < hi && array[hi] >= pivot) {
            //     hi--;
            // }
            
            if (array[lo] < pivot) {
                lo++;
            }

            if (lo >= hi) {
                break;
            }

            if (array[hi] >= pivot) {
                hi--;
            }

            if (lo >= hi) {
                break;
            }

            if (array[hi] < pivot && array[lo] >= pivot) {
                swap(array, lo, hi);
                hi--;
                lo++;
            }
        }

        if (array[hi] < pivot) {
            hi++;
        }

        // swap pivot and hi
        swap(array, hi, pivotIndex);

        recursiveSort(begin, hi - 1, array);
        recursiveSort(hi + 1, end, array);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void pivotChangeRecursiveSort(int begin, int end, int[] array) {
        if (begin >= end) {
            return;
        }

        int lo = begin + 1, pivotIndex = begin, hi = end;
        int pivot = array[pivotIndex];

        while (lo < hi) {
            if (array[lo] < pivot) {
                lo++;
            }

            if (lo >= hi) {
                break;
            }

            if (array[hi] >= pivot) {
                hi--;
            }

            if (lo >= hi) {
                break;
            }

            if (array[hi] < pivot && array[lo] >= pivot) {
                swap(array, lo, hi);
                hi--;
                lo++;
            }
        }

        if (array[lo] < pivot) {
            lo--;
        }

        // swap pivot and hi
        array[pivotIndex] = array[hi];
        array[hi] = pivot;

        recursiveSort(begin, hi - 1, array);
        recursiveSort(hi + 1, end, array);
    }
}
