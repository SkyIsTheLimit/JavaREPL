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
 * @see Helper
 */
public interface CodeReader {
	/**
	 * Get the protocol of the data source.
	 * 
	 * @return Returns the protocol of the data source.
	 */
	String getProtocol();

	/**
	 * Get the fully qualified type name for the class.
	 * 
	 * @return Returns the fully qualified type name for the class.
	 */
	String getFullyQualifiedName();

	/**
	 * Get the complete compilable source code.
	 * 
	 * @return Returns the complete compilable source code.
	 */
	String getCode();
}
