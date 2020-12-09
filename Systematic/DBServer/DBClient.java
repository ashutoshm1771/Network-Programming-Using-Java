import java.io.*;
import java.net.*;
public class DBClient
{
static Socket cs=null;
public static void main(String args[]) throws IOException
{
try
{
cs=new Socket("localhost",1090);
}
catch(Exception e)
{
}
System.out.println("Enter the code:");
BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
System.out.println(in.readLine());
String user=null,pass=null;
while(true)
{
System.out.println("Commands: 1.insert, 2. update, 3. select, 4. delete ");
int choice=Integer.parseInt(stdin.readLine());
switch(choice)
{
case 1: System.out.println("Enter username and password to be inserted");
user=stdin.readLine();
pass=stdin.readLine();
out.println("1");
out.println(user);
out.println(pass);
System.out.println(in.readLine());
break;
case 2: System.out.println("Enter username and new password to be update");
user=stdin.readLine();
pass=stdin.readLine();
out.println("2");
out.println(user);
out.println(pass);
System.out.println(in.readLine());
break;
case 3: System.out.println("Enter username whose password is needed");
user=stdin.readLine();
out.println("3");
out.println(user);
System.out.println(in.readLine());
break;
case 4: System.out.println("Enter username for person whose details has to be deleted:");
user=stdin.readLine();
out.println("4");
out.println(user);
System.out.println(in.readLine());
break;
case 5: System.exit(1);
default: break;
}
}
}
}