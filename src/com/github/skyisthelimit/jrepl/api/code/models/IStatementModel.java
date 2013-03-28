package com.github.skyisthelimit.jrepl.api.code.models;

import com.github.skyisthelimit.jrepl.api.code.ICodeElement;

/**
 * This type represents a simple statement in java. A statement in java is any
 * line of code which can be terminated by a semicolon (;)
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface IStatementModel extends ICodeElement {
	/**
	 * Returns the statement string that will be used when this statement is
	 * compiled or executed.
	 * 
	 * @return The statement string to be compiled or executed.
	 */
	String getStatement();
}