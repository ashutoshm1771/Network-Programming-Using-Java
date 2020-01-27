import java.net.*;
import java.io.*;
public class UDPEchoServer
{
private static final int PORT=1234;
private static DatagramSocket datagramSocket;
private static DatagramPacket inPacket,outPacket;
private static byte[] buffer;
public static void main(String[] args)
{
System.out.println("Opening Port..\n");
try
{
datagramSocket=new DatagramSocket(PORT);
}
catch(SocketException sockEX)
{
System.out.println("Unable to attach to port");
System.exit(1);
}
handleClient();
}
private static void handleClient()
{
try
{
String messageIn,messageOut;
int numMessages=0;
do
{
buffer=new byte[256];
inPacket=new DatagramPacket(buffer,buffer.length);
datagramSocket.receive(inPacket);
InetAddress clientAddress=inPacket.getAddress();
int clientPort=inPacket.getPort();
messageIn=new String(inPacket.getData(),0,inPacket.getLength());
System.out.println("Message Recieves");
numMessages++;
messageOut="Message"+numMessages+"."+messageIn;
outPacket=new DatagramPacket(messageOut.getBytes(),messageOut.length(),clientAddress,clientPort);
datagramSocket.send(outPacket);
}
while(true);
}
catch(IOException e)
{
e.printStackTrace();
}
finally
{
System.out.println("\nClosing Connection..\n");
datagramSocket.close();
}
}
}