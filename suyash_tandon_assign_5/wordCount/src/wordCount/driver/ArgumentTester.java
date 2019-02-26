package wordCount.driver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArgumentTester {
	private String[] args;
	public ArgumentTester(String[] args) {
		this.args = args;
	}
	/**
	 * Tests arguments for validity
	 */
	public void test() {
		if(args.length!=4 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}")) {
			System.err.println("Incorrect number of arguments.\n4 arguments are required.\nExiting.");
			System.exit(1);
		}
		inputFileTester(args[0]);
		outputFileTester(args[1]);
		numberArgumentTester(args[2]);
		debugValueTester(args[3]);
		
	}
	/**
	 * Tests whether an argument is valid for opening an input file.
	 * @param arg argument to be tested
	 */
	private void inputFileTester(String arg) {
		try {
			FileReader testFile = new FileReader(arg);
			testFile.close();
		}
		catch(IOException e) {
			System.err.println("IOException occured.\n"+arg+" cannot be opened.\nExiting.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Tests whether an argument is valid for opening an output file.
	 * @param arg argument to be tested
	 */
	private void outputFileTester(String arg) {
		try {
			FileWriter testFile = new FileWriter(arg);
			testFile.close();
		}
		catch(IOException e) {
			System.err.println("IOException occured.\n"+arg+" cannot be opened.\nExiting.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	/**
	 * Tests whether an argument can be converted into a positive number.
	 * @param arg argument to be tested
	 */
	private void numberArgumentTester(String arg) {
		try {
			int testValue = Integer.parseInt(arg);
			if(testValue<0) {
				System.err.println("Nubmer argument must be positive. Exiting.");
				System.exit(1);
			}
		}
		catch(NumberFormatException e){
			System.err.println("NumberFormatException occured.\n" + arg+
					" cannot be converted to a number. Exiting.\n");
			e.printStackTrace();
			System.exit(1);
		}
	}
	/**
	 * Tests whether an argument is a valid debug value.
	 * @param arg argument to be tested
	 */
	private void debugValueTester(String arg) {
		try {
			int testValue = Integer.parseInt(arg);
			if(testValue>5 || testValue<0) {
				System.err.println(arg+" is not a legal debug value. Exiting.");
				System.exit(1);
			}
		}
		catch(NumberFormatException e){
			System.err.println("NumberFormatException occured.\n" +arg+
					" cannot be converted to a number. Exiting.\n");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
