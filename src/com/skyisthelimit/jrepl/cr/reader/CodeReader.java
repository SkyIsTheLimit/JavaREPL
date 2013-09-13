package com.skyisthelimit.jrepl.cr.reader;

/**
 * The most basic abstraction which says that a piece of code is just a class
 * with a package and it's definition. Lets see where this goes!
 * 
 * [TODO] Probably implement a helper which kinda finds out what the package
 * definition is and everything and constructs a <code>CodeReader</code> object
 * based on that. So the API just asks for a java source code in string and the
 * helper does everything else.
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
