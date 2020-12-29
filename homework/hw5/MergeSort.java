public class MergeSort {
    public static void sort(int[] array) {
        int[] res = recursiveSort(0, array.length - 1, array);
        for (int i = 0; i < array.length; i++) {
            array[i] = res[i];
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int indexC = 0, indexA = 0, indexB = 0;

        while (indexA < a.length && indexB < b.length) {
            int num;
            if (a[indexA] < b[indexB]) {
                num = a[indexA];
                indexA++;
            } else {
                num = b[indexB];
                indexB++;
            }
            c[indexC] = num;
            indexC++;
        }

        if (indexA < a.length) {
            while (indexA < a.length) {
                c[indexC] = a[indexA];
                indexA++;
                indexC++;
            }
        } else {
            while (indexB < b.length) {
                c[indexC] = b[indexB];
                indexB++;
                indexC++;
            }
        }
        return c;
    }

    private static int[] mergeWithFlip(int[] a, int[] b) {
        final int LENGTH = a.length + b.length;
        int[] c = new int[LENGTH];
        int[] ab = new int[LENGTH];

        int index = 0;
        for (int el : a) {
            ab[index] = el;
            index++;
        }

        index = LENGTH - 1;
        for (int el : b) {
            ab[index] = el;
            index--;
        }

        int lo = 0, hi = LENGTH - 1;
        index = 0;
        while (lo <= hi) {
            if (ab[lo] < ab[hi]) {
                c[index] = ab[lo];
                lo++;
            } else {
                c[index] = ab[hi];
                hi--;
            }
            index++;
        }

        return c;
    }

    private static int[] recursiveSort(int lo, int hi, int[] array) {
        if (lo >= hi) {
            int[] res = { array[lo] };
            return res;
        } else {
            int mid = (lo + hi) / 2;
            return merge(recursiveSort(lo, mid, array), recursiveSort(mid + 1, hi, array));
            // return mergeWithFlip(recursiveSort(lo, mid, array), recursiveSort(mid + 1, hi, array));
        }
    }
}
