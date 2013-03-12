package card;
import client.Player;

public class GadgetCard extends Card {

   int rawNumber;
   String name;
   Player player;

   public GadgetCard(int n, Player player) {
      this.rawNumber = n;
      defineCardInfo();
      this.player = player;
   }

   public String getName() { return name; }

   public void playCard() {
      switch(this.rawNumber) {
         case 1: //"Medpack"
            if (player.getHealth() < player.getInitialHealth()) {
               player.incrementHealth();
               System.out.println("Health incremented by one");
            }
            else
               System.out.println("Already at full health. Card wasted.");
            break;
         case 2: //"Extra Ammo"
            System.out.println("Playing case 2: Extra Ammo Not yet implemented");
            break;
         case 3: //"Adrenaline Surge"
            System.out.println("Playing case 3: Adrenaline Surge Not yet implemented");
            break;
         case 4: //"Enhanced Medpack"
            if (player.getHealth() < player.getInitialHealth()) {
               if (player.getHealth() < player.getInitialHealth()-1) {
                  player.incrementHealth(2);
                  System.out.println("Health incremented by two");
               }
               else {
                  player.incrementHealth();
                  System.out.println("Health incremented by one. Card half wasted.");
               }
            }
            else
               System.out.println("Already at full health. Card wasted.");
            break;
         case 5: //"Light Armor"
            if (player.getArmor() != null) {
               System.out.println("Already wearing "
                                 + player.getArmor().getName());
               System.out.println("Switching armor Not yet implemented");
            }
            else
                System.out.println("Equipping Armor Not yet implemented");
            break;
         case 6: //"Heavy Amor"
            if (player.getArmor() != null) {
               System.out.println("Already wearing "
                                 + player.getArmor().getName());
               System.out.println("Switching armor Not yet implemented");
            }
            else
                System.out.println("Equipping Armor Not yet implemented");
            break;
         case 7: //"Speed Boost"
            System.out.println("Playing case 7: Speed Boost Not yet implemented");
            break;
         case 8: //"Targeting System"
            System.out.println("Playing case 8: Targeting System Not yet implemented");
            break;
         case 9: //"Enhanced Damage"
            System.out.println("Playing case 9: Enhanced Damage Not yet implemented");
            break;
         case 10: //"Over/Under"
            System.out.println("Playing case 10: Over/Under Not yet implemented");
            break;
         case 11: //"Personal Teleporter"
            System.out.println("Playing case 11: Personal Teleporter Not yet implemented");
            break;
         case 12: //"Trick Fire"
            System.out.println("Playing case 12: Trick Fire Not yet implemented");
            break;
         case 13: //"Energy Reflector"
            System.out.println("Playing case 13: Energy Reflector Not yet implemented");
            break;
         case 14: //"Energy Shield"
            if (player.getArmor() != null) {
               System.out.println("Already wearing "
                                 + player.getArmor().getName());
               System.out.println("Switching armor Not yet implemented");
            }
            else
                System.out.println("Equipping Armor Not yet implemented");
            break;
         case 15: //"Exoskeleton"
            if (player.getArmor() != null) {
               System.out.println("Already wearing "
                                 + player.getArmor().getName());
               System.out.println("Switching armor Not yet implemented");
            }
            else
                System.out.println("Equipping Armor Not yet implemented");
            break;
         case 16: //"Fireproof Coating"
            if (player.getArmor() == null) {
               System.out.println("Not wearing Armor. Card wasted.");
            }
            else
                System.out.println("Equipping Armor Not yet implemented");
            break;
         case 17: //"Phase Shift"
            System.out.println("Playing case 17: Phase Shift Not yet implemented");
            break;
         case 18: //"Power Leap"
            System.out.println("Playing case 18: Power Leap Not yet implemented");
            break;
         case 19: //"Rapid Fire"
            System.out.println("Playing case 19: Rapid Fire Not yet implemented");
            break;
         default: //"Error, Unrecognized Gadget Card";
            System.out.println("Error: Unrecognized Gadget Card");
      }
   }

   public void reverseEffects() {
      switch(this.rawNumber) {
         case 1: //"Medpack"
            System.out.println("Removing case 1: Medpack Not yet implemented");
            break;
         case 2: //"Extra Ammo"
            System.out.println("Removing case 2: Extra Ammo Not yet implemented");
            break;
         case 3: //"Adrenaline Surge"
            System.out.println("Removing case 3: Adrenaline Surge Not yet implemented");
            break;
         case 4: //"Enhanced Medpack"
            System.out.println("Removing case 4: Enhanced Medpack Not yet implemented");
            break;
         case 5: //"Light Armor"
            System.out.println("Removing case 5: Light Armor Not yet implemented");
            break;
         case 6: //"Heavy Amor"
            System.out.println("Removing case 6: Heavy Amor Not yet implemented");
            break;
         case 7: //"Speed Boost"
            System.out.println("Removing case 7: Speed Boost Not yet implemented");
            break;
         case 8: //"Targeting System"
            System.out.println("Removing case 8: Targeting System Not yet implemented");
            break;
         case 9: //"Enhanced Damage"
            System.out.println("Removing case 9: Enhanced Damage Not yet implemented");
            break;
         case 10: //"Over/Under"
            System.out.println("Removing case 10: Over/Under Not yet implemented");
            break;
         case 11: //"Personal Teleporter"
            System.out.println("Removing case 11: Personal Teleporter Not yet implemented");
            break;
         case 12: //"Trick Fire"
            System.out.println("Removing case 12: Trick Fire Not yet implemented");
            break;
         case 13: //"Energy Reflector"
            System.out.println("Removing case 13: Energy Reflector Not yet implemented");
            break;
         case 14: //"Energy Shield"
            System.out.println("Removing case 14: Energy Shield Not yet implemented");
            break;
         case 15: //"Exoskeleton"
            System.out.println("Removing case 15: Exoskeleton Not yet implemented");
            break;
         case 16: //"Fireproof Coating"
            System.out.println("Removing case 16: Fireproof Coating Not yet implemented");
            break;
         case 17: //"Phase Shift"
            System.out.println("Removing case 17: Phase Shift Not yet implemented");
            break;
         case 18: //"Power Leap"
            System.out.println("Removing case 18: Power Leap Not yet implemented");
            break;
         case 19: //"Rapid Fire"
            System.out.println("Removing case 19: Rapid Fire Not yet implemented");
            break;
         default: //"Error, Unrecognized Gadget Card";
            System.out.println("Error: Unrecognized Gadget Card");
      }
   }

    protected void defineCardInfo() {
      switch(this.rawNumber) {
         case 1: name = "Medpack"; break;
         case 2: name = "Extra Ammo";break;
         case 3: name = "Adrenaline Surge"; break;
         case 4: name = "Enhanced Medpack"; break;
         case 5: name = "Light Armor"; break;
         case 6: name = "Heavy Amor"; break;
         case 7: name = "Speed Boost"; break;
         case 8: name = "Targeting System"; break;
         case 9: name = "Enhanced Damage"; break;
         case 10: name = "Over/Under"; break;
         case 11: name = "Personal Teleporter"; break;
         case 12: name = "Trick Fire"; break;
         case 13: name = "Energy Reflector"; break;
         case 14: name = "Energy Shield"; break;
         case 15: name = "Exoskeleton"; break;
         case 16: name = "Fireproof Coating"; break;
         case 17: name = "Phase Shift"; break;
         case 18: name = "Power Leap"; break;
         case 19: name = "Rapid Fire"; break;
         default:
            name = "Error, Unrecognized Gadget Card";
            System.out.println("Error, Unrecognized Gadget Card");
      }
    }
}
