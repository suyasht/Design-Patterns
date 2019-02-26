package wordCount.modules;

import wordCount.treesForStrings.TreeMaker;
import wordCount.util.Results;

public class OperationsVisitor implements ModuleVisitor{
	private Results result;
	public OperationsVisitor(Results result) {
		this.result = result;
	}
	
	public void visit(TreeMaker tree) {
		int numberOfWords = tree.numberOfWords();
		result.storeTestResult("Number of words in the file: "+numberOfWords);
		int numberOfCharacters = tree.numberOfCharacters();
		result.storeTestResult("Number of characters in the file: "+numberOfCharacters);
		int distinctCount= tree.numberOfDistinct();
		result.storeTestResult("Number of Distinct words in the file: "+distinctCount);
	}
	
}
