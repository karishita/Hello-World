import java.util.*;
public class CRC {
  // function to calculate bitwise xor
    public  static String xor(String a,String b)
    {
        StringBuilder result=new StringBuilder();
        for(int i=1;i<b.length();i++)
        {
            if(a.charAt(i)==b.charAt(i))
              result.append('0');
              else
              result.append('1');

        }
        return result.toString();
    }

    public static String Division(String data,String divisor)
    {
        //10int datalength=data.length();
        int divisorlength=divisor.length();
        String newdata=data+"0".repeat(divisorlength-1);
        
        String remainder=newdata.substring(0, divisorlength);
        for(int i=divisorlength;i<=newdata.length();i++)
             {
                if(remainder.charAt(0)=='1')
                {
                   remainder= xor(remainder,divisor)+(i<newdata.length()?newdata.charAt(i):"");
                }
                   else
                   {
                    remainder=xor(remainder,"0".repeat(divisorlength))+(i<newdata.length()?newdata.charAt(i):"");
         
                }
            }
                return remainder.substring(1);

             }

             public static boolean check(String data,String divisor)
             {
               // int datalength=data.length();
             int divisorlength=divisor.length();
         
             String remainder=data.substring(0, divisorlength);
        for(int i=divisorlength;i<=data.length();i++)
             {
                if(remainder.charAt(0)=='1')
                {
                   remainder= xor(remainder,divisor)+(i<data.length()?data.charAt(i):"");
                }
                   else
                   {
                    remainder=xor(remainder,"0".repeat(divisorlength))+(i<data.length()?data.charAt(i):"");
         
                }    
            }
            if(remainder.substring(1).contains("1"))
              return false;
              else
              return true;
             }

    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        String data;
        String divisor;
        System.out.println("Enter A data to be transmitted");
        data=sc.nextLine();
        System.out.println("enter divisor");
        divisor=sc.nextLine();
        String CRC=Division(data, divisor);
        String tdata;
        System.out.println("Enter recieved data");
        tdata=sc.nextLine();
        String datawithCRC= tdata+CRC;
        boolean c=check(datawithCRC, divisor);
        if(c==true)
        System.out.println("No error");
        else
        System.out.println("Error!");
    }
    
}
