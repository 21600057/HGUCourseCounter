package edu.handong.analysise.utils;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Utils 
{
	public static ArrayList<String> getLines(String file,boolean removeHeader)
	{
		ArrayList<String> Line = new ArrayList<String>();
		try
		{
			Scanner in = new Scanner(new File(file));
			String temp;
			
			while(true)
			{
				if (in.hasNextLine() == false)
					break;
				temp = in.nextLine();
				
				if (removeHeader == true)
				{
					removeHeader = false;
					continue;
				}
				
				Line.add(temp);			
			} // while end;
			
		} catch(Exception e)
		{
			System.out.println("Plz re input file name");
		}
		return Line;
	}

	public static void writeAFile(ArrayList<String> lines, String targetFileName)
	{
		
	}
}
