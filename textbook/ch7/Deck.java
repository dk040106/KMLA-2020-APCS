public class Deck {
    private int[] deck;
    public static final int NUMCARDS = 52;

    public Deck() {
        deck = new int[NUMCARDS];
        for (int i = 0; i < NUMCARDS; i++) {
            deck[i] = i;
        }
    }

    public void printDeck() {
        for (int card : deck) {
            printCard(card);
        }
        System.out.println();
    }

    public void shuffle() {
        int index;
        for (int i = NUMCARDS - 1; i > 0; i--) {
            index = (int) (Math.random() * (i + 1));
            swap(deck, i, index);
        }
    }

    private void printCard(int card) {
        System.out.printf("%d: [ %s ]\n", card, cardFormat(card % 4, card / 4));
    }

    private String cardFormat(int symbol, int number) {
        String expression = "";

        if (symbol < 0 || symbol > 3) {
            System.out.printf("%d is not a valid symbol number\n", symbol);
            return expression;
        }

        if (number < 0 || number > 13) {
            System.out.printf("%d is not a valid card number\n", number);
            return expression;
        }

        char[] symbols = { '\u2660', '\u2666', '\u2665', '\u2663' };

        String[] numbers = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };

        expression = symbols[symbol] + " " + numbers[number];

        return expression;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}