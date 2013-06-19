package com.skyisthelimit.jrepl.compiler;

/**
 * The most basic abstraction which says that a piece of code is just a class
 * with a package and it's definition. Lets see where this goes!
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface CodeReader {
	String getProtocol();

	String getFullyQualifiedName();

	String getCode();
}
