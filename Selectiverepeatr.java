import java.util.*;
class Reciever
{   
    int Window;
    
    int base;
    public Reciever(int window)
    {
        Window=window;
        base=0;
    }
    public int Ack(List<String> w)
    {
     List<String> Buffer=new ArrayList<>(Window);
     //List<string> NaK=new ArrayList<>(Window);
      int expectedSeqNum=base;
      Random random=new Random();
      for(String packet:w)
      {
        String[] Parts=packet.split(" ");
        int SeqNum=Integer.parseInt(Parts[1]);
        if(random.nextInt(100)<50)
        {
            
            System.out.println("Reciever:Packet Lost:Sending Nack "+ SeqNum);
            return SeqNum;
        }
        if(SeqNum==expectedSeqNum)
        {
            Buffer.add(packet);
            expectedSeqNum++;
            base++;
            System.out.println("Reciever : sending Ack for "+packet+" with sequence Num "+SeqNum+" AckNO "+SeqNum);
            
  }
  

}
return -1;
    }
public int getBase()
{
    return base;
}
}

class Sender
{
    int Window;
    int base;
    int nextSeqNum;
    public Sender(int window)
    {
        Window=window;
        base=0;
        
    }
    Reciever r=new Reciever(Window);
    public void SendData(List<String>data)
    {
       
        List<String> w=new ArrayList<>();
        while(nextSeqNum<data.size())
        {
            nextSeqNum=base;
        for(int i=base;i<Window+base && nextSeqNum<data.size();i++)
        {
            w.add(data.get(i));
            nextSeqNum++;
        }
        System.out.println("Sending Window: "+w);
       int c= r.Ack(w);
        if(c!=-1)
        {
            System.out.println("Sender retransmitting packet with sequence number "+c);
        }
        else
        {
        System.out.println("Sender recieved Ack for window :" +w);
        System.out.println("Sliding the window");
        }
        w.clear();
        base=r.getBase();
    }

    }
}

public class Selectiverepeatr {
    public static void main(String args[])
    {
        List<String> data=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            data.add("Packet "+i);
        }
        Sender s=new Sender(4);
        s.SendData(data);

    }
    
}