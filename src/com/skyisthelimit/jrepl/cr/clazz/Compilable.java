package com.skyisthelimit.jrepl.cr.clazz;

/**
 * A simple interface indicating a compilable object and also giving the
 * opportunity to the object to do any house keeping work when it is compiled.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 * @see Executable
 */
public interface Compilable {
	/**
	 * Callback for any house keeping once this object is compiled.
	 */
	void compile();

	/**
	 * The code that will actually be passed to the java compiler. Syntax errors
	 * will be caught in this code.
	 * 
	 * @return The code to be passed to the java compiler for compilation.
	 */
	String getCode();
}
