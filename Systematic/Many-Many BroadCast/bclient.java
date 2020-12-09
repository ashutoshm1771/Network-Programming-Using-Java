//Author : Ashutosh Mishra

import java.io.*;
import java.net.*;
public class bclient extends Thread
{
static Socket cs=null;
public static void main(String args[])
{
try
 {
cs=new Socket("localhost",4000);
System.out.println("connected to server");
BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
InputScan is=new InputScan();
is.start();
while(true)
{
String msg;
msg=in.readLine();
System.out.println(msg);
}
}
catch(Exception e)

{
}
}
}
class InputScan extends bclient
{
DataInputStream stdin=new DataInputStream(System.in);
 public void run()
{
try
{
PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
while(true)
{
String msg;
msg=stdin.readLine();
out.println(msg);
}
}
catch(Exception e){
}
}
}
