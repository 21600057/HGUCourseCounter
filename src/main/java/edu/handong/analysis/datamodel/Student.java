package edu.handong.analysis.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Student 
{
	private String studentId;
	private ArrayList<Course> coursesTaken=new ArrayList<Course>();
	private HashMap<String,Integer> semestersByYearAndSemester = new HashMap<String, Integer>();

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
		int currentYear=0, currentSem=0, ct=0, temp=0;
		String key = null;
		HashMap<String, Integer> hashBlackSwan = new HashMap<String,Integer>();
		
		for (int i=0; i<coursesTaken.size(); i++)
		{
			currentYear = coursesTaken.get(i).getYearTaken();
			currentSem = coursesTaken.get(i).getSemesterCourseTaken();
			
			key = Integer.toString(currentYear)+"-"+Integer.toString(currentSem); // 2002-1 이런 키를 String값으로 만들어줌.
			
			if (ct==0)
			{
				hashBlackSwan.put(key,temp); // 임시로 temp 넣어주고 HashMap에 key값을 넣어줌. (ct==0 , 첫번째니깐)
			    ct=1;
			}
			if (ct!=0)
			{
				if (hashBlackSwan.containsKey(key) == false)
					hashBlackSwan.put(key,temp);
			}
			
		}
		int value=1;

		Map<String, Integer> showMeHashSwan = new TreeMap<String, Integer>(hashBlackSwan); // 정렬

		for(String rekey: showMeHashSwan.keySet())
		{
			semestersByYearAndSemester.put(rekey,value++);
			System.out.println(semestersByYearAndSemester.get(rekey));
		}
		return semestersByYearAndSemester;
	}
	
	public int getNumCourseInNthSementer(int semester) // semester 은 들어오는 학기 -> HGUCoursePatternAnalyzer.java 에서 semi임
	{
		int howMuchTaken=0;
		int count=0;
		
		
		for (String keyreset : semestersByYearAndSemester.keySet())
		{
			//count = semestersByYearAndSemester.get
			//if (semester == )
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