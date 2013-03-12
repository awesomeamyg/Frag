public class WeaponCard extends Card{

   int rawNumber;
   String name;
   int maxAmmo;
   int ammoLeft;
   int damage;

   public WeaponCard(int n) {
      this.rawNumber = n;
   }

   public String getName() { return name; }

   public void playCard() {
      switch(this.rawNumber) {
         case 20: //"Beam Pistol"
            System.out.println("Playing case 20: Beam Pistol Not yet implemented");
            break;
         case 21: //"Needler"
            System.out.println("Playing case 21: Needler Not yet implemented");
            break;
         case 22: //"Machine Gun"
            System.out.println("Playing case 22: Machine Gun Not yet implemented");
            break;
         case 23: //"Shotgun"
            System.out.println("Playing case 23: Shotgun Not yet implemented");
            break;
         case 24: //"Chainsaw"
            System.out.println("Playing case 24: Chainsaw Not yet implemented");
            break;
         case 25: //"Flamethrower"
            System.out.println("Playing case 25: Flamethrower Not yet implemented");
            break;
         case 26: //"Assault Cannon"
            System.out.println("Playing case 26: Assault Cannon Not yet implemented");
            break;
         case 27: //"Electromagnetic Cannon"
            System.out.println("Playing case 27: Electromagnetic Cannon Not yet implemented");
            break;
         case 28: //"Heavy Assault Cannon"
            System.out.println("Playing case 28: Heavy Assault Cannon Not yet implemented");
            break;
         case 29: //"Lightning Blaster"
            System.out.println("Playing case 29: Lightning Blaster Not yet implemented");
            break;
         case 30: //"Missile Launcher"
            System.out.println("Playing case 30: Missile Launcher Not yet implemented");
            break;
         case 31: //"Portable Nuke"
            System.out.println("Playing case 31: Portable Nuke Not yet implemented");
            break;
         case 32: //"Pulse Rifle"
            System.out.println("Playing case 32: Pulse Rifle Not yet implemented");
            break;
         default: //"Error, Unrecognized Weapon Card";
            System.out.println("Error: Unrecognized Weapon Card");
      }
   }

   public void reverseEffects() {
      switch(this.rawNumber) {
         case 20: //"Beam Pistol"
            System.out.println("Removing case 20: Beam Pistol Not yet implemented");
            break;
         case 21: //"Needler"
            System.out.println("Removing case 21: Needler Not yet implemented");
            break;
         case 22: //"Machine Gun"
            System.out.println("Removing case 22: Machine Gun Not yet implemented");
            break;
         case 23: //"Shotgun"
            System.out.println("Removing case 23: Shotgun Not yet implemented");
            break;
         case 24: //"Chainsaw"
            System.out.println("Removing case 24: Chainsaw Not yet implemented");
            break;
         case 25: //"Flamethrower"
            System.out.println("Removing case 25: Flamethrower Not yet implemented");
            break;
         case 26: //"Assault Cannon"
            System.out.println("Removing case 26: Assault Cannon Not yet implemented");
            break;
         case 27: //"Electromagnetic Cannon"
            System.out.println("Removing case 27: Electromagnetic Cannon Not yet implemented");
            break;
         case 28: //"Heavy Assault Cannon"
            System.out.println("Removing case 28: Heavy Assault Cannon Not yet implemented");
            break;
         case 29: //"Lightning Blaster"
            System.out.println("Removing case 29: Lightning Blaster Not yet implemented");
            break;
         case 30: //"Missile Launcher"
            System.out.println("Removing case 30: Missile Launcher Not yet implemented");
            break;
         case 31: //"Portable Nuke"
            System.out.println("Removing case 31: Portable Nuke Not yet implemented");
            break;
         case 32: //"Pulse Rifle"
            System.out.println("Removing case 32: Pulse Rifle Not yet implemented");
            break;
         default: //"Error, Unrecognized Weapon Card";
            System.out.println("Error: Unrecognized Weapon Card");
      }
   }

//      Add Damage here!
//      damage = X;
   protected void defineCardInfo() {
      switch(this.rawNumber) {
         case 20:
            name = "Beam Pistol";
            maxAmmo = ammoLeft = 5;
            break;
         case 21:
            name = "Needler";
            maxAmmo = ammoLeft = 6;
            break;
         case 22:
            name = "Machine Gun";
            maxAmmo = ammoLeft = 6;
            break;
         case 23:
            name = "Shotgun";
            maxAmmo = ammoLeft = 6;
            break;
         case 24:
            name = "Chainsaw";
            maxAmmo = ammoLeft = 100;
            break;
         case 25:
            name = "Flamethrower";
            maxAmmo = ammoLeft = 6;
            break;
         case 26:
            name = "Assault Cannon";
            maxAmmo = ammoLeft = 4;
            break;
         case 27:
            name = "Electromagnetic Cannon";
            maxAmmo = ammoLeft = 3;
            break;
         case 28:
            name = "Heavy Assault Cannon";
            maxAmmo = ammoLeft = 2;
            break;
         case 29:
            name = "Lightning Blaster";
            maxAmmo = ammoLeft = 3;
            break;
         case 30:
            name = "Missile Launcher";
            maxAmmo = ammoLeft = 6;
            break;
         case 31:
            name = "Portable Nuke";
            maxAmmo = ammoLeft = 1;
            break;
         case 32:
            name = "Pulse Rifle";
            maxAmmo = ammoLeft = 6;
            break;
         default:
            name = "Error, Unrecognized Weapon Card";
            System.out.println("Error, Unrecognized Weapon Card");
      }
   }
}



