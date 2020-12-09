import java.net.*;
import java.io.*;
public class ActivePortScanner
{
    public static void main(String[] args)
    {
        System.out.println("******active port*******");
        for(int i=1;i<65535;i++)
        {
            try
            {
                ServerSocket ss=new ServerSocket(i);
            }
            catch(BindException e)
            {
                System.err.println("Port Active"+i);
            }
            catch(IOException e)
            { }
        }
    }
}