import java.net.*;
public class UDPServer {
    public static void main(String args[])
    {
        try{
            DatagramSocket ss=new DatagramSocket(9999);

            System.out.println("Server is running");

            byte[] recieveData=new byte[1024];
            byte[] sendData;
            //recieve data
            DatagramPacket recievePacket=new DatagramPacket(recieveData,recieveData.length);
            ss.receive(recievePacket);
            String message=new String(recievePacket.getData(),0,recievePacket.getLength());
            System.out.println("Recieved from Client "+ message);

            //sending data
            InetAddress client= recievePacket.getAddress();
            int port=recievePacket.getPort();
            String str="Hello Client";
            sendData=str.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,client,port);
            ss.send(sendPacket);
            ss.close();
        }
        catch(Exception e)
        
    {
        e.printStackTrace();
    }
    }
}
