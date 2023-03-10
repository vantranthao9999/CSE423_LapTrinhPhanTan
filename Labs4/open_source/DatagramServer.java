import java.net.*;
import java.io.*;
public class DatagramServer {
    public static void main(String[] args) {
        DatagramPacket datapacket, returnpacket;
        int port = 2018;
        int len = 1024;
        try {
            DatagramSocket datasocket = new DatagramSocket(port);
            byte[] buf = new byte[len];
            datapacket = new DatagramPacket(buf, buf.length);
            while (true) {
                try {
                    datasocket.receive(datapacket); // receive the data packet from server
                    returnpacket = new DatagramPacket( // create a datagram packet
                            datapacket.getData(),
                            datapacket.getLength(),
                            datapacket.getAddress(),
                            datapacket.getPort());
                    datasocket.send(returnpacket); // and send to server
                    // will display  Yes if receive

                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (SocketException se) {
            System.err.println(se);
        }
    }
}
