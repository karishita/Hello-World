
import java.net.*;

public class UDPClient {
public static void main(String args[])
{
try{
    String server="localhost";
    int port=9999;
    DatagramSocket s=new DatagramSocket();
    InetAddress address=InetAddress.getByName(server);
    byte[] sendData;
    byte[] recieveData=new byte[1024];

    //send message
    String str="Hello World to Server";
    sendData=str.getBytes();

    DatagramPacket sendpacket=new DatagramPacket(sendData,sendData.length,address,port);
    s.send(sendpacket);

    //recieve message
    DatagramPacket recievePacket=new DatagramPacket(recieveData,recieveData.length);
    s.receive(recievePacket);
     String response=new String(recievePacket.getData(),0,recievePacket.getLength());
     System.out.println("Server Sent "+ response);
     s.close();
}
catch(Exception e)
{
    e.printStackTrace();
}
}
}
