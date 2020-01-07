import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;
class pop
{
public static void main(String args[])throws Exception
{
	Socket s=null;
	try
	{
	s=new Socket("172.16.13.195",110);
	System.out.println("Connected to pop server");
	
	}
	catch(Exception e)
	{}
	PrintWriter out=new PrintWriter(s.getOutputStream(),true);
	BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
	BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
	System.out.println(in.readLine());
	System.out.println("Enter ur maid id");
	String sid=sin.readLine().trim();
	System.out.println(sid);
	out.println("user "+sid);
	System.out.println(in.readLine());
	System.out.println("Enter ur Password");
	String pwd=sin.readLine().trim();
	out.println("pass "+pwd);
	System.out.println(in.readLine());
	System.out.println("Mail in INBOX");
	out.println("list");
	String str;
	while((str=in.readLine())!=null)
	{
		if(!str.startsWith("."))
		System.out.println(str);
		else
		break;	
	}
	System.out.println("Enter mail No");
	String mailno=sin.readLine();
	out.println("retr "+mailno);
	System.out.println(in.readLine());
	while((str=in.readLine())!=null)
	{
	 if(!str.startsWith("."))
		System.out.println(str);
	else
	break;
	}System.out.println();
}
}