import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientConnection extends Thread {
   final int MAXBYTES = 1024;

   InetAddress IPAddress;
   DatagramSocket clientSocket;
   Map map;

   int port;

   ClientConnection(String hostName, int port, Map m) throws Exception {
      clientSocket = new DatagramSocket(port);
      IPAddress = InetAddress.getByName(hostName);
      map = m;
      this.port = port;
   }

   public void sendPacket(String s) throws IOException{
      byte[] sendData = s.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
      clientSocket.send(sendPacket);
   }

   public String receivePacket() throws IOException{
      byte[] receiveData = new byte[MAXBYTES];
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String test = new String(receivePacket.getData());
      return test;
   }

   public void close(){
      clientSocket.close();
   }

   @Override
   public void run() {
      while(true){
         String line = "";
         try {
            line = receivePacket();
            System.out.println(line);
         } catch (IOException e) {
            e.printStackTrace();
         }

         line = line.trim();
         if(line.matches("^\\w+\\s\\d\\s\\d\\s\\d\\s\\d+\\s\\d+")){
            map.update(line);
         }
         else if(line.matches("^\\w+ begin turn")){
         String[] playerArr = line.split("\\s");
            if (playerArr[0].equals(map.player.getName())){
               map.startTurn();
            }
         }
         else if(line.matches("^\\w+ gadget \\d+")){
            map.receiveGadget(line);
         }
         else if(line.matches("^\\w+ weapon \\d")){
            map.receiveWeapon(line);
         }
         else if(line.matches("^\\w+ frag \\d")){
            map.receiveFrag(line);
         }
         else if(line.matches("^\\w+ attack \\d \\w+")){
            map.resolveDefence(line);
         }
      }
   }
}