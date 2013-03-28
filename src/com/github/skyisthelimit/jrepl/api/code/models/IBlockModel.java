package com.github.skyisthelimit.jrepl.api.code.models;

import com.github.skyisthelimit.jrepl.api.code.ICodeElement;

/**
 * This type represents a simple block of code in java. A block in java is a set
 * of statements within parenthesis {}
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface IBlockModel extends ICodeElement {
	/**
	 * Returns the collection of statements within the block. A block in java is
	 * ideally a collection of statements within paranthesis.
	 * 
	 * @return The number of statements within the block.
	 */
	IStatementModel[] getStatements();

	IBlockModel[] getBlocks();

	IClassModel[] getClasses();
}
