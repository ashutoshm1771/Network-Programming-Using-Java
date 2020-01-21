//Author : Ashutosh Mishra
//Lab Systems:: UserName-{User1 Password-User1 && so on upto User15} IPAddress-172.16.13.103

import java.io.*;
import java.net.*;
importjava.util.*;
public class telnet extends Thread
{
static Socket cs=null;
static PrintWriter pw=null;
static BufferedReader br=null,in=null;
public static void main(String args[])throws Exception
{
	System.out.println("TELNET");
	in=new BufferedReader(new InputStreamReader(System.in));
	String command=in.readLine();
	StringTokenizerst=new StringTokenizer(command);
	String service=st.nextToken();
	if(service.equals("open"))
	{
	String address=st.nextToken();
	String port=st.nextToken();
	if(!port.equals("null"))
	open(address,port);
	}
	else if(service.equals("quit"))System.exit(0);
	elseSystem.out.println("invalid,try help");
}

static void open(String address,String port)throws Exception
{
		try
		{
		if(address.equals("null"))
		{
		System.out.println("Specify correct address");
		return;
		}
		System.out.println("Wating for a Connection");
		cs=new Socket(address,Integer.parseInt(port));
		br=new BufferedReader(new InputStreamReader(cs.getInputStream()));
		pw=new PrintWriter(cs.getOutputStream(),true);
		System.out.println("Connection Established");
		new SendData(pw,in).start();
		
		new ReceiveData(br).start();
		
		}catch(Exception e)
		{
			System.out.println("Uable to connect");
		}
	
	}

static class SendData extends telnet
	{
	PrintWriter pw=null;
	BufferedReader in=null;
	SendData(PrintWriter p,BufferedReader b)
	{
	pw=p;
	in=b;
	}
	public void run()
	{
	while(true)
	{
		try
		{
		pw.println(in.readLine());
		}catch(IOException e){}
	}}}

	static class ReceiveData extends telnet
	{
	BufferedReaderbr=null;
	ReceiveData(BufferedReader b)
	{ br=b; }
	public void run()
	{
	while(true)
	{
	try
	{
		System.out.println(br.readLine());
		}catch(IOException e){}
	}}}
}
