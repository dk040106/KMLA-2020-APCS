import chn.util.*;

public class SentenceMain {
    public static void main(String[] args) {
        FileInput fi = new FileInput("data/Sentence.txt");
        String s = new String(fi.readLine());
        Sentence st = new Sentence(s);
        System.out.println("Original Sentence: " + st);
        System.out.println("Is Panlindrome: " + st.isPalindromeInefficient());
    }
}
