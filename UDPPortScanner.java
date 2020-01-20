//Author : Ashutosh Mishra

import java.net.*;
class UDPPortScanner
{
	public static void main(String args[])
	{
		for(int i=1;i<=65535;i++)
		{
			try{
				DatagramSocket s=new DatagramSocket(i);
				s.close();
			}
			catch(BindException e){
				System.out.println("Port active"+i);
			}
			catch(Exception ie){}
		}
	}
}