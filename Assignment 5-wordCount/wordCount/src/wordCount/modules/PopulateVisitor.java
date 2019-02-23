package wordCount.modules;

import wordCount.treesForStrings.Node;
import wordCount.treesForStrings.TreeMaker;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class PopulateVisitor implements ModuleVisitor{
	
	private FileProcessor input;
	/**
	 * Constructs a PopulateVisitor object. Takes in a string to open an input file.
	 * @param inputFile name of the input file
	 */
	public PopulateVisitor(String inputFile){
		Logger.writeMessage("Constructing a PopulateVisitor...", DebugLevel.CONSTRUCTOR);
		this.input = new FileProcessor(inputFile);
	}
	
	/**
	 * Populates a tree with an input file supplied by the constructor. 
	 * Splits each line taken from the input file into words separated by spaces
	 * @param tree TreeMaker object to be populated
	 */
	public void visit(TreeMaker tree) {
		Logger.writeMessage("Populating tree using visitor...", DebugLevel.POPULATE_VISITOR);
		String line = new String(input.readLine());
		while(line!=null) {
			String[] words = line.split(" ");
			for(int i = 0; i<words.length; i++) {
				if(words[i]!=null && !words[i].equals("")) {
					Node newNode = new Node(words[i]);
					//if(tree.search(newNode)==null)
						tree.insertNode(newNode);
					newNode = null;
				}
			}			
			line = input.readLine();
		}
	}
		
}
