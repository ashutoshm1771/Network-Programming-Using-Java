import java.io.*;
import java.net.*;
import java.sql.*;
public class DBServer
{
static Connection con;
static Statement st1,st2;
static ServerSocket ss=null;
static ResultSet rs1;
static Socket s=null;
public static void main(String args[])
{
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse","root","root");
st1=con.createStatement();
System.out.println("Done");
}
catch(Exception e)
{
System.out.println("Error establishing connection:"+e);
}
try
{
ss=new ServerSocket(1090);
System.out.println("Server");
s=ss.accept();
BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
PrintWriter out=new PrintWriter(s.getOutputStream(),true);
out.println("Welcome to DBServer");
while(true)
{
int choice=Integer.parseInt(in.readLine());
String usr=null,pass=null;
int c=0;
switch(choice)
{
case 1: usr=in.readLine();
pass=in.readLine();
c=st1.executeUpdate("insert into userinfo values('"+usr+"','"+pass+"')");
if(c==1)out.println("Data inserted successfully");
break;
case 2: usr=in.readLine();
pass=in.readLine();
System.out.println("user="+usr+"\tpass="+pass);
rs1=st1.executeQuery("select * from userinfo where user='"+usr+"'");
while(rs1.next())
{
c=st1.executeUpdate("update userinfo set pass='"+pass+"' where user='"+usr+"'");
st1.executeQuery("commit");
break;
}
if(c==1)
out.println("password updated for the given username");
else
out.println("update not possible");
break;
case 3: usr=in.readLine();
String res="";
rs1=st1.executeQuery("select * from userinfo where user='"+usr+"'");
while(rs1.next())
{
System.out.println(rs1.getString(1)+" "+rs1.getString(2));
res=res+"\t"+rs1.getString(2);
}
System.out.println("h: "+res);
out.println(res);
break;
case 4: usr=in.readLine();
c=st1.executeUpdate("delete from userinfo where user='"+usr+"'");
if(c>=1) out.println("user information for the following userid "+ usr+" is deleted");
else
out.println("user does not exists");
break;
default: break;
}
}
}
catch(Exception e){}
}
}