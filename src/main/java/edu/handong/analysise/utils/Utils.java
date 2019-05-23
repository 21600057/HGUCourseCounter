package edu.handong.analysise.utils;

import java.io.*;

public class Utils 
{
	public static ArrayList<String> getLines(String file,boolean removeHeader)
	{
		File csv = new File("hw5data.csv");
		
        BufferedReader br = new BufferedReader(new FileReader(csv));
        String line = "";
        int row = 0 ,i;

        while ((line = br.readLine()) != null) 
        {
            // -1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션
        	String[][] arr = new String[100][100]; 
            String[] token = line.split(",", -1);
            for(i=0 ; i<6 ; i++) 
            {
            	arr[row][i] = token[i];
            }
            
            // CSV에서 읽어 배열에 옮긴 자료 확인하기 위한 출력
            for(i=0 ; i<6 ; i++) 
            {
            	System.out.print(arr[row][i] + ",");
            }
            System.out.println("");
            
            row++;
        }
        br.close();
		//파일을 읽어들이는 부분
	}
	
	public static void writeAFile(ArrayList<String> lines, String targetFileName)
	{
		
	}
}
