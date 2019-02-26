package wordCount.modules;

import wordCount.treesForStrings.TreeMaker;

public interface ModuleVisitor {
	/**
	 * Uses methods from the TreeMaker object to do something based on the discretion of the module.
	 * @param tree TreeMaker object to be visited
	 */
	public void visit(TreeMaker tree);
}
