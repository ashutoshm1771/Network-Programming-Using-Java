// Author : Ashutosh Mishra

import java.io.*;
import java.net.*;
public class MulticastSniffer
{
public static void main(String args[])
{
InetAddress group=null;
int port=0;
try{
group=InetAddress.getByName(args[0]);
port=Integer.parseInt(args[1]);
}
catch(Exception e)
{}
MulticastSocket ms=null;
try{
ms=new MulticastSocket(port);
ms.joinGroup(group);
byte[] buffer=new byte[100];
System.out.println(buffer.length);
while(true)
{
for(int i=0;i<buffer.length;i++)
buffer[i]=(byte)0;
DatagramPacket dp=new DatagramPacket(buffer,buffer.length);
ms.receive(dp);
String s=new String(dp.getData());
System.out.println(s);
}
}
catch(IOException ie){}

finally
{
if(ms!=null)
{
try{
ms.leaveGroup(group);
ms.close();
}
catch(IOException ee){}
}}}}



