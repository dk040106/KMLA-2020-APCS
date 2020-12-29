public class InsertionSort {
    public static void swapSort(int[] array, boolean ascending) {
        final int LENGTH = array.length;
        if (ascending) {
            for (int i = 1; i < LENGTH; i++) {
                for (int j = i; j >= 1; j--) {
                    if (array[j] > array[j - 1]) {
                        break;
                    } else {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    }
                }
            }
        } else {
            for (int i = 1; i < LENGTH; i++) {
                for (int j = i; j >= 1; j--) {
                    if (array[j] < array[j - 1]) {
                        break;
                    } else {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    }
                }
            }
        }
    }

    public static void shiftSort(int[] array, boolean ascending) {
        final int LENGTH = array.length;
        if (ascending) {
            for (int i = 1; i < LENGTH; i++) {
                int value = array[i];
                int index = i;

                while (index > 0) {
                    if (value > array[index - 1]) {
                        break;
                    }
                    index--;
                }

                for (int j = i; j >= index + 1; j--) {
                    array[j] = array[j - 1];
                }
                array[index] = value;
            }
        } else {
            for (int i = 1; i < LENGTH; i++) {
                int value = array[i];
                int index = i;

                while (index > 0) {
                    if (value < array[index - 1]) {
                        break;
                    }
                    index--;
                }

                for (int j = i; j >= index + 1; j--) {
                    array[j] = array[j - 1];
                }
                array[index] = value;
            }
        }
    }
}
