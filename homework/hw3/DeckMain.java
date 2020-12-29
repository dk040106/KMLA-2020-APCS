public class DeckMain {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.shuffle();
        d.printDeck();

        Decks ds = new Decks();
        ds.shuffleAll();
        ds.printAll();
    }
}
