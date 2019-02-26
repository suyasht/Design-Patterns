package wordCount.driver;

import wordCount.modules.ModuleVisitor;
import wordCount.modules.OperationsVisitor;
import wordCount.modules.PopulateVisitor;
import wordCount.treesForStrings.TreeMaker;
import wordCount.util.FileDisplayInterface;
import wordCount.util.Results;
import wordCount.util.StdoutDisplayInterface;

public class Driver {

	public static void main(String[] args) {
		ArgumentTester tester = new ArgumentTester(args);
		tester.test();
		final int NUM_ITERATIONS = Integer.parseInt(args[2]); //store the number of iterations
		StdoutDisplayInterface timeOutput = new Results();
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < NUM_ITERATIONS; i++) {
			FileDisplayInterface result = new Results(args[1]); //will be used to store the results of the second module
			TreeMaker tree = new TreeMaker();
			ModuleVisitor module = new PopulateVisitor(args[0]); //module used to populate the tree
			tree.accept(module);
			module = new OperationsVisitor((Results)result); //make "module" into an OperationsVisitor
			tree.accept(module); //run the visit method in the visitor
			result.writeToFile(result.toString()); //write the result gotten from the visitor
			result.close();
		}
		
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime-startTime)/NUM_ITERATIONS;
		timeOutput.writetoStdout("Time taken: "+totalTime+" milliseconds.");
	}

}
