public class SelectionSort {
    public static void sort(int[] array, boolean ascending) {
        final int LENGTH = array.length;
        if (ascending) {
            for (int i = 0; i < LENGTH - 1; i++) {
                int index = i;
                int value = array[i];

                for (int j = i + 1; j < LENGTH; j++) {
                    if (array[j] < value) {
                        index = j;
                        value = array[j];
                    }
                }

                array[index] = array[i];
                array[i] = value;
            }
        } else {
            for (int i = 0; i < LENGTH - 1; i++) {
                int index = i;
                int value = array[i];

                for (int j = i + 1; j < LENGTH; j++) {
                    if (array[j] > value) {
                        index = j;
                        value = array[j];
                    }
                }

                array[index] = array[i];
                array[i] = value;
            }
        }
    }
}
