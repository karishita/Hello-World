
import java.util.*;
public class subnetMask {
    public static void main(String args[])
    {
        String ip;
        int subnet;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter an IP address");
        ip=sc.nextLine();
        subnet=sc.nextInt();
        int subnetbit=(int)Math.ceil(Math.log(subnet)/Math.log(2));
        String mask=SubnetMask(subnetbit);


    }
    public static String SubnetMask(int bits)
    {
        int subnetMask=0xFFFFFFFF<<(32-bits);
    }
    
}
