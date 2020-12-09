// Author : Ashutosh Mishra

import java.io.*;
import java.net.*;
import java.util.*;
public class HttpServer extends Thread
{
  static ServerSocket ss=null;
  static Socket s;
  static int i;
  public static void main(String args[])
  {
   try
   {
     ss=new ServerSocket(1080);
     while(true)
     {
       s=ss.accept();
       i++;
       System.out.println("Connected to client"+i);
       new clientThread(s,i).start();
     }
   }
     catch(Exception e)
     {
       System.out.println(e.getMessage());
     }
  }
 }
 class clientThread extends HttpServer
 {
    Socket cs;
    int clientNo;
    public clientThread(Socket c,int i)
    {
       cs=c;
       clientNo=i;
     }
      public void run()
      {
         try
         {
           BufferedReader br=new BufferedReader(new InputStreamReader(cs.getInputStream()));
           PrintWriter pw=new PrintWriter(cs.getOutputStream(),true);
           String s=null;
           while(true)
           {
             s=br.readLine();
             System.out.println(s);
             int command=Integer.parseInt(s);
             File f;
             String str;
             byte line[]=null;
             switch(command)
             {
               case 1: System.out.println("Head");
                        str=br.readLine();
                        f=new File(str);
                        int index=str.lastIndexOf(".");
                        pw.println(str);
                        pw.println(" Type : " + str.substring(index+1));
                        pw.println(" Length : " +f.length());
Date d=new Date();
int j=d.getDay();
int status=0;
String day=" ";
for(int i=1;i<=7;i++)
{
   if(j==i)
{
 status=i; 
break;
}
}
if(status==1) day = "Monday";
else if(status==2) day="Tuesday";
else if(status==2) day="Wednesday";
else if(status==2) day="Thursday";
else if(status==2) day="Friday";
else if(status==2) day="Saturday";
else if(status==2) day="Sunay";
System.out.println(day+","+d.getDate()+" | "+(d.getMonth()+1)+" | "+(d.getYear()-100)+" "+(d.getHours()-12)+":"+d.getMinutes()+":"+d.getSeconds());









                        break;
               case 2:  System.out.println("Post");
						 str=br.readLine();
						 System.out.println("Message posted from Client"+clientNo+":");
						 System.out.println(str);
						 break;
			   case 3: System.out.println("get");
			            str=br.readLine();
			            FileInputStream fis=new FileInputStream(str);
			            while(fis.available()!=0)
	               {
			            if(fis.available()<1024)
			            line=new byte[fis.available()];
			            else
			            line=new byte[1024];
			            fis.read(line);
			            str=new String(line);
			            pw.println(str);
			       }
			             pw.println("********");
			             System.out.println("File sent Successfully");
			             fis.close();
			             break;
			   case 4:  System.out.println("Delete");
			             str=br.readLine();
			             f=new File(str);
			             f.delete();
			             break;
			  default: System.out.println("Exiting");
			            break;
	        }
          }
	 }
catch( Exception e)
{
   System.out.println(e.getMessage());
}
  }
  }
