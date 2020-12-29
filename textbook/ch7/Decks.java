public class Decks {
    private Deck[] decks;
    public static final int NUMDECKS = 5;

    public Decks() {
        decks = new Deck[NUMDECKS];
        for (int i = 0; i < NUMDECKS; i++) {
            decks[i] = new Deck();
        }
    }

    public void shuffleAll() {
        for (Deck deck : decks) {
            deck.shuffle();
        }
    }

    public void printAll() {
        System.out.printf("Printing %d decks...\n", NUMDECKS);
        for (Deck deck : decks) {
            deck.printDeck();
        }
    }
}
