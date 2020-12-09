import java.io.*;
import java.net.*;
import java.util.*;
public class TFTPClient
{
static InetAddress host;
static DatagramSocket dss;
static DatagramPacket outPacket,inPacket;
static byte[] buffer;
static int port=69;
public static void main(String args[])
{
try
{
host=InetAddress.getByName("localhost");
}
catch(UnknownHostException uhe)
{
System.out.println("Host Not found");
}
try
{
dss=new DatagramSocket();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter file name should be received from server");
String str1,finput;
BufferedWriter bw;
while(!(str1=br.readLine()).equals("null"))
{
outPacket=new DatagramPacket(str1.getBytes(),str1.length(),host,port);
dss.send(outPacket);
bw=new BufferedWriter(new FileWriter(str1));
System.out.println("Created fileinput stream");
do
{
System.out.println("Receiving file data from");
buffer=new byte[512];
inPacket=new DatagramPacket(buffer,buffer.length);
dss.receive(inPacket);
System.out.println("Server Port="+inPacket.getPort());
finput=new String(inPacket.getData(),0,inPacket.getLength());
if(!(finput.equals("sent")))bw.write(finput,0,finput.length());
bw.newLine();
bw.flush();
}
while(!finput.equals("sent"));
port=inPacket.getPort();
System.out.println(port);
}
} catch(Exception ie) {}
}
}