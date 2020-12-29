public class Card {
    private int card;
    private static char[] symbols = { '\u2660', '\u2666', '\u2665', '\u2663' };
    private static String[] numbers = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };

    public Card(int cardNumber) {
        card = cardNumber;
    }

    public String toString() {
        return cardFormat();
    }

    private String cardFormat() {
        int symbol = card % 4;
        int number = card / 4;

        if (symbol < 0 || symbol > 3) {
            System.out.printf("%d is not a valid symbol number\n", symbol);
            throw new IllegalArgumentException();
        }

        if (number < 0 || number > 13) {
            System.out.printf("%d is not a valid card number\n", number);
            throw new IllegalArgumentException();
        }

        return symbols[symbol] + " " + numbers[number];
    }
}
