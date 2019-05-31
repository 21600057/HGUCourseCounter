package edu.handong.analysis.datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class Student 
{
	private String studentId;
	private ArrayList<Course> coursesTaken=new ArrayList<Course>();
	private HashMap<String,Integer> semestersByYearAndSemester;

	public Student(String studentId)
	{
		this.studentId = studentId;
	}
	
	public void addCourse(Course newRecord)
	{
		coursesTaken.add(newRecord);
	}
	
	public HashMap<String,Integer> getSemestersByYearAndSemester()
	{
		int currentYear=0,currentSem=0, ct=0, temp=0;
		String key = null;
		HashMap<String, Integer> hashBlackSwan = new HashMap<String,Integer>();
		
		for (int i=0; i<coursesTaken.size(); i++)
		{
			currentYear = coursesTaken.get(i).getYearTaken();
			currentSem = coursesTaken.get(i).getSemesterCourseTaken();
			key = Integer.toString(currentYear)+"-"+Integer.toString(currentSem); // 2002-1 이런 키를 String값으로 만들어줌.
			
			if (ct==0)
			{
				hashBlackSwan.put(key,temp); // 임시로 Integer 값을 temp로 넣어주고 HashMap에 key값을 넣어줌. (ct==0 , 첫번째니깐)
				ct=1;
			}
			else
			{
				
			}
		}
		
		return hashBlackSwan;
	}
	
	public int getNumCourseInNthSementer(int semester) // semester 은 들어오는 학기 -> HGUCoursePatternAnalyzer.java 에서 semi임
	{
		int howMuchTaken=0;
		int count=0;
		
		for (int i=0; i<coursesTaken.size();i++)
		{
			
		}
		
		
		return count;		
	}
	
	public ArrayList<Course> getCourse()
	{
		return coursesTaken;
	}
	public String getStudentId()
	{
		return studentId;
	}
	
}