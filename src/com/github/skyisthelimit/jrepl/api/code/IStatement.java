package com.github.skyisthelimit.jrepl.api.code;

/**
 * This type represents a simple statement in java. A statement in java is any
 * line of code which can be terminated by a semicolon (;)
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface IStatement extends IExecutable, ICompilable {
	String getStatement();
}