import java.net.*;
//import java.io.*;

public class MulticastServer {
    public static void main(String args[])
    {
        String multicast="230.0.0.0";
        int port=9999;
        try{

            
            MulticastSocket ms=new MulticastSocket();
            InetAddress group=InetAddress.getByName(multicast);
            System.out.println("Multicast Server is running");
            String message="Hello World to Client";
            byte sendData[]=message.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,group,port);
            ms.send(sendPacket);
            //System.out.println("Message sent "+ message);
            ms.close();

        
    }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
