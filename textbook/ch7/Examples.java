import java.util.*;

public class Examples {
    public static void main(String[] args) {
        // p.226
        double[] data1 = new double[25];
        double data2[] = new double[25];
        double[] data3;
        data3 = new double[25];
        data3 = new double[40];

        int[] intList1, intList2;
        int[] arr11 = new int[25], arr12 = new int[30];

        int[] coins1 = new int[4];
        coins1[0] = 1;
        coins1[1] = 5;
        coins1[2] = 10;
        coins1[3] = 25;

        int[] coins2 = { 1, 5, 10, 25 };

        /// Traversing a one-dimensional array
        System.out.println("\n\nTraversing a one-dimensional array");

        // Example 1
        System.out.println("\n=== Example 1 ===");
        int[] arr1 = { 1, 2, 3, 4, 5 };
        System.out.println(countEven(arr1)); // 2

        // Example 2
        System.out.println("\n=== Example 2 ===");
        int[] arr2 = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4, 5]
        changeEven(arr2);
        System.out.println(Arrays.toString(arr2)); // [0, 2, 0, 4, 0]

        /// Arrays as Parameters
        System.out.println("\n\nArrays as Parameters");

        // Example 1
        System.out.println("\n=== Example 1 ===");
        int[] arr3 = { 1, 3, 6, 7, 0, 4 };
        System.out.println(findMin(arr3)); // 4

        // Example 2
        System.out.println("\n=== Example 2 ===");
        int[] arr4 = { 1, 3, 6, 7, 0, 4 };
        System.out.println(Arrays.toString(arr4)); // [1, 3, 6, 7, 0, 4]
        changeArray(arr4);
        System.out.println(Arrays.toString(arr4)); // [4, 6, 9, 10, 3, 7]

        // Example 3
        System.out.println("\n=== Example 3 ===");
        int[] arr5 = { 1, 3, 6, 7, 0, 4 };
        System.out.println(Arrays.toString(arr5)); // [1, 3, 6, 7, 0, 4]
        changeElement(arr5[0]);
        System.out.println(Arrays.toString(arr5)); // [1, 3, 6, 7, 0, 4]

        // Example 4
        System.out.println("\n=== Example 4 ===");
        int[] list = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(list)); // [1, 2, 3, 4]
        swap(list, 0, 3);
        System.out.println(Arrays.toString(list)); // [4, 2, 3, 1]

        // Example 5
        System.out.println("\n=== Example 5 ===");
        int[] list1 = getIntegers();
        System.out.println(Arrays.toString(list1)); // [6, 4, 1, 6, 6] (changes in every execution)

        /// Analyzing Array Algorithms
        System.out.println("\n\nAnalyzing Array Algorithms");

        // Example 1
        System.out.println("\n=== Example 1 ===");
        int[] arr6 = { -1, 3, 4, -20, 0 };
        System.out.println(countNegs(arr6)); // 2

        // Example 2
        System.out.println("\n=== Example 2 ===");
        int[] arr7 = { 1, 3, 4, 5, 6, 7, 9, 13, 16, 19, 0, 0, 0, 0, 0 };
        System.out.println(Arrays.toString(arr7)); // [1, 3, 4, 5, 6, 7, 9, 13, 16, 19, 0, 0, 0, 0, 0]
        int n = 10;
        int num = 10;
        {
            // find insertion point
            int i = 0;
            while (i < n && num > arr7[i]) {
                i++;
            }
            for (int j = n; j > i; j--) {
                arr7[j] = arr7[j - 1];
            }
            arr7[i] = num;
            n++;
        }
        System.out.println(Arrays.toString(arr7)); // [1, 3, 4, 5, 6, 7, 9, 10, 13, 16, 19, 0, 0, 0, 0]

        /// Autoboxing and Unboxing
        // Example 1
        System.out.println("\n=== Example 1 ===");
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            list2.add(i * i);
        }
        Integer intOb = list2.get(1);
        int n1 = list2.get(2);
        Integer x = list2.set(3, 5);
        x = list2.remove(2);
        list2.add(1, 7);
        list2.add(2, 8);

        // Example 2
        System.out.println("\n=== Example 2 ===");
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        swap(list3, 1, 3);

        /// Processing a two-dimensional array
        System.out.println("\n\n==== Processing a two-dimensional array ====");

        // Example 1
        System.out.println("\n=== Example 1 ===");
        int[][] mat1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 98 } };
        int sum = 0;
        for (int r = 0; r < mat1.length; r++) {
            for (int c = 0; c < mat1[r].length; c++) {
                sum += mat1[r][c];
            }
        }
        System.out.println(sum); // 134

        sum = 0;
        for (int[] row : mat1) {
            for (int el : row) {
                sum += el;
            }
        }
        System.out.println(sum); // 134

        // Example 2
        System.out.println("\n=== Example 2 ===");
        int[][] mat2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 98 } };
        for (int c = 0; c < mat2[2].length; c++) {
            mat2[2][c] += 10;
        }

        // Example 4
        System.out.println("\n=== Example 4 ===");
        final int SIZE = 3;
        int[][] mat3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 98 } };
        System.out.println("Major diagonal");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(mat3[i][i]);
        }
        System.out.println("Minor diagonal");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(mat3[i][SIZE - i - 1]);
        }

        /// Two-dimensional Array as Parameter
        System.out.println("\n\n==== Two-dimensional Array as Parameter ====");

        /// Example 1
        System.out.println("\n=== Example 1 ===");
        int[][] mat4 = { { 1, -2, 3 }, { -4, 5, 6 }, { 7, -8, 98 } };
        int negs = countNegs(mat4);
        System.out.println(negs); // 3
    }

    public static int countEven(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void changeEven(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            arr[i] = 0;
        }
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void changeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 3;
        }
    }

    public static void changeElement(int el) {
        el += 3;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(ArrayList<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static int[] getIntegers() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    public static int countNegs(int[] arr) {
        int count = 0;
        for (int el : arr) {
            if (el < 0) {
                count++;
            }
        }
        return count;
    }

    public static int countNegs(int[][] mat) {
        int count = 0;
        for (int[] row : mat) {
            for (int el : row) {
                if (el < 0) {
                    count++;
                }    
            }
        }
        return count;
    }
}