//Author : Ashutosh Mishra

import java.net.*;
public class InetGetAllByName
{
public static void main(String args[])
{
try{
InetAddress ia[]=InetAddress.getAllByName(args[0]);
for(int i=0;i<ia.length;i++)
{
System.out.println(ia[i]);
System.out.println(ia[i].getHostName());
System.out.println(ia[i].getHostAddress());
}
}
catch(Exception e){
System.out.println(e);
}
}
}
