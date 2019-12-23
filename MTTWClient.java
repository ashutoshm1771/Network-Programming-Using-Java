import java.io.*;
import java.net.*;

public class MTTWClient extends Thread
{
static Socket cs=null;
public static void main(String args[])
{
BufferedReader in=null;
InputScan is=null;
try{
cs=new Socket("localhost",4000);
in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
is=new InputScan(cs);
is.setDaemon(true);
is.start();
while(true)
{
String msg=in.readLine();
if(msg.equals("bye")) break;
else System.out.println(msg);
}
}
catch(Exception e){}
}
}

class InputScan extends Thread
{
BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
Socket cs=null;
InputScan(Socket s)
{
cs=s;
}
public void run()
{
PrintWriter out=null;
try{
out=new PrintWriter(cs.getOutputStream(),true);
while(true)
{
String msg=stdin.readLine();
out.println(msg);
out.flush();
if(msg.equals("bye")) break;
}
}
catch(Exception e) {}
}
}