import java.io.*;
import java.net.*;
import java.util.*;
public class HttpClient
{
static Socket cs=null;
public static void main(String args[]) throws Exception
{
Socket cs=new Socket("",1080);
System.out.println("connected to http server");
BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
PrintWriter pw=new PrintWriter(cs.getOutputStream(),true);
BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
int choice,count;
do
{
System.out.println("commands");
System.out.println("1.Head,2.Post,3.Get,4.Delete,5.Exit");
System.out.println("enter your choice");
choice=Integer.parseInt(stdin.readLine());
byte line[]=null;
String str;
System.out.println(choice);
switch(choice)
{
case 1:pw.println("1");
       System.out.println("enter filename to get the header");
       str=stdin.readLine();
       pw.println(str);
       System.out.println("file:"+in.readLine()+""+in.readLine()+""+in.readLine());
       break;
case 2:pw.println("2");
       System.out.println("enter the text to post");
       str=stdin.readLine();
       pw.println(str);
       break;
case 3:pw.println("3");
       System.out.println("enter the file");
       str=stdin.readLine();
       pw.println(str);
       System.out.println("enter filename to be saved");
       str=stdin.readLine();
       FileOutputStream fos=new FileOutputStream(str);
       while(true)
       {
       String s=in.readLine();
       if(s.equals("********")) break;
       else count=s.length();
       if(count<1024) line=new byte[count];
       else line=new byte[1024];
       line=s.getBytes();
       fos.write(line);
       }
       fos.close();
       break;
case 4:pw.println("4");
       System.out.println("enter filename to be deleted");
       str=stdin.readLine();
       pw.println(str);
       break;
default:pw.println("5");
        System.exit(0);
        break;
}
}while(choice>=1 && choice<=4); }}