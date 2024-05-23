import java.net.*;
import java.util.Enumeration;
public class MulticastClient {
    public static void main(String args[])
    {
        try{

            String address="230.0.0.0";
            int port=9999;
            MulticastSocket ms=new MulticastSocket(port);
            InetAddress group=InetAddress.getByName(address);
            
            NetworkInterface networkInterface = null;
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                if (!ni.isLoopback() && ni.isUp()) {
                    networkInterface = ni;
                    break;
                }
            }
            ms.joinGroup(new java.net.InetSocketAddress(group, port), networkInterface);
            System.out.println("Multicast Client is Running");
            byte[] recieveData=new byte[1024];
            DatagramPacket recievePacket=new DatagramPacket(recieveData,recieveData.length);
            ms.receive(recievePacket);
            String str=new String(recievePacket.getData(),0,recievePacket.getLength());
            System.out.println("Recieved "+ str);
            ms.close();

        }
    
    catch(Exception e)
    {
        e.printStackTrace();
    }
    } 
}
