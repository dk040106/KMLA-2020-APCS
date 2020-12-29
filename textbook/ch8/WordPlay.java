import java.util.Scanner;

public class WordPlay {
    static Scanner sc = new Scanner(System.in);
    
    public static void stackWords() {
        String word = sc.next();
        if(word.equals(".")) {
            System.out.println();
        } else {
            stackWords();
        }
        System.out.println(word);
    }

    public static void main(String[] args) {
        stackWords();
    }
}
