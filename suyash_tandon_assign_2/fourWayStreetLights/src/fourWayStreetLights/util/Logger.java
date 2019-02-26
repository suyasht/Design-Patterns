package fourWayStreetLights.util;

public class Logger{

 // FIXME: Add more enum values as needed for the assignment
 public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR, RESULTS, HELPER, CONTEXT_CLASS, STATE_ALL_RED, STATE_NORTH_GREEN, STATE_NORTH_RED, STATE_EAST_GREEN, STATE_EAST_RED,
	 STATE_WEST_GREEN,STATE_WEST_RED, STATE_SOUTH_GREEN, STATE_SOUTH_RED
                                };

 private static DebugLevel debugLevel;


 // FIXME: Add switch cases for all the levels
 public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	case 1  : debugLevel = DebugLevel.CONSTRUCTOR; break;
	case 2: debugLevel = DebugLevel.FILE_PROCESSOR; break;
	case 3: debugLevel = DebugLevel.RESULTS; break;
	case 4: debugLevel = DebugLevel.HELPER; break;
	case 5: debugLevel = DebugLevel.CONTEXT_CLASS; break;
	case 6: debugLevel = DebugLevel.STATE_ALL_RED; break;
	case 7: debugLevel = DebugLevel.STATE_NORTH_GREEN; break;
	case 8: debugLevel = DebugLevel.STATE_NORTH_RED; break;
	case 9: debugLevel = DebugLevel.STATE_EAST_GREEN; break;
	case 10: debugLevel = DebugLevel.STATE_EAST_RED; break;
	case 11: debugLevel = DebugLevel.STATE_WEST_GREEN; break;
	case 12: debugLevel = DebugLevel.STATE_WEST_RED; break;
	case 13: debugLevel = DebugLevel.STATE_SOUTH_GREEN; break;
	case 14: debugLevel = DebugLevel.STATE_SOUTH_RED; break;
	//default: debugLevel = DebugLevel.NONE; break;
	}
 }

 public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
 }

 public static void writeMessage (String     message  ,
                                  DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
 }

 public String toString() {
	return "The debug level has been set to the following " + debugLevel;
 }
}
