package com.github.skyisthelimit.jrepl.api.code;

/**
 * This type represents a simple block of code in java. A block in java is a set
 * of statements within parenthesis {}
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface IBlock extends IStatement {
	IStatement[] getStatements();
}
