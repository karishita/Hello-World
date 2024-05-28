import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StopamdWaitArq {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            data.add("Packet" + i);
        }

        Sender sender = new Sender();
        Receiver receiver = new Receiver();
        sender.sendData(data, receiver);
    }
}

class Sender {
    private int seqNum = 0;

    public void sendData(List<String> data, Receiver receiver) {
        for (String packet : data) {
            boolean ack = false;
            while (!ack) {
                System.out.println("Sender: Sending " + packet + " with SeqNum " + seqNum);
                ack = receiver.receiveData(packet, seqNum);
                if (ack) {
                    System.out.println("Sender: Received acknowledgment for sequence number " + seqNum);
                    seqNum = (seqNum + 1) % 2; // Toggle sequence number between 0 and 1
                } else {
                    System.out.println("Sender: Ack not received, resending packet " + packet);
                }
            }
        }
        System.out.println("All data sent!");
    }
}

class Receiver {
    private int expectedSeqNum = 0;
    private Random random = new Random();

    public boolean receiveData(String packet, int seqNum) {
        // Simulate packet loss with a 20% chance
        if (random.nextInt(100) < 20) {
            System.out.println("Receiver: " + packet + " lost");
            return false;
        }

        if (seqNum == expectedSeqNum) {
            System.out.println("Receiver: Received " + packet + " with correct sequence number " + seqNum);
            System.out.println("Receiver: Sending acknowledgment for sequence number " + seqNum);
            expectedSeqNum = (expectedSeqNum + 1) % 2; // Toggle sequence number between 0 and 1
            return true;
        } else {
            System.out.println("Receiver: Received duplicate or out-of-order packet " + packet + " with sequence number " + seqNum);
            return false;
        }
    }
}

