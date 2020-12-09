// Author : Ashutosh Mishra

import java.net.*;
import java.io.*;
import java.util.*;
public class UDPEchoClient
{
private static InetAddress host;
private static final int PORT=1234;
private static DatagramSocket datagramSocket;
private static DatagramPacket inPacket,outPacket;
private static byte[] buffer;
public static void main(String[] args)
{
try
{
host=InetAddress.getLocalHost();
}
catch(UnknownHostException u)
{
System.out.println("Host ID not found");
System.exit(1);
}
accessServer();
}
private static void accessServer()
{
try
{
datagramSocket=new DatagramSocket();
DataInputStream userEntry=new DataInputStream(System.in);
String message="",response="";
do
{
System.out.println("Enter Message");
message=userEntry.readLine();
if(!message.equals("CLOSE"))
{
outPacket=new DatagramPacket(message.getBytes(),message.length(),host,PORT);
datagramSocket.send(outPacket);
buffer=new byte[256];
inPacket=new DatagramPacket(buffer,buffer.length);
datagramSocket.receive(inPacket);
response=new String(inPacket.getData(),0,inPacket.getLength());
System.out.println("\n<SERVER>"+response);
}
}while(!message.equals("CLOSE"));
}
catch(IOException ex)
{
ex.printStackTrace();
}
finally
{
System.out.println("\nClosing Connection..\n");
datagramSocket.close();
}

}
}
