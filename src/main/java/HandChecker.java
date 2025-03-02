
import java.util.ArrayList;

public class HandChecker {

    public int sum(ArrayList<String> hand) {
        int sum = 0;
        for (String card : hand) {
            String value = card.substring(1);
            sum += Integer.parseInt(value);
        }
        return sum;
    }
    
    public boolean isFlush(ArrayList<String> hand) {
        String suit = hand.get(0).substring(0, 1);
        for (String card : hand) {
            if (!card.substring(0, 1).equals(suit)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkForQueenOfSpades(ArrayList<String> hand) {
        for (String card : hand) {
            if (card.equals("S12")) {
                return true;
            }
        }
        return false;
    }

    public int amountOfHearts(ArrayList<String> hand) {
        int amount = 0;
        for (String card : hand) {
            if (card.substring(0, 1).equals("H")) {
                amount++;
            }
        }
        return amount;
    }




}
