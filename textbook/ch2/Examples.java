public class Examples {
    public static void main(String[] args) {
        //
        /* */
        /** */

        // p.75 Example
        System.out.println(5 + 3 < 6 - 1); // false

        /// Decision-making Controll Structures

        // p.77 Example 1
        if (true)
            if (true)
                System.out.println("haha");

        if (true && true)
            System.out.println("haha");

        // Example 2
        int n = 7;
        if (n > 0)
            if (n % 2 == 0)
                System.out.println(n);
            else
                System.out.println(n + " is not positive.");

        if (n > 0) {
            if (n % 2 == 0)
                System.out.println(n);
        } else
            System.out.println(n + " is not positive.");

        if (n <= 0) {
            System.out.println(n + " is not positive.");
        } else {
            if (n % 2 == 0)
                System.out.println(n);
        }

        // p.79 Example 1
        for (int i = 1; i < 5; i++) {
            System.out.println(i + " ");
        }

        // Exampe 2
        for (int i = 20; i >= 15; i--) {
            System.out.println(i + " ");
        }

        // Example 3
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i + " ");
        }

        // p.80 Example
        int[] arr = { 1, 2, 3 };
        for (int element : arr) {
            System.out.println(element);
        }

        // p.81 Example 1
        int i = 1, mult3 = 3;
        while (mult3 < 20) {
            System.out.print(mult3 + " ");
            i++;
            mult3 *= i;
        }
        System.out.println();

        // Example 2
        int power2 = 1;
        /*
         * while(power2 != 20) { System.out.print(power2 + " "); // overflow! power2 *=
         * 2; }
         */

        // Example 3
        System.out.println("Enter a positivee integeer from 1 to 100.");
        int num = 101;
        while (num < 1 || num > 100) {
            System.out.println("Number must be from 1 to 100.");
            System.out.println("Please reenter");
            num = 10;
        }

        // Example 4
        final int SENTINEL = -999;
        System.out.println("Enter list of positive Integers, end list with " + SENTINEL);
        int value = 10;
        while (value != SENTINEL) {
            value = SENTINEL;
        }

        // p.82 Example 1
        for (int k = 1; k <= 3; k++) {
            for (int j = 1; j <= 4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Example 2
        for (int k = 1; k <= 6; k++) {
            for (int j = 1; j <= k; j++) {
                System.out.print("+");
            }
            for (int j = 1; j <= 6 - k; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // p.83 Example 1
        // int numScores = 0;
        int numScores = 5;

        if (numScores == 0)
            throw new ArithmeticException("Cannot divide by zero.");
        else
            System.out.println(numScores);

        // Example 2
        setRadius(5);
        // setRadius(-4);
    }

    public static void setRadius(int newRadius) {
        if (newRadius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        } else {
            System.out.println("newRadius: " + newRadius);
        }
    }
}
