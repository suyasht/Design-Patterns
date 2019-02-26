package studentCoursesBackup.util;

/**
 * This class is for the debugging purpose and print statements
 *
 */
public class MyLogger 
{
	
	public static enum debugLevel 
	{ 
		DRIVER, FILE_PROCESSOR, TREE_BUILDER, RESULT
    };
    static debugLevel debugLevel;    
	public  void setDebugValue (int levelIn) 
    {
		switch (levelIn) 
    	{
    		case 4: debugLevel = debugLevel.RESULT; break;
			case 3: debugLevel = debugLevel.TREE_BUILDER; break;
	    	case 2: debugLevel = debugLevel.DRIVER; break;
	    	case 1: debugLevel = debugLevel.FILE_PROCESSOR; break;
	    }
     }
    public static void setDebugValue (debugLevel levelIn) {
    	debugLevel = levelIn;
        }

        public static void writeMessage (String     message  ,
                                         debugLevel levelIn ) {
    	if (levelIn == debugLevel)
    	    System.out.println(message);
        }

        public String toString() 
        {
        	return "The debug level has been set to the following " + debugLevel;
        }
}
