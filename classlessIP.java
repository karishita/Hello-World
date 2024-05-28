import java.util.*;
public class classlessIP {
    public static void main(String args[])
{
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter an IP Address in CIDR Notation");
   String cidr=sc.nextLine();
   String parts[]=cidr.split("/");
   if(parts.length!=2)
     System.out.println("Invalid CIDR notation");
    
   int prefix=Integer.parseInt(parts[1]);
   String IP=parts[0];
   String octets[]=IP.split("\\.");

   int ip[]=new int[4];
   for(int i=0;i<4;i++)
     ip[i]=Integer.parseInt(octets[i]);
//Convert IP to a single integer
  long ipint=toInt(ip);
  System.out.println("IP Address in integer "+ipint);

  //Calculate Subnet Mask NetworkID HostID
  long mask=0xFFFFFFFF<<(32-prefix);
  long NetworkID=ipint&mask;
  long HostAddress=ipint&~mask;
  System.out.println("The network Mask is  : "+ toDottedDecimal(mask));
  System.out.println("The network ID is  : "+ toDottedDecimal(NetworkID));
  System.out.println("The host ID is  : "+ toDottedDecimal(HostAddress));

}

public static long toInt(int ip[])
    {
        long result=0;
        for(int i=0;i<4;i++)
        {
            result=result|(long)ip[i]<<(24-(8*i));


        }
        return result;
    }

    public static String toDottedDecimal(long value)
    {
        return((value >> 24) & 0xFF)+"."+((value >>16) & 0xFF)+"."+((value>>8) & 0xFF)+"."+(value & 0xFF);
    }
}
