import java.io.*;
import java.net.*;
public class MTTWServer extends Thread
{
static ServerSocket ss;
static Socket cs=null;
public static void main(String args[])
{
BufferedReader in=null;
InputScan1 is=null;
try{
ss=new ServerSocket(4000);
cs=ss.accept();
is=new InputScan1(cs);
is.setDaemon(true);
is.start();
in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
String msg=null;
while(true)
{
msg=in.readLine();
if(msg.equals("bye"))
break;
else System.out.println(msg);
}
}
catch(Exception e){}
}
}
class InputScan1 extends Thread
{
Socket mySocket;
PrintWriter pw;
InputScan1(Socket s)
{
mySocket=s;
}
public void run()
{
try{
BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
pw=new PrintWriter(mySocket.getOutputStream(),true);
while(true)
{
String msg=stdin.readLine();
pw.println(msg);
pw.flush();
if(msg.equals("bye"))
break;
}
}
catch(IOException ex)
{}
}
}