// Author : Ashutosh Mishra

import java.io.*;
 
public class Src2DestChr {
	public static void main(String args[]){
		
		try {
			
			FileReader fr = 
                         new FileReader(args[0]);
 			FileWriter fw=new FileWriter(args[1]);
			int i;
			
			while((i=fr.read())!=-1){
				fw.write((char)i);
			}
		} catch (Exception e) {
			
		}
	}
}
