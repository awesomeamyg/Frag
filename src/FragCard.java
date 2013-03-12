import java.awt.Point;

public class FragCard extends Card {

   int rawNumber;
   String name;
   Map map;

   public FragCard(int n, Map map) {
      rawNumber = n;
      defineCardInfo();
      this.map = map;
   }

   public String getName() { return name; }

   public void playCard() {
      switch(this.rawNumber) {
         case 33: //"Automatic Miss"
            //map.setAttackToMiss();
            System.out.println("Playing case 33: Automatic Miss Not yet implemented");
            break;
         case 34: //"Lag"
            System.out.println("Playing case 34: Lag Not yet implemented");
            break;
         case 35: //"No Carrier"
            //map.kill(null);
            System.out.println("Playing case 35: No Carrier Not yet implemented");
            break;
         case 36: //"System Upgrade: Extra RAM"
            map.player.setMaxHandSize(6);
            break;
         case 37: //"Zigged When You Should Have Zagged"
            System.out.println("Playing case 37: Zigged ... Not yet implemented");
            break;
         case 38: //"Freeze"
            //map.player.Freeze();
            System.out.println("Playing case 38: Freeze Not yet implemented");
            break;
         case 39: //"Fumble"
            System.out.println("Playing case 39: Fumble Not yet implemented");
            break;
         case 40: //"Game Hack: Assume Control"
            System.out.println("Playing case 40: Game Hack Not yet implemented");
            break;
         case 41: //"Game Hack: Bonus Damage"
            //map.setDamageMultiplier(2);
            System.out.println("Playing case 41: Game Hack: Bonus Damage Not yet implemented");
            break;
         case 42: //"Game Hack: Cheat Codes"
            System.out.println("Playing case 42: Game Hack: Cheat Codes Not yet implemented");
            break;
         case 43: //"Game Hack: Cheater Cheater"
            //map.player.setHealth(map.player.getHealth()*2);
            //map.player.setAccuracy(map.player.getAccuracy()*2);
            //map.player.setSpeed(map.player.getSpeed()*2);
            System.out.println("Playing case 43: Game Hack: Cheater Cheater Not yet implemented");
            break;
         case 44: //"Game Hack: Insubstantial"
            //map.player.setSubstantial(false);
            System.out.println("Playing case 44: Game Hack: Insubstantial Not yet implemented");
            break;
         case 45: //"Game Hack: Keep the Stuff"
            //map.player.setInventoryLossOnDeath(false);
            System.out.println("Playing case 45: Game Hack: Keep the Stuff Not yet implemented");
            break;
         case 46: //"Game Hack: Magic Bullet"
            System.out.println("Playing case 46: Game Hack: Magic Bullet Not yet implemented");
            break;
         case 47: //"Game Hack: Teleportation"
            System.out.println("Take user input Not yet implemented");
            map.player.setLocation(new Point(0, 0));
            break;
         case 48: //"Game Hack: Theft"
            System.out.println("Generate random number Not yet implemented");
            int n = 0;
            //map.player.giveCard(new Card);
            System.out.println("Playing case 48: Game Hack: Theft Not yet implemented");
            break;
         case 49: //"Game Hack: Timing Troubles";
            //map.setTurn(map.player);
            System.out.println("Playing case 49: Game Hack: Timing Troubles Not yet implemented");
            break;
         default: //"Error, Unrecognized Frag Card";
            System.out.println("Error: Unrecognized Frag Card");
      }
   }

   public void reverseEffects() {
      switch(this.rawNumber) {
         case 33: //"Automatic Miss"
            System.out.println("Removing case 33: Automatic Miss Not yet implemented");
            break;
         case 34: //"Lag"
            System.out.println("Removing case 34: Lag Not yet implemented");
            break;
         case 35: //"No Carrier"
            System.out.println("Removing case 35: No Carrier Not yet implemented");
            break;
         case 36: //"System Upgrade: Extra RAM"
            map.player.setMaxHandSize(5);
            break;
         case 37: //"Zigged When You Should Have Zagged"
            System.out.println("Removing case 37: Zigged ... Not yet implemented");
            break;
         case 38: //"Freeze"
            System.out.println("Removing case 38: Freeze Not yet implemented");
            break;
         case 39: //"Fumble"
            System.out.println("Removing case 39: Fumble Not yet implemented");
            break;
         case 40: //"Game Hack: Assume Control"
            System.out.println("Removing case 40: Game Hack Not yet implemented");
            break;
         case 41: //"Game Hack: Bonus Damage"
            System.out.println("Removing case 41: Game Hack: Bonus Damage Not yet implemented");
            break;
         case 42: //"Game Hack: Cheat Codes"
            System.out.println("Removing case 42: Game Hack: Cheat Codes Not yet implemented");
            break;
         case 43: //"Game Hack: Cheater Cheater"
            System.out.println("Removing case 43: Game Hack: Cheater Cheater Not yet implemented");
            break;
         case 44: //"Game Hack: Insubstantial"
            System.out.println("Removing case 44: Game Hack: Insubstantial Not yet implemented");
            break;
         case 45: //"Game Hack: Keep the Stuff"
            System.out.println("Removing case 45: Game Hack: Keep the Stuff Not yet implemented");
            break;
         case 46: //"Game Hack: Magic Bullet"
            System.out.println("Removing case 46: Game Hack: Magic Bullet Not yet implemented");
            break;
         case 47: //"Game Hack: Teleportation";
            System.out.println("Removing case 47: Game Hack: Teleportation Not yet implemented");
            break;
         case 48: //"Game Hack: Theft"
            System.out.println("Removing case 48: Game Hack: Theft Not yet implemented");
            break;
         case 49: //"Game Hack: Timing Troubles";
            System.out.println("Removing case 49: Game Hack: Timing Troubles Not yet implemented");
            break;
         default: //"Error, Unrecognized Frag Card";
            System.out.println("Error: Unrecognized Frag Card");
      }
   }

   protected void defineCardInfo() {
      switch(this.rawNumber) {
         case 33: name = "Automatic Miss"; break;
         case 34: name = "Lag"; break;
         case 35: name = "No Carrier"; break;
         case 36: name = "System Upgrade: Extra RAM"; break;
         case 37: name = "Zigged When You Should Have Zagged"; break;
         case 38: name = "Freeze"; break;
         case 39: name = "Fumble"; break;
         case 40: name = "Game Hack: Assume Control"; break;
         case 41: name = "Game Hack: Bonus Damage"; break;
         case 42: name = "Game Hack: Cheat Codes"; break;
         case 43: name = "Game Hack: Cheater Cheater"; break;
         case 44: name = "Game Hack: Insubstantial"; break;
         case 45: name = "Game Hack: Keep the Stuff"; break;
         case 46: name = "Game Hack: Magic Bullet"; break;
         case 47: name = "Game Hack: Teleportation"; break;
         case 48: name = "Game Hack: Theft"; break;
         case 49: name = "Game Hack: Timing Troubles"; break;
         default:
            name = "Error, Unrecognized Frag Card";
            System.out.println("Error, Unrecognized Frag Card");
      }
   }
}

