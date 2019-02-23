package wordCount.util;

public interface FileDisplayInterface {
	/**
	 * This writes a string to a file opened by a class.
	 * @param s the string to be written to a file
	 */
	public void writeToFile(String s);
	/**
	 * Closes the output file.
	 */
	public void close();
}
