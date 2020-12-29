import chn.util.*;

public class Examples {

    public static void main(String[] args) {
        FileInput fi = new FileInput("data/imageInput.txt");
        int rows = Integer.parseInt(fi.readToken());
        int cols = Integer.parseInt(fi.readToken());
        Image image = new Image(_image);
        image.display();

        int[][] hist = image.eraseBlobWithHistory(6, 1);

        System.out.println();
        for(int[] row: hist) {
            for(int el: row) {
                System.out.printf("%3d", el);
            }
            System.out.println();
        }
    }

    public static String revDigits(int num, int unit) {
        int mul = (int) Math.pow(10, unit);
        if (num / mul == 0) {
            return String.format("%d", num);
        }
        return num % mul + revDigits(num / mul, unit);
    }

    public static void drawLine(int n) {
        if (n == 0) {
            System.out.println("EENDD");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print("*");
            }
            System.out.println();
            drawLine(n - 1);
        }
    }

    public static void catastrophe(int n) {
        System.out.println(n);
        catastrophe(n);
    }


    public static boolean search(String[] a, String key, int index) {
        if(index == a.length) 
        {
            return false;
        }
        else if(a[index] == key) {
            return true;
        }
        else {
            return search(a, key, index + 1);
        }
    }
}
