package wordCount.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import wordCount.util.Logger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	private FileWriter writer;
	private Vector<String> testResults;
	/**
	 * Default constructor for Results. This object is used to output to files or stdout
	 */
	public Results() {
		Logger.writeMessage("Contructing a Results object.", DebugLevel.CONSTRUCTOR);
		testResults = new Vector<String>();
	}
	/**
	 * This constructs an object used to output to files or stdout
	 * @param fileName name of the output file
	 */
	public Results(String fileName) {
		Logger.writeMessage("Contructing a Results object.", DebugLevel.CONSTRUCTOR);
		try {
			writer = new FileWriter(fileName);
			testResults = new Vector<String>();
		} catch (IOException e) {
			System.err.println("IOException occured in constructor. Exiting.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	/**
	 * This stores the result of a test from another class into a vector
	 * @param testResult a result of a test in another class
	 */
	public void storeTestResult(String testResult) {
		testResults.add(testResult);
	}
	/* (non-Javadoc)
	 * @see fourWayStreetLights.util.StdoutDisplayInterface#writetoStdout(java.lang.String)
	 */
	@Override
	public void writetoStdout(String s) {
		System.out.println(s);
	}

	/* (non-Javadoc)
	 * @see fourWayStreetLights.util.FileDisplayInterface#writeToFile(java.lang.String)
	 */
	@Override
	public void writeToFile(String s) {
		Logger.writeMessage("Attempting to writeToFile().", DebugLevel.RESULTS);
		try {
			writer.append(s);
		}
		catch(IOException e) {
			System.err.println("IOException occurred in writeToFile(). Exiting.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/* (non-Javadoc)
	 * @see fourWayStreetLights.util.FileDisplayInterface#close()
	 */
	public void close() {
		Logger.writeMessage("Attempting to close().", DebugLevel.RESULTS);
		try {
			writer.close();
		} catch (IOException e) {
			System.err.print("IOException occured in close(). Exiting");
			e.printStackTrace();
			System.exit(1);
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String finalString = new String("");
		for(int i=0; i<testResults.size(); i++) {
			finalString+=(testResults.get(i)+"\n");
		}
		finalString.trim();
		return finalString;
	}
}
