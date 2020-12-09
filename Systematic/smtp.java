//Author : Ashutosh Mishra

import java.io.*;
import java.net.*;
import java.util.*;

public class smtp
{
public static void main(String args[])throws Exception
{
	Socket s=null;
	try
	{
	s=new Socket("172.16.13.195",25);
	System.out.println("Connected to smtp server");
	
	}
	catch(Exception e)
	{}
	PrintWriter out=new PrintWriter(s.getOutputStream(),true);
	BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
	BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
	in.readLine();
	out.println("helo");
	in.readLine();
	System.out.println("Enter ur maid id");
	String sid=sin.readLine().trim();
	out.println("mail from:"+sid);
	System.out.println(in.readLine());
	System.out.println("Enter receiver id");
	String rid=sin.readLine().trim();
	out.println("rcpt to:"+rid);
	System.out.println(in.readLine());
	System.out.println("Enter ur Message to send");
	String msg=sin.readLine().trim();
	out.println("data");
	in.readLine();
	out.println(msg);
	out.println(".");
	System.out.println(in.readLine());
	System.out.println("mail sent");
}
}
