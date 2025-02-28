import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class DeckOfCards {
  ArrayList<String> sorts = new ArrayList<>(Arrays.asList("H", "D", "C", "S"));
  ArrayList<String> drawnCards = new ArrayList<>();
  Random random = new Random();

  public String drawCard() {
    if (drawnCards.size() == 52) {
      return "Deck is empty";
    }

    while (true) {
      String sort = sorts.get(random.nextInt(sorts.size()));
      String card = sort + (random.nextInt(14) + 1);
      if (!drawnCards.contains(card)) {
        drawnCards.add(card);
        return card;
      }
    }
  }

  public void shuffle() {
    drawnCards.clear();
  }

  public ArrayList<String> dealHand(int n) {
    ArrayList<String> hand = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      hand.add(drawCard());
    }
    return hand;
  }
}
