//Author : Ashutosh Mishra

import java.io.*; 
class Src2DestFile 
{ 
    public static void main(String args[]) 
    throws FileNotFoundException,IOException 
    { 
        
        FileInputStream fis = new FileInputStream(args[0]); 
  
        
        FileOutputStream fos = new FileOutputStream(args[1]); 
  
        int b; 
        while  ((b=fis.read()) != -1) 
            fos.write(b); 

        fis.close(); 
        fos.close(); 
    } 
}
