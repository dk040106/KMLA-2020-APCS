public class MaximumHeap {
    private static int[] data;
    private static int length;

    public static void insert() {
        length++;
        upheap(length);
    }

    public static void remove() {
        swap(0, length);
        length--;
        downheap(0);
    }

    private static void downheap(int node) {
        int leftChild = (node + 1) * 2 - 1;
        int rightChild = (node + 1) * 2;

        if (leftChild > length) {
            return;
        }

        int childToSwap;
        if (rightChild > length || data[leftChild] > data[rightChild]) {
            childToSwap = leftChild;
        } else {
            childToSwap = rightChild;
        }

        if (data[childToSwap] > data[node]) {
            swap(childToSwap, node);
            downheap(childToSwap);
        }
    }

    private static void upheap(int node) {
        if (node == 0) {
            return;
        }
        
        int parent = (node + 1) / 2 - 1;
        
        if (data[node] > data[parent]) {
            swap(node, parent);
        }
        upheap(parent);
    }

    private static void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void initialize(int[] array) {
        data = array;
        length = -1;
    }
}
