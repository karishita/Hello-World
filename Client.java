import java.net.*;
import java.io.*;
//import java.util.*;
public class Client {
    public static void main(String args[])
    {
        String ip="localhost";
        int port=9999;
        try{
        Socket s=new Socket(ip,port);
        String str="hello world\n";
        OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());
        PrintWriter wr=new PrintWriter(os,true);
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        //send data in lower case
        wr.println(str);
        //accept data from server
        String s1=br.readLine();
        System.out.println("Server sent "+ s1);
        os.close();
        s.close();
    }
    catch(Exception e)
    {
       e.printStackTrace();
    }
    }
    
}
