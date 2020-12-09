import java.io.*;
import java.net.*;
public class SimpleFileClient_Lines
{
public static void main(String args[])
{
int x=1;
String i;
String str="D:\\2019_2020 NP LAB\\Destination\\";
String str1;
try
{
Socket s=new Socket("localhost",1334);
DataInputStream in=new DataInputStream(s.getInputStream());
DataOutputStream out=new DataOutputStream(s.getOutputStream());
BufferedReader br=new BufferedReader(new
InputStreamReader(System.in));
System.out.println("enter file");
str1=br.readLine();
out.writeUTF(str1);
x=in.read();
if(x==0)
{
str=str+str1;
FileOutputStream fout=new FileOutputStream(str);
PrintWriter d = new PrintWriter(fout,true);
do{
i=in.readLine();
System.out.println(i);
if(i!=null){
d.println(i);
}
}while(i!=null);
d.close();
}
}
catch(Exception e){}
if(x!=0) System.out.println("File not found...");
else System.out.println("File File received successfully");
}
}