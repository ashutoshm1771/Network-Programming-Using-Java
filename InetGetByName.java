import java.net.*;
class InetGetByName
{
public static void main(String args[])
{
try{
InetAddress ia=InetAddress.getByName(args[0]);
System.out.println(ia);
System.out.println(ia.getHostName());
System.out.println(ia.getHostAddress());
}
catch(Exception e)
{System.out.println(e);
}
}
}