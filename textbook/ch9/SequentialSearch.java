public class SequentialSearch {
    public static int count;
    public static int search(int[] array, int key) {
        count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
