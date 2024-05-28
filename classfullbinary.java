
import java.util.*;
public class classfullbinary {   
public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter IP address in binary");
    String ip;
    ip=sc.nextLine();
    sc.close();
    String octets[]=ip.split("\\.");
    if(octets.length!=4)
    {
        System.out.println("Invalid IP");

    }

   // int firstoctet=Integer.parseInt(octets[0]);
    char c=getClass(octets[0]);
    String networkID=getNetworkID(c,octets);
    String hostID=getHostID(c,octets);

    System.out.println("class is:  " +c);
    System.out.println("Network ID:  "+ networkID);
    System.out.println("Host ID : "+ hostID);

}
public static char getClass(String firstoctet)
{
    if(firstoctet.charAt(0)=='0')
    {
    return 'A';
    }
   else if(firstoctet.substring(0,2).equalsIgnoreCase("10"))
   {
    return 'B';
   }
    else if(firstoctet.substring(0,3).equalsIgnoreCase("110"))
    {
       return 'C';
    }
       else if(firstoctet.substring(0,4).equalsIgnoreCase("1110"))
       {
       return 'D';
       }
       else if(firstoctet.substring(0,4).equalsIgnoreCase("1111"))
       {
       return 'E';
       }
       else
       {
        return 'N';
       }
}

public static String getNetworkID(char c, String[] octets)
{
    if(c=='A')
    return octets[0]+"0.0.0";

    else if(c=='B')
    return octets[0]+"."+octets[1]+"0.0";

else if(c=='C')
  return octets[0]+"."+octets[1]+"."+octets[2]+".0";
else
 return("Not applicable");
}

public static String getHostID(char c,String[] octets)
{
    if(c=='A')
    return "0."+octets[1]+"."+octets[2]+"."+octets[3];
    else if(c=='B')
        return "0.0."+octets[2]+"."+octets[3];
    else if(c=='C')
      return "0.0.0."+octets[3];
    else 
    return "Not applicable";
}



}


