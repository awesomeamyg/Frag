package card;
public abstract class Card {
   public abstract void playCard();
   public abstract void reverseEffects();
   protected abstract void defineCardInfo();
   public abstract String getName();
}
