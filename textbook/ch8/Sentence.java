public class Sentence {
    private String sentence;
    private int numWords;

    public Sentence(String str) {
        sentence = str;
        numWords = 0;

        int index = 0; 
        while(index != -1) {
            numWords++;
            index = sentence.indexOf(" ", index + 1);
        }
    }

    private static String sanitize(String s) {
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(c < 'a' || c > 'z') {
                s = s.substring(0, index) + s.substring(index + 1);
            }
            else {
                index++;
            }
        }
        return s;
    }

    public boolean isPalindrome() {
        String temp = sentence.toLowerCase();
        temp = sanitize(temp);
        return isPalindrome(temp, 0, temp.length() - 1);
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        if(lo >= hi) {
            return true;
        }
        else {
            if(s.substring(lo, lo+1).equals(s.substring(hi, hi+1))) {
                return isPalindrome(s, lo+1, hi-1);
            }
            else {
                return false;
            }
        }
    }

    private static String removeBlanks(String s) {
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(c == ' ') {
                s = s.substring(0, index) + s.substring(index + 1);
            }
            else {
                index++;
            }
        }
        return s;
    }

    private static String removePunctuation(String s) {
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(c == ',' || c == '.'|| c == '!'|| c == '?'|| c == '/'|| c == '@'|| c == '#'|| c == '$'|| c == '%'|| c == '^'|| c== '&'|| c== '*'|| c== '('|| c== ')'|| c== ':'|| c== ';'|| c== '\'' || c== '\"') {
                s = s.substring(0, index) + s.substring(index + 1);
            }
            else {
                index++;
            }
        }
        return s;
    }

    public boolean isPalindromeInefficient() {
        String temp = sentence.toLowerCase();
        temp = removeBlanks(temp);
        temp = removePunctuation(temp);
        return isPalindrome(temp, 0, temp.length() - 1);
    }

    public String toString()
    {
        return sentence;
    }
}
