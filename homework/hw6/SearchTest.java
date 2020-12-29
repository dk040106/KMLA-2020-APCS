import java.util.*;

public class SearchTest {
    public static void main(String[] args) {
        Random rand = new Random();
        int size;
        // int seed = rand.nextInt();
        int[] array;

        if (args.length == 0)
            size = 10;
        else
            size = Integer.parseInt(args[0]);

        array = new int[size];
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
        // printArray(array);

        int key = rand.nextInt(size);
        System.out.println("Key: " + key);

        randomInitialize(array, rand);
        // printArray(array);

        System.out.println(SequentialSearch.search(array, key));
        System.out.println("Found by " + SequentialSearch.count + " operations.");

        // use fastest sort
        QuickSort.sort(array);
        // printArray(array);

        System.out.println(SequentialSearch.search(array, key));
        System.out.println("Found by " + SequentialSearch.count + " operations.");

        System.out.println(BinarySearch.iterativeSearch(array, key));
        System.out.println("Found by " + BinarySearch.count + " operations.");

        System.out.println(BinarySearch.recursiveSearch(array, key));
        System.out.println("Found by " + BinarySearch.count + " operations.");
    }

    public static void randomInitialize(int[] a, Random rand) {
        rand = new Random(1);
        for (int i = a.length - 1; i > 0; i--) {
            int swap = rand.nextInt(i);
            int temp = a[i];
            a[i] = a[swap];
            a[swap] = temp;
        }
    }

    public static void randomInitialize(int[] a) {
        Random rand = new Random(1);
        for (int i = a.length - 1; i > 0; i--) {
            int swap = rand.nextInt(i);
            int temp = a[i];
            a[i] = a[swap];
            a[swap] = temp;
        }
    }

    public static void randomInitialize(int[] a, int seed) {
        Random rand = new Random(seed);
        for (int i = a.length - 1; i > 0; i--) {
            int swap = rand.nextInt(i);
            int temp = a[i];
            a[i] = a[swap];
            a[swap] = temp;
        }
    }

    public static void printArray(int[] a) {
        // for(int el: a) {
        // System.out.print(el + " ");
        // }
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + i + "," + a[i] + "] ");
        }
        System.out.print("\n");
    }
}
