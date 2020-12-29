public class MinimumHeap {
    private static int[] data;

    public static void insert(int element) {
        data[0]++;
        data[data[0]] = element;
        upheap(data[0]);
    }

    public static int remove() {
        int result = data[1];
        data[1] = data[data[0]];
        data[0]--;
        downheap(1);
        return result;
    }

    private static void downheap(int node) {
        int leftChild = node * 2;
        int rightChild = node * 2 + 1;

        if (leftChild > data[0]) {
            return;
        }

        int childToSwap;
        if (rightChild > data[0] || data[leftChild] < data[rightChild]) {
            childToSwap = leftChild;
        } else {
            childToSwap = rightChild;
        }

        if (data[childToSwap] < data[node]) {
            swap(childToSwap, node);
            downheap(childToSwap);
        }
    }

    private static void upheap(int node) {
        if (node == 1) {
            return;
        }

        int parent = node / 2;
        if (data[node] < data[parent]) {
            swap(node, parent);
        }

        upheap(parent);
    }

    private static void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void initialize(int length) {
        data = new int[length + 1];
        data[0] = 0;
    }
}
