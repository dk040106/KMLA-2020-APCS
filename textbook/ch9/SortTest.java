import java.util.*;

public class SortTest
{
	public static void main(String[] args) 
	{
		Random rand = new Random();
        int size;
        // int seed = rand.nextInt();
		int[] array;

		if(args.length == 0)
			size = 10;
		else
			size = Integer.parseInt(args[0]);

		array = new int[size];
		for(int i = 0; i < array.length; i++)
			array[i] = i + 1;
		printArray(array);

		randomInitialize(array, rand);
		printArray(array);
		System.out.println("Selection Sort...");
		SelectionSort.sort(array, true);
        printArray(array);
        
		randomInitialize(array, rand);
        printArray(array);
        System.out.println("Insertion Sort...");
		InsertionSort.swapSort(array, true);
		printArray(array);

		randomInitialize(array, rand);
        printArray(array);
        System.out.println("Insertion Sort (Alternative - Shifting)...");
		InsertionSort.shiftSort(array, true);
        printArray(array);
        
        randomInitialize(array, rand);
        printArray(array);
        System.out.println("Merge Sort...");
        MergeSort.sort(array);
        printArray(array);
        
        randomInitialize(array, rand);
        printArray(array);
        System.out.println("Quick Sort...");
        QuickSort.sort(array);
        printArray(array);

        randomInitialize(array, rand);
        printArray(array);
        System.out.println("MinimumHeap Sort...");
        HeapSort.minimumHeapSort(array);
        printArray(array);

        randomInitialize(array, rand);
        printArray(array);
        System.out.println("MaximumHeap Sort...");
        HeapSort.maximumHeapSort(array);
        printArray(array);
	}

	public static void randomInitialize(int[] a, Random rand)
	{
		rand = new Random(1);
		for(int i = a.length - 1; i > 0; i--)
		{
			int swap = rand.nextInt(i);
			int temp = a[i];
			a[i] = a[swap];
			a[swap] = temp;
		}
    }
    
    public static void randomInitialize(int[] a)
	{
		Random rand = new Random(1);
		for(int i = a.length - 1; i > 0; i--)
		{
			int swap = rand.nextInt(i);
			int temp = a[i];
			a[i] = a[swap];
			a[swap] = temp;
		}
    }
    
    public static void randomInitialize(int[] a, int seed)
	{
		Random rand = new Random(seed);
		for(int i = a.length - 1; i > 0; i--)
		{
			int swap = rand.nextInt(i);
			int temp = a[i];
			a[i] = a[swap];
			a[swap] = temp;
		}
	}

	public static void printArray(int[] a)
	{
        // for(int el: a) {
        //     System.out.print(el + " ");
        // }
		for(int i = 0; i < a.length; i++)
		{
			System.out.print("[" + i + "," + a[i] + "] ");
		}
		System.out.print("\n");
	}
}
