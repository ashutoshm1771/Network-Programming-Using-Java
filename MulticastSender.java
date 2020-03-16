import java.io.*;
import java.net.*;
public class MulticastSender
{
public static void main(String args[])
{
InetAddress ia=null;
int port=0;
String st=null;
try
{
ia=InetAddress.getByName(args[0]);
port=Integer.parseInt(args[1]);
}
catch(Exception e)
{
System.out.println(e);
System.out.println("Usage:java MulticastSender");
System.exit(1);
}
while(true)
{
try
{
BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
st=stdin.readLine();
}
catch(IOException e)
{}
byte[] data=st.getBytes();
DatagramPacket dp=new DatagramPacket(data,data.length,ia,port);
try
{
MulticastSocket ms=new MulticastSocket(port);
ms.send(dp);
ms.close();
}
catch(SocketException se)
{
System.out.println(se);
}
catch(IOException ie)
{
System.out.println(ie);
}
}}}

                  


