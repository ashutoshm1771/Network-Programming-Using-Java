import java.io.*;
import java.net.*;
public class SimpleFileServer_Lines
{
public static void main(String args[]) throws Exception
{
try
{
ServerSocket ss=new ServerSocket(1334);
Socket s=ss.accept();
DataInputStream in=new DataInputStream(s.getInputStream());
PrintWriter out=new PrintWriter(s.getOutputStream(),true);
String str="D:\\2019_2020 NP LAB\\Source\\";
int x=0;
str=str+in.readUTF();
File f=new File(str);
if(f.exists())
{
out.write(x); // Indication that file exists
FileInputStream fin=new FileInputStream(str);
DataInputStream fin1 = new DataInputStream(fin);
String i;
do
{
i=fin1.readLine();
if(i!= null){
out.println(i);
}
}while(i!=null);
System.out.println("File transfered Successfully...");
}
else
System.out.println("File not found...");
}
catch(Exception e){}
}
}