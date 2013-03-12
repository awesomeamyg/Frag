
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerConnection extends Thread {
   final int MAXBYTES = 1024;
   
   DatagramSocket serverSocket;
   InetAddress IPAddress;
   int port;
   
   ServerConnection(int port) throws Exception {
      serverSocket = new DatagramSocket(port);
      this.port = port;
   }
   
   public void sendPacket(InetAddress IPAddress, String s) throws IOException{
      byte[] sendData = s.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
      serverSocket.send(sendPacket);
   }
   
   public InetAddress getLastClientIP(){
      return IPAddress;
   }
   
   public String receivePacket() throws IOException{
      byte[] receiveData = new byte[MAXBYTES];
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      serverSocket.receive(receivePacket);
      IPAddress = receivePacket.getAddress();
      return new String(receivePacket.getData());
   }
   
   public void close(){
      serverSocket.close();
   }
}
