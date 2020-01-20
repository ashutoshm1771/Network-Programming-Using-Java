//Author : Ashutosh Mishra

import java.net.*;
class GetByName
{
public static void main(String args[])
{
try{
InetAddress ia=InetAddress.getByName(args[0]);
byte[] b1=ia.getAddress();
if((b1[0]& 0x80)==0x00) System.out.println("Class A");
else if((b1[0]& 0xC0)==0x80) System.out.println("Class B");
else if((b1[0]& 0xE0)==0xC0) System.out.println("Class C");
else if((b1[0]& 0xF0)==0xE0) System.out.println("Class D");
else if((b1[0]& 0xF8)==0xF0) System.out.println("Class E");

}
catch(Exception e){
System.out.println(e);
}
}
}
