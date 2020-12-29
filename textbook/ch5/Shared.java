import java.util.ArrayList;

public class Shared {
    public static void main(String[] args) {
        Integer a = 4;
        System.out.println(a);
        // stringTest();
    }

    public static void stringTest() {
        String str1 = "test";
        String str2 = "test";
        String str3 = new String("test");

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));

        System.out.println(str1.concat(str2));
        System.out.println(str1);

        ArrayList numbers = new ArrayList<Integer>();

        System.out.println();
    }
}
