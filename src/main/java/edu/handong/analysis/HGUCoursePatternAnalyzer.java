package edu.handong.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import edu.handong.analysise.utils.NotEnoughArgumentException;
import edu.handong.analysise.utils.Utils;

public class HGUCoursePatternAnalyzer
{
 
	private HashMap<String,Student> students;
	
	/**
	 * This method runs our analysis logic to save the number courses taken by each student per semester in a result file.
	 * Run method must not be changed!!
	 * @param args
	 */
	public void run(String[] args) 
	{
		
		try 
		{
			// when there are not enough arguments from CLI, it throws the NotEnoughArgmentException which must be defined by you.
			if(args.length<2)
				throw new NotEnoughArgumentException();
		} catch (NotEnoughArgumentException e) 
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		String dataPath = args[0]; // csv file to be analyzed
		String resultPath = args[1]; // the file path where the results are saved.
		ArrayList<String> lines = Utils.getLines(dataPath, true);
	

		students = loadStudentCourseRecords(lines);
		
		// To sort HashMap entries by key values so that we can save the results by student ids in ascending order.
		Map<String, Student> sortedStudents = new TreeMap<String,Student>(students); 
		
		// Generate result lines to be saved.
		ArrayList<String> linesToBeSaved = countNumberOfCoursesTakenInEachSemester(sortedStudents);
		
		// Write a file (named like the value of resultPath) with linesTobeSaved.
		Utils.writeAFile(linesToBeSaved, resultPath);
	}

	
	
	
	/**
	 * This method create HashMap<String,Student> from the data csv file. Key is a student id and the corresponding object is an instance of Student.
	 * The Student instance have all the Course instances taken by the student.
	 * @param lines
	 * @return
	 */
	private HashMap<String,Student> loadStudentCourseRecords(ArrayList<String> lines) 
	{
		int a=0,ct=0,gumsact=0;
		String gumsa = null;
		ArrayList<Course> course = new ArrayList<Course>();
		HashMap<String,Student> hashswan = new HashMap<String,Student>();
		ArrayList<String> newArray = new ArrayList<String>();
		
		
		for (String s : lines)
		{
			course.add(new Course(s));
		} // 일단 코스에 다 들여보내줬음
		
		for (a=0; a<course.size(); a++)
		{
			if (newArray.contains(course.get(a).getStudentId()) == false)
				newArray.add(course.get(a).getStudentId());
		} // newArray에 학번 다들어갔음 && hashswan 에 넣을거임
		
		int w=0;
		
		for (int j=0; j<newArray.size();j++)
		{
			Student student= new Student(newArray.get(j));
			//System.out.println(student.getStudentId());
			ArrayList<Course> correct = new ArrayList<Course>();
			//for (a=0; a<course.size(); a++)
			//{
				for (String s : lines)
				{
					 if(student.getStudentId().equals(s.split(",")[0].trim()))
			           {
			              correct.add(new Course(s));
			           }
				}
				
				for (int i=0; i<correct.size();i++)
				{
					student.addCourse(correct.get(i));
				}
			//}
			hashswan.put(student.getStudentId(),student);
		}
		
//		System.out.println(hashswan.get("0253").getCourse().get(1).getCourseName());
		return hashswan;
		
	}
	/**
	 * This method generate the number of courses taken by a student in each semester. The result file look like this:
	 * StudentID, TotalNumberOfSemestersRegistered, Semester, NumCoursesTakenInTheSemester
	 * 0001,14,1,9
     * 0001,14,2,8
	 * ....
	 * 
	 * 0001,14,1,9 => this means, 0001 student registered 14 semeters in total. In the first semeter (1), the student took 9 courses.
	 * 
	 * 
	 * @param sortedStudents
	 * @return
	 */
	private ArrayList<String> countNumberOfCoursesTakenInEachSemester(Map<String, Student> sortedStudents)
	{
		String addString = null;
		ArrayList<String> kiJaRu = new ArrayList<String>();
		kiJaRu.add("StudentID, TotalNumberOfSemestersRegistered, Semester, NumCoursesTakenInTheSemester"); // 첫라인 add
		
		for (String num : sortedStudents.keySet()) // 0001 ~ 0253 까지의 학번
		{
			int semCheck=0;
			Student student = sortedStudents.get(num); // 학번별 value값을 가져옴
			
			Map<String, Integer> sortedHashSwan = new TreeMap<String, Integer>(student.getSemestersByYearAndSemester());
			
			for (String key : sortedHashSwan.keySet())
			{
				if (semCheck < sortedHashSwan.get(key).intValue())
				 semCheck = sortedHashSwan.get(key).intValue(); // 제일 큰게 마지막학기
			}
			
			for (int semi=1; semi<=semCheck; semi++)
			{
				addString = student.getCourse().get(0).getStudentId()+","+semCheck+","+semi+","+student.getNumCourseInNthSementer(semi);
				kiJaRu.add(addString);			
			}
			
			
		}
		for (String showPrint : kiJaRu)
		{
			System.out.println(showPrint);
		}
		
		
		return kiJaRu;
	}

}
