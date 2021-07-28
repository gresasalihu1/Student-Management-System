package application.Controllers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ClassForLanguage {
	static String mergo="";
	public String getLanguage() throws IOException{
		
		File file=new File("forlang.txt");
		String ss="";
		try
		{
			Scanner scanner=new Scanner(file);
			while(scanner.hasNext())
			{
				ss+=scanner.nextLine();
			}
			//Linda
			//Rregullohet nese e mbyllim skanerin
		} 
		catch (Exception e)
		{
			//System.out.println(e.getMessage());
		}
		return ss;
	}

	
}
