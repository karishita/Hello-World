import java.net.*;
import java.io.*;
public class dateClient {
    public static void main(String args[])
    {
      try
      {
        String ip="localhost";
        int port=9999;
        Socket s=new Socket(ip,port);
        OutputStreamWriter os= new OutputStreamWriter(s.getOutputStream());
        PrintWriter wr=new PrintWriter(os,true);
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

        //send request to server
        wr.println("GET_DATE\n");

        //read and print server respnse
        String response=br.readLine();
        System.out.println("Server sent " + response);
        s.close();

      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    
}
