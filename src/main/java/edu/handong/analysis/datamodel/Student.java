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
		HashMap<String, Integer> hashBlackSwan = new HashMap<String,Integer>();
		
		
		return semestersByYearAndSemester;
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