package card;
import java.util.Random;

public class Deck {

   int YourFace;
   public int[] cards;
   int numCards;

   public Deck(int length) {
      cards = new int[length];
      numCards = length;
   }

   public void addCard(int c) {
      cards[numCards] = c;
      numCards++;
   }

   public int drawCard() {
      int c = cards[numCards-1];
      numCards --;
      return c;
   }

   public void shuffle() {
      for(int i=0; i<numCards; i++){
         //save away the current card
         int temp = cards[i];
         
         //generate a random index
         Random generator = new Random();
         int randomIndex = generator.nextInt(numCards);
         
         //swap the current card and the randomly selected one
         cards[i] = cards[randomIndex];
         cards[randomIndex] = temp;
      }
   }
}

