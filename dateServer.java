import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.*;
import java.io.*;
import java.util.*;
public class dateServer {
    public static void main(String args[])
    {
        try{
            ServerSocket ss =new ServerSocket(9999);
            System.out.println("Server is listening ");
            Socket s=ss.accept();
            System.out.println("Client connected");

            //send data
            OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());
            PrintWriter wr=new PrintWriter(os,true);
            //recieve data
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            //read client request
            String request=br.readLine();
            System.out.println("client request"+ request);
            if("GET_DATE".equalsIgnoreCase(request))
            {
                // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                //LocalDateTime now = LocalDateTime.now();
                //String date=dtf.for;mat(now)
                //wr.println(date + "\n");
                SimpleDateFormat df=new SimpleDateFormat("dd/MM/YYYY  HH:mm:ss");
                Date date=new Date();
                String response=df.format(date);
                wr.println(response +"\n");
            }
            else
            {
                System.out.println("Invalid ");

            }
             ss.close();
    
            }

            catch(Exception e)
            {
                e.printStackTrace();

            }

        }
    }
    

