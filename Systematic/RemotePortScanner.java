//Author : Ashutosh Mishra

import java.net.*;
class RemotePortScanner1
{
    public static void main(String args[])
    {
        for(int i=1;i<=1024;i++)
        {
            try
            {
            Socket s=new Socket("172.16.4.100",i);
            System.out.println("port active"+i);
            s.close();
            }
            catch(Exception e)
            {
            //System.out.println(e);
            }
        }
    }
}
