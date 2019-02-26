package wordCount.util;

public class Logger {
	public static enum DebugLevel{CONSTRUCTOR, FILE_PROCESSOR, RESULTS, TREE_MAKER,
		POPULATE_VISITOR,BUBBLE_SORT_VISITOR,MAX_HEAP_VISITOR, NONE};
	public static DebugLevel debugLevel;
	
	/**
	 * This is a setter for the debugLevel
	 * @param levelIn the debugLevel to be set as the current debugLevel
	 */
	public static void setDebugLevel(DebugLevel levelIn) {
		debugLevel = levelIn;
	}
	/**
	 * This sets a value passed from the command line to a Debug value
	 * @param levelIn changes the debug level to the number paired to it in the README
	 */
	public static void setDebugValue(int levelIn) {
		switch(levelIn){
		case 1: debugLevel = DebugLevel.CONSTRUCTOR; break;
		case 2: debugLevel = DebugLevel.FILE_PROCESSOR; break;
		case 3: debugLevel = DebugLevel.RESULTS; break;
		case 4: debugLevel = DebugLevel.TREE_MAKER; break;
		case 5: debugLevel = DebugLevel.POPULATE_VISITOR; break;
		default: debugLevel = DebugLevel.NONE; break;
		}
	}
	/**
	 * @param message string to be written to stdout
	 * @param levelIn debugLevel to write the message to
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if(levelIn == debugLevel) {
			System.out.println(message);
		}
	}
	/**
	 * @return the debugLevel of the logger
	 */
	public String toString() {
		return ("The debug level has been set to "+ debugLevel + ".");
	}
}
