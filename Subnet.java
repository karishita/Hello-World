import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subnet {

    public static void main(String[] args) throws UnknownHostException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter IP address (e.g., 192.168.1.0): ");
        String ipAddress = scanner.nextLine();

        System.out.print("Enter original prefix (e.g., 24): ");
        int originalPrefix = scanner.nextInt();

        System.out.print("Enter number of subnets required: ");
        int numberOfSubnets = scanner.nextInt();

        int newPrefix = calculateNewPrefix(originalPrefix, numberOfSubnets);

        List<String> subnets = calculateSubnets(ipAddress, originalPrefix, newPrefix);

        for (String subnet : subnets) {
            System.out.println("Network ID: " + subnet);
        }

        scanner.close();
    }

    public static int calculateNewPrefix(int originalPrefix, int numberOfSubnets) {
        int additionalBits = (int) Math.ceil(Math.log(numberOfSubnets) / Math.log(2));
        return originalPrefix + additionalBits;
    }

    public static List<String> calculateSubnets(String ipAddress, int originalPrefix, int newPrefix) throws UnknownHostException {
        List<String> subnets = new ArrayList<>();

        int totalSubnets = 1 << (newPrefix - originalPrefix);
        int subnetSize = 1 << (32 - newPrefix);

        int[] ipParts = parseIpAddress(ipAddress);
        int baseIp = (ipParts[0] << 24) | (ipParts[1] << 16) | (ipParts[2] << 8) | ipParts[3];

        for (int i = 0; i < totalSubnets; i++) {
            int subnetIp = baseIp + (i * subnetSize);
            String subnetAddress = intToIp(subnetIp);
            subnets.add(subnetAddress);
        }

        return subnets;
    }

    private static int[] parseIpAddress(String ipAddress) throws UnknownHostException {
        InetAddress inet = InetAddress.getByName(ipAddress);
        byte[] bytes = inet.getAddress();
        int[] ipParts = new int[4];
        for (int i = 0; i < 4; i++) {
            ipParts[i] = bytes[i] & 0xFF;
        }
        return ipParts;
    }

    private static String intToIp(int ip) {
        return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
    }
}
