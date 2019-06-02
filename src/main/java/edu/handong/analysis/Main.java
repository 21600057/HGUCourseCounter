package edu.handong.analysis;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import java.io.File;

public class Main 
{
	static String inputPath;
	static String outputPath;
	static String startYear, endYear;
	static String courseCode;
	boolean help;
	String addOptionCk;
	
	public static void main(String[] args) 
	{
		Main main = new Main();
		main.run(args);
		
	}
	
	public void run(String[] args)
	{
		
		Options options = createOptions();
	
		if(parseOptions(options, args))
		{
			if (help)
			{
				printHelp(options);
				return;
			}
			
			if (addOptionCk == "1")
			{
				String[] runargs = {inputPath, outputPath, addOptionCk, courseCode, startYear, endYear};
				HGUCoursePatternAnalyzer analyzer = new HGUCoursePatternAnalyzer();
				analyzer.run(runargs);
			}
			if (addOptionCk == "2")
			{
				
			}
		}	
	}
		
	private boolean parseOptions(Options options, String[] args) 
	{
		CommandLineParser parser = new DefaultParser();

		try 
		{

			CommandLine cmd = parser.parse(options, args);

			inputPath = cmd.getOptionValue("i");
			outputPath = cmd.getOptionValue("o");
			addOptionCk = cmd.getOptionValue("a");
			help = cmd.hasOption("h");
			startYear = cmd.getOptionValue("s");
			endYear = cmd.getOptionValue("e");
			courseCode = cmd.getOptionValue("c");
			
		} catch (Exception e) 
		
		{
			printHelp(options);
			return false;
		}

		return true;
	}

	
	public Options createOptions() 
	{
		Options options = new Options();
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path")
				.hasArg()
				.argName("Input path")
				.required()
				.build());		

		// add options by using OptionBuilder
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path")
				.hasArg()
				.argName("Output path")
				.required()
				.build());		

		// add options by using OptionBuilder
		options.addOption(Option.builder("a").longOpt("analysis")
			    .desc("1: Count courses per semester, 2: Count per course name and year")
				.hasArg()
				.argName("Analysis option")	
				.required()
				.build());		

		// add options by using OptionBuilder
		options.addOption(Option.builder("c").longOpt("coursecode")
			    .desc("Course code for '-a 2' option")
				.hasArg()
				.argName("course code")	
				//.required() // only for '-a 2'
				.build());	
			
		// add options by using OptionBuilder
		options.addOption(Option.builder("s").longOpt("startyear")
				.desc("Set the start year for analysis e.g., -s 2002")
				.hasArg()
				.argName("Start year for analysis")	
				.required()
				.build());	

		// add options by using OptionBuilder
		options.addOption(Option.builder("e").longOpt("endyear")
				.desc("Set the end year for analysis e.g., -e 2005")
				.hasArg()
				.argName("End year for analysis")	
				.required()
				.build());	
					
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Show a Help page")
				.argName("Help")	
		        .build());
		
		return options;
	}
	
	private void printHelp(Options options) 
	{
		HelpFormatter formatter = new HelpFormatter();
		String header = "HGU Course Analyzer";
		String footer ="";
		formatter.printHelp("HGUCourseCounter", header, options, footer, true);
	}
	
}