//Author : Ashutosh Mishra

import java.net.*;
import java.io.*;
import java.util.*;
class HeadersUsingURLConn
{
public static void main(String args[])
{
try{
URL u=new URL(args[0]);
URLConnection uc=u.openConnection();
/* Display headers*/
System.out.println("Content-type"+uc.getContentType());
System.out.println("Content-encoding"+uc.getContentEncoding());
if(uc.getDate()!=0) System.out.println("Date"+new Date(uc.getDate()));
else System.out.println("Date information not available");
if(uc.getLastModified()!=0)System.out.println("Last Modified:"+new
Date(uc.getLastModified()));
else System.out.println("Last Modified information not available");
if(uc.getExpiration()!=0) System.out.println("Expiration Date:"+new Date(uc.getExpiration()));
else System.out.println("Expiration information not available");
System.out.println("Content-Length:"+uc.getContentLength());
/* Display content of URL */
if(uc.getContentLength()>0)
{
InputStream in=uc.getInputStream();
int c;
while((c=in.read())!=-1)
{
System.out.write(c);
}
}
}
catch(MalformedURLException e){}
catch(IOException ie){}
}
}
