import java.net.*;
import java.io.*;
public class Server {
    public static void main(String args[])
    {
    try{
    ServerSocket ss=new ServerSocket(9999);
    System.out.println("Server Waiting for request");
    Socket s=ss.accept();
    System.out.println("Client Connected");
    OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());
    PrintWriter wr=new PrintWriter(os,true);
    BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
    //reading data from client 
    String str=br.readLine();
    System.out.println("Client Sent "+ str);
    String response=str.toUpperCase();
    //send response
    wr.println(response + "\n");
    ss.close();
    os.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
}
