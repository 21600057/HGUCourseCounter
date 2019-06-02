package edu.handong.analysise.utils;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

//import org.apache.commons.math3.geometry.euclidean.twod.Line;

public class Utils 
{
	public static ArrayList<String> getLines(String file,boolean removeHeader)
	{
		ArrayList<String> Line = new ArrayList<String>();
		try
		{
			Scanner fileIn = new Scanner(new File(file));
			String temp;
			
			while(true)
			{
				if (fileIn.hasNextLine() == false)
					break;
				temp = fileIn.nextLine();
				
				if (removeHeader == true)
				{
					removeHeader = false;
					continue;
				}
				
				Line.add(temp);			
			} // while end;
			
		} catch(FileNotFoundException e)
		{
			System.out.println("The file path does not exist. Please check your CLI argument!");
		}
		return Line;
	}

	public static void writeAFile(ArrayList<String> lines, String targetFileName)
	{
		PrintWriter fileOut = null;
		
		try
		{
			fileOut = new PrintWriter(targetFileName);
		} catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file" + targetFileName);
			System.exit(0);
		}
		for (int i=0; i<lines.size(); i++)
		{
			fileOut.println(lines.get(i));
		}
		fileOut.close();
	}
}
