package wordCount.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import wordCount.util.Logger.DebugLevel;

public class FileProcessor {
		private BufferedReader buff;
		/**
		 * This constructs a FileProcessor used to read from files.
		 * @param fileName filename of the input file
		 */
		public FileProcessor(String fileName) {
			Logger.writeMessage("Constructing a FileProcessor.", DebugLevel.CONSTRUCTOR);
			try {
				buff = new BufferedReader(new FileReader(new File(fileName)));
			}
			catch(FileNotFoundException e) {
				System.err.println("FileNotFoundException occured in constructor. Exiting.");
				e.printStackTrace();
				System.exit(1);
			}
		}
		/**
		 * This reads a line from the file opened in the constructor
		 * @return line from the file opened in the constructor. Returns null if at the end of the file
		 */
		public String readLine() {
			Logger.writeMessage("Attempting to readLine().", DebugLevel.FILE_PROCESSOR);
			String line = new String();
			try {
				line = buff.readLine();
				return line;
			}
			catch(IOException e) {
				System.err.println("IOException occured during readLine(). Exiting.");
				e.printStackTrace();
				System.exit(1);
			}
			return null;
		}
		/**
		 * This method returns an integer read from an input file. The number returned will be 
		 * -32768 if the next line taken from the input file is null.
		 * @return integer read from an input file passed by the constructor
		 */
		public int nextInt() {
			int num = -32768;
			try {
				String line = readLine();
				if(line!=null)
					num = Integer.parseInt(line);
				//might need a condition for when readLine() returns null
			}
			catch(NumberFormatException e) {
				System.err.println("Line cannot be converted to a number. Exiting.");
				e.printStackTrace();
				System.exit(1);
			}
			return num;
		}
		/**
		 * This closes the file opened in the constructor.
		 */
		public void close() {
			Logger.writeMessage("Attempting to close().", DebugLevel.FILE_PROCESSOR);
			try {
				buff.close();
			} catch (IOException e) {
				System.err.println("IOException occured during close(). Exiting.");
				e.printStackTrace();
				System.exit(1);
			}
		}
}

