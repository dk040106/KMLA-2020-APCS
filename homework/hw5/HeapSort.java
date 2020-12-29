public class HeapSort {
    public static void maximumHeapSort(int[] array) {
        MaximumHeap.initialize(array);
        for (int i = 0; i < array.length; i++) {
            MaximumHeap.insert();
        }

        for (int i = 0; i < array.length; i++) {
            MaximumHeap.remove();
        }
    }
    
    public static void minimumHeapSort(int[] array) {
        MinimumHeap.initialize(array.length);
        
        for (int i = 0; i < array.length; i++) {
            MinimumHeap.insert(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = MinimumHeap.remove();
        }
    }
}
