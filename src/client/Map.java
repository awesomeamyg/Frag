package client;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import card.FragCard;


@SuppressWarnings("serial")
public class Map extends JFrame implements KeyListener{
   //constants
   final int MAXOTHERPLAYERS = 2;
   int CURRENTOTHERPLAYERS = 0;

   // Networking variables
   ClientConnection server;
   int port = 9876;
   String ip;

   Player[] otherPlayers;

   Point[] GadgetLocations;
   Point[] WeaponLocations;
   Point[] TeleporterLocations;
   Point[][] WallLocations;

   MapPanel panel;
   public Player player;

   public static void main (String[] args){
      new Map();
   }

   public Map(){
      GadgetLocations = new Point[21];
      fillGadgetLocations();
      WeaponLocations = new Point[10];
      fillWeaponLocations();
      TeleporterLocations = new Point[2];
      fillTeleporterLocations();
      WallLocations = new Point[69][2];
      fillWallLocations();

      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(500, 500);
      this.setVisible(true);

      panel = new MapPanel(this);
      this.add(panel);

      this.addKeyListener(this);

      this.otherPlayers = new Player[MAXOTHERPLAYERS];
   }

   private void fillGadgetLocations(){
      GadgetLocations[0] = new Point(0, 0);
      GadgetLocations[1] = new Point(9, 0);
      GadgetLocations[2] = new Point(2, 2);
      GadgetLocations[3] = new Point(8, 3);
      GadgetLocations[4] = new Point(10, 5);
      GadgetLocations[5] = new Point(1, 8);
      GadgetLocations[6] = new Point(11, 9);
      GadgetLocations[7] = new Point(8, 10);
      GadgetLocations[8] = new Point(2,11);
      GadgetLocations[9] = new Point(12, 12);
      GadgetLocations[10] = new Point(7, 13);
      GadgetLocations[11] = new Point(14, 13);
      GadgetLocations[12] = new Point(11, 15);
      GadgetLocations[13] = new Point(15, 20);
      GadgetLocations[14] = new Point(7, 21);
      GadgetLocations[15] = new Point(10, 22);
      GadgetLocations[16] = new Point(0, 23);
      GadgetLocations[17] = new Point(0, 24);
      GadgetLocations[18] = new Point(15, 24);
      GadgetLocations[19] = new Point(2, 25);
      GadgetLocations[20] = new Point(15, 25);
   }

   private void fillWeaponLocations(){
      WeaponLocations[0] = new Point(7, 0);
      WeaponLocations[1] = new Point(2, 4);
      WeaponLocations[2] = new Point(14, 8);
      WeaponLocations[3] = new Point(1, 14);
      WeaponLocations[4] = new Point(8, 15);
      WeaponLocations[5] = new Point(2, 17);
      WeaponLocations[6] = new Point(10, 17);
      WeaponLocations[7] = new Point(14, 19);
      WeaponLocations[8] = new Point(0, 25);
      WeaponLocations[9] = new Point(14, 25);
   }

   private void fillTeleporterLocations(){
      TeleporterLocations[0] = new Point(9, 25);
      TeleporterLocations[1] = new Point(7, 1);
   }

   private void fillWallLocations(){
      //borders of the board
      WallLocations[0][0] = new Point(0, 0);
      WallLocations[0][1] = new Point(16, 0);
      WallLocations[1][0] = new Point(0, 0);
      WallLocations[1][1] = new Point(0, 26);
      WallLocations[2][0] = new Point(16, 0);
      WallLocations[2][1] = new Point(16, 26);
      WallLocations[3][0] = new Point(0, 26);
      WallLocations[3][1] = new Point(16, 26);

      //upper line
      WallLocations[4][0] = new Point(3, 1);
      WallLocations[4][1] = new Point(13, 1);

      //top left room
      WallLocations[5][0] = new Point(1, 2);
      WallLocations[5][1] = new Point(1, 6);
      WallLocations[6][0] = new Point(1, 2);
      WallLocations[6][1] = new Point(3, 2);
      WallLocations[7][0] = new Point(1, 6);
      WallLocations[7][1] = new Point(2, 6);
      WallLocations[8][0] = new Point(2, 5);
      WallLocations[8][1] = new Point(2, 6);
      WallLocations[9][0] = new Point(2, 5);
      WallLocations[9][1] = new Point(4, 5);
      WallLocations[10][0] = new Point(4, 5);
      WallLocations[10][1] = new Point(4, 6);
      WallLocations[11][0] = new Point(5, 2);
      WallLocations[11][1] = new Point(5, 6);
      WallLocations[12][0] = new Point(4, 2);
      WallLocations[12][1] = new Point(5, 2);

      //top right room
      WallLocations[13][0] = new Point(8, 3);
      WallLocations[13][1] = new Point(8, 5);
      WallLocations[14][0] = new Point(8, 3);
      WallLocations[14][1] = new Point(13, 3);
      WallLocations[15][0] = new Point(13, 3);
      WallLocations[15][1] = new Point(13, 5);
      WallLocations[16][0] = new Point(8, 6);
      WallLocations[16][1] = new Point(13, 6);

      //bone-shaped room
      WallLocations[17][0] = new Point(1, 8);
      WallLocations[17][1] = new Point(1, 10);
      WallLocations[18][0] = new Point(1, 10);
      WallLocations[18][1] = new Point(2, 10);
      WallLocations[19][0] = new Point(2, 10);
      WallLocations[19][1] = new Point(2, 13);
      WallLocations[20][0] = new Point(1, 13);
      WallLocations[20][1] = new Point(2, 13);
      WallLocations[21][0] = new Point(1, 13);
      WallLocations[21][1] = new Point(1, 15);
      WallLocations[22][0] = new Point(1, 15);
      WallLocations[22][1] = new Point(2, 15);
      WallLocations[23][0] = new Point(3, 15);
      WallLocations[23][1] = new Point(4, 15);
      WallLocations[24][0] = new Point(4, 13);
      WallLocations[24][1] = new Point(4, 15);
      WallLocations[25][0] = new Point(3, 13);
      WallLocations[25][1] = new Point(4, 13);
      WallLocations[26][0] = new Point(3, 10);
      WallLocations[26][1] = new Point(3, 13);
      WallLocations[27][0] = new Point(3, 10);
      WallLocations[27][1] = new Point(4, 10);
      WallLocations[28][0] = new Point(4, 8);
      WallLocations[28][1] = new Point(4, 10);
      WallLocations[29][0] = new Point(3, 8);
      WallLocations[29][1] = new Point(4, 8);
      WallLocations[30][0] = new Point(1, 8);
      WallLocations[30][1] = new Point(2, 8);

      //leftward line
      WallLocations[31][0] = new Point(5, 10);
      WallLocations[31][1] = new Point(5, 13);

      //middle right box room
      WallLocations[32][0] = new Point(8, 8);
      WallLocations[32][1] = new Point(13, 8);
      WallLocations[33][0] = new Point(8, 9);
      WallLocations[33][1] = new Point(8, 11);
      WallLocations[34][0] = new Point(8, 11);
      WallLocations[34][1] = new Point(13, 11);
      WallLocations[35][0] = new Point(13, 9);
      WallLocations[35][1] = new Point(13, 11);

      //middle left box room
      WallLocations[36][0] = new Point(1, 16);
      WallLocations[36][1] = new Point(2, 16);
      WallLocations[37][0] = new Point(1, 16);
      WallLocations[37][1] = new Point(1, 19);
      WallLocations[38][0] = new Point(1, 19);
      WallLocations[38][1] = new Point(2, 19);
      WallLocations[39][0] = new Point(3, 19);
      WallLocations[39][1] = new Point(4, 19);
      WallLocations[40][0] = new Point(4, 16);
      WallLocations[40][1] = new Point(4, 19);
      WallLocations[41][0] = new Point(3, 16);
      WallLocations[41][1] = new Point(4, 16);

      //middle box room
      WallLocations[42][0] = new Point(6, 15);
      WallLocations[42][1] = new Point(6, 16);
      WallLocations[43][0] = new Point(6, 15);
      WallLocations[43][1] = new Point(9, 15);
      WallLocations[44][0] = new Point(9, 15);
      WallLocations[44][1] = new Point(9, 16);
      WallLocations[45][0] = new Point(9, 17);
      WallLocations[45][1] = new Point(9, 18);
      WallLocations[46][0] = new Point(6, 18);
      WallLocations[46][1] = new Point(9, 18);
      WallLocations[47][0] = new Point(6, 17);
      WallLocations[47][1] = new Point(6, 18);

      //squiggly room
      WallLocations[48][0] = new Point(10, 12);
      WallLocations[48][1] = new Point(10, 13);
      WallLocations[49][0] = new Point(10, 12);
      WallLocations[49][1] = new Point(13, 12);
      WallLocations[50][0] = new Point(13, 12);
      WallLocations[50][1] = new Point(13, 16);
      WallLocations[51][0] = new Point(11, 16);
      WallLocations[51][1] = new Point(13, 16);
      WallLocations[52][0] = new Point(12, 17);
      WallLocations[52][1] = new Point(13, 17);
      WallLocations[53][0] = new Point(12, 17);
      WallLocations[53][1] = new Point(12, 18);
      WallLocations[54][0] = new Point(10, 18);
      WallLocations[54][1] = new Point(12, 18);
      WallLocations[55][0] = new Point(10, 14);
      WallLocations[55][1] = new Point(10, 18);
      WallLocations[56][0] = new Point(10, 14);
      WallLocations[56][1] = new Point(12, 14);

      //bottom box room
      WallLocations[57][0] = new Point(6, 20);
      WallLocations[57][1] = new Point(7, 20);
      WallLocations[58][0] = new Point(6, 20);
      WallLocations[58][1] = new Point(6, 23);
      WallLocations[59][0] = new Point(6, 23);
      WallLocations[59][1] = new Point(7, 23);
      WallLocations[60][0] = new Point(8, 23);
      WallLocations[60][1] = new Point(9, 23);
      WallLocations[61][0] = new Point(9, 20);
      WallLocations[61][1] = new Point(9, 23);
      WallLocations[62][0] = new Point(8, 20);
      WallLocations[62][1] = new Point(9, 20);

      //bottom right box room
      WallLocations[63][0] = new Point(13, 18);
      WallLocations[63][1] = new Point(13, 20);
      WallLocations[64][0] = new Point(14, 18);
      WallLocations[64][1] = new Point(16, 18);
      WallLocations[65][0] = new Point(13, 21);
      WallLocations[65][1] = new Point(16, 21);

      //bottom left corner
      WallLocations[66][0] = new Point(0, 24);
      WallLocations[66][1] = new Point(1, 24);
      WallLocations[67][0] = new Point(2, 24);
      WallLocations[67][1] = new Point(2, 26);

      //left line
      WallLocations[68][0] = new Point(14, 5);
      WallLocations[68][1] = new Point(14, 9);
   }

   public void displayWelcomeScreen() {
      panel.setWelcome(true);
      panel.repaint();
   }

   public int rollDie(){
      Random generator = new Random();
      int n = generator.nextInt(6);
      n++;
      return n;
   }


   public void resolveAttack(Point p, Player opponent){
      System.out.println("Attacking square (" + p.x + ", " + p.y + ")");
      
      System.out.println("Rolling " + player.getAccuracy() + " dice for accuracy");
      int total = 0;
      for(int i=0; i<player.getAccuracy(); i++){
         total+=rollDie();
      }
      System.out.println("Attacker rolled " + total);
      
      //TODO: make accuracy do something
      //TODO: un-hard-code this value
      System.out.println("Rolling 2 dice for damage");
      total = 0;
      for(int i=0; i<2; i++){
         total+=rollDie();
      }
      System.out.println("Attacker rolled " + total);
      
      try {
         server.sendPacket(player.getName() + " attack " + total + " " +  opponent.getName());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void resolveDefence(String s){
      System.out.println("Rolling " + player.getHealth() + " dice for defense");
      int total = 0;
      for(int i=0; i<player.getHealth(); i++){
         total+=rollDie();
      }
      System.out.println("Defender rolled " + total);
      
      boolean isDead = false;
      String[] Playerargs = s.split("\\s");
      if(Integer.parseInt(Playerargs[2]) > 7){
         isDead = true;
         player.setIsDead(true);
         panel.repaint();
      }
      
      try {
         server.sendPacket(player.getName() + " attack restult " + isDead);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public boolean playerIsOverGadget(){
      boolean b = false;
      for(int i=0; i<GadgetLocations.length; i++){
         if (player.getLocation().x == GadgetLocations[i].x &&
               player.getLocation().y == GadgetLocations[i].y){
            b = true;
         }
      }
      return b;
   }

   public boolean playerIsOverWeapon(){
      boolean b = false;
      for(int i=0; i<WeaponLocations.length; i++){
         if (player.getLocation().x == WeaponLocations[i].x &&
               player.getLocation().y == WeaponLocations[i].y){
            b = true;
         }
      }
      return b;
   }

   public boolean playerIsOverTeleporter(){
      boolean b = false;
      for(int i=0; i<TeleporterLocations.length; i++){
         if (player.getLocation().x == TeleporterLocations[i].x &&
               player.getLocation().y == TeleporterLocations[i].y){
            b = true;
         }
      }
      return b;
   }

   public void teleportPlayer(){
      if (player.getLocation().x == TeleporterLocations[0].x &&
            player.getLocation().y == TeleporterLocations[0].y){
         player.setLocation(TeleporterLocations[1]);
      }
      else{
         player.setLocation(TeleporterLocations[0]);
      }
   }

   public boolean wallIsAbovePlayer(){

      for(int i=0; i<WallLocations.length; i++){
         Point intialWallPoint = WallLocations[i][0];
         Point finalWallPoint = WallLocations[i][1];
         Point playerPosition = player.getLocation();

         //if the wall is a horizontal line
         if(intialWallPoint.y == finalWallPoint.y){
            //if player has same x or is to the right of the initial point
            if(intialWallPoint.x <= playerPosition.x){
               //if player has same x or is to the left of the end point
               if(finalWallPoint.x > playerPosition.x){
                  //if wall is above player
                  if(intialWallPoint.y == playerPosition.y){
                     return true;
                  }
               }
            }
         }
      }
      return false;
   }

   public boolean wallIsBelowPlayer(){
      for(int i=0; i<WallLocations.length; i++){
         Point intialWallPoint = WallLocations[i][0];
         Point finalWallPoint = WallLocations[i][1];
         Point playerPosition = player.getLocation();

         //if the wall is a horizontal line
         if(intialWallPoint.y == finalWallPoint.y){
            //if player has same x or is to the right of the initial point
            if(intialWallPoint.x <= playerPosition.x){
               //if player has same x or is to the left of the end point
               if(finalWallPoint.x > playerPosition.x){
                  //if wall is below player
                  if(intialWallPoint.y == playerPosition.y+1){
                     return true;
                  }
               }
            }
         }
      }
      return false;
   }

   public boolean wallIsLeftOfPlayer(){
      for(int i=0; i<WallLocations.length; i++){
         Point intialWallPoint = WallLocations[i][0];
         Point finalWallPoint = WallLocations[i][1];
         Point playerPosition = player.getLocation();

         //if the wall is a vertical line
         if(intialWallPoint.x == finalWallPoint.x){
            //if player has same y or below the initial point
            if(intialWallPoint.y <= playerPosition.y){
               //if player is above of the end point
               if(finalWallPoint.y > playerPosition.y){
                  //if wall is to the left of player
                  if(intialWallPoint.x == playerPosition.x){
                     return true;
                  }
               }
            }
         }
      }
      return false;
   }

   public boolean wallIsRightOfPlayer(){
      for(int i=0; i<WallLocations.length; i++){
         Point intialWallPoint = WallLocations[i][0];
         Point finalWallPoint = WallLocations[i][1];
         Point playerPosition = player.getLocation();

         //if the wall is a vertical line
         if(intialWallPoint.x == finalWallPoint.x){
            //if player has same y or below the initial point
            if(intialWallPoint.y <= playerPosition.y){
               //if player is above of the end point
               if(finalWallPoint.y > playerPosition.y){
                  //if wall is to the right of player
                  if(intialWallPoint.x == playerPosition.x+1){
                     return true;
                  }
               }
            }
         }
      }
      return false;
   }

   public void init(){
      ip  = (String)JOptionPane.showInputDialog(
            this,
            "Enter the IP address of the server",
            "Print",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null, ""
      );
      String name  = (String)JOptionPane.showInputDialog(
            this,
            "Enter your name",
            "Print",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null, ""
      );
      int health  = Integer.parseInt((String)JOptionPane.showInputDialog(
            this,
            "Enter desired health (1-7)",
            "Print",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null, ""
      ));
      int speed = Integer.parseInt((String)JOptionPane.showInputDialog(
            this,
            "Enter desired speed (1-" + (7-health) + ")",
            "Print",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null, ""
      ));
      int accuracy = Integer.parseInt((String)JOptionPane.showInputDialog(
            this,
            "Enter desired accuracy (" + (7-(health+speed)) + ")",
            "Print",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null, ""
      ));

      player = new Player(name, health, speed, accuracy);

      try {
         server = new ClientConnection(ip, port, this);
      } catch (Exception e1) {
         e1.printStackTrace();
      }
      server.start();
      String line = player.stats();

      try {
         server.sendPacket(line);
         int n = rollDie();
         JOptionPane.showMessageDialog(this, "Rolling to see who goes first: " + n);
         server.sendPacket(player.name + " rolled " + n);
      } catch (IOException e1) {
         e1.printStackTrace();
      }
      drawGadget();
      drawWeapon();
      drawFrag();
   }

   @Override
   public void keyPressed(KeyEvent e) {
      if(panel.getWelcome() && e.getKeyCode() == KeyEvent.VK_ENTER){
         panel.setWelcome(false);
         init();
         panel.repaint();
      }
      else if(player.isPlayersTurn()){
         player.displayHand();
         if(e.getKeyCode() == KeyEvent.VK_UP){

            if(wallIsAbovePlayer()){
               return;
            }
            player.moveUp(1);
            try {
               server.sendPacket(player.stats());
            } catch (IOException e1) {
               e1.printStackTrace();
            }

            if(playerIsOverGadget()){
               int n = rollDie();
               System.out.println("Roll for gadget card: " + n);
               if(n > 3){
                  System.out.println("Player earned a gadget card!");
                  drawGadget();
               }
            }
            else if(playerIsOverWeapon()){
               int n = rollDie();
               System.out.println("Roll for weapon card: " + n);
               if(n > 3){
                  System.out.println("Player earned a weapon card!");
                  drawWeapon();
               }
            }
            panel.repaint();
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(wallIsBelowPlayer()){
               return;
            }
            player.moveDown(1);
            try {
               server.sendPacket(player.stats());
            } catch (IOException e1) {
               e1.printStackTrace();
            }

            if(playerIsOverGadget()){
               int n = rollDie();
               System.out.println("Roll for gadget card: " + n);
               if(n > 3){
                  System.out.println("Player earned a gadget card!");
                  drawGadget();
               }
            }
            else if(playerIsOverWeapon()){
               int n = rollDie();
               System.out.println("Roll for weapon card: " + n);
               if(n > 3){
                  System.out.println("Player earned a weapon card!");
                  drawWeapon();
               }
            }
            panel.repaint();
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(wallIsLeftOfPlayer()){
               return;
            }
            player.moveLeft(1);
            try {
               server.sendPacket(player.stats());
            } catch (IOException e1) {
               e1.printStackTrace();
            }

            if(playerIsOverGadget()){
               int n = rollDie();
               System.out.println("Roll for gadget card: " + n);
               if(n > 3){
                  System.out.println("Player earned a gadget card!");
                  drawGadget();
               }
            }
            else if(playerIsOverWeapon()){
               int n = rollDie();
               System.out.println("Roll for weapon card: " + n);
               if(n > 3){
                  System.out.println("Player earned a weapon card!");
                  drawGadget();
               }
            }
            panel.repaint();
         }
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(wallIsRightOfPlayer()){
               return;
            }
            player.moveRight(1);
            try {
               server.sendPacket(player.stats());
            } catch (IOException e1) {
               e1.printStackTrace();
            }

            if(playerIsOverGadget()){
               int n = rollDie();
               System.out.println("Roll for gadget card: " + n);
               if(n > 3){
                  System.out.println("Player earned a gadget card!");
                  drawGadget();
               }
            }
            else if(playerIsOverWeapon()){
               int n = rollDie();
               System.out.println("Roll for weapon card: " + n);
               if(n > 3){
                  System.out.println("Player earned a weapon card!");
                  drawWeapon();
               }
            }
            panel.repaint();
         }
         else if(playerIsOverTeleporter() && e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Whoosh!");
            teleportPlayer();
            try {
               server.sendPacket(player.stats());
            } catch (IOException e1) {
               e1.printStackTrace();
            }
            panel.repaint();
         }
         else if(e.getKeyChar() == 'c' && player.isPlayersTurn()){
            endTurn();
         }
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {}

   @Override
   public void keyTyped(KeyEvent e) {}

   
   //server interfaces
   ///////////////////////////////////////////////////////////////////////
   public void startTurn() {
      JOptionPane.showMessageDialog(this, "Your Turn");
      player.setPlayersTurn(true);
   }

   public void endTurn(){
      JOptionPane.showMessageDialog(this, "Turn Ended");
      try {
         server.sendPacket(player.getName() + " end of turn");
         System.out.println(player.getName() + " end of turn");
      } catch (IOException e) {
         e.printStackTrace();
      }
      player.setPlayersTurn(false);
   }

   public void update(String s){
      String[] playerArr = s.split("\\s");
      boolean is_found = false;
      for(int i=0; i<CURRENTOTHERPLAYERS; i++){
         if(otherPlayers[i].getName().equals(playerArr[0])){
            is_found = true;
            otherPlayers[i].setLocation(new Point(Integer.parseInt(playerArr[4]),
                  Integer.parseInt(playerArr[5])));
         }
      }
      if(!is_found){
         if(CURRENTOTHERPLAYERS < MAXOTHERPLAYERS){
            otherPlayers[CURRENTOTHERPLAYERS] = new Player(playerArr[0], Integer.parseInt(playerArr[1]), 
               Integer.parseInt(playerArr[2]), Integer.parseInt(playerArr[3]));
            otherPlayers[CURRENTOTHERPLAYERS].setLocation(new Point(Integer.parseInt(playerArr[4]),
               Integer.parseInt(playerArr[5])));
            CURRENTOTHERPLAYERS++;
         }
      }
      panel.repaint();
   }

   public void drawGadget(){
      try {
         server.sendPacket(player.getName() + " request gadget");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void drawWeapon(){
      try {
         server.sendPacket(player.getName() + " request weapon");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void drawFrag(){
      try {
         server.sendPacket(player.getName() + " request frag");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void receiveGadget(String s){
      String[] playerArr = s.split("\\s");
      player.giveGadgetCard(Integer.parseInt(playerArr[2]));
   }
   
   public void receiveWeapon(String s){
      String[] playerArr = s.split("\\s");
      player.giveWeaponCard(Integer.parseInt(playerArr[2]));
   }
   
   public void receiveFrag(String s){
      String[] playerArr = s.split("\\s");
      player.giveFragCard(new FragCard(Integer.parseInt(playerArr[2]), this));
   }
}
