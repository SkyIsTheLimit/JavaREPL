package com.skyisthelimit.jrepl.cr.clazz;

/**
 * A simple interface indicating an executable object and also giving the
 * opportunity to the object to do any house keeping work when it is executed.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 * @see Compilable
 */
public interface Executable {
	/**
	 * Callback for any house keeping once this object is executed.
	 */
	void execute();

	/**
	 * Just for the ability to be able to see the code when required.
	 * 
	 * @return The code that was already executed or will be executed by the
	 *         class.
	 */
	String getExecutableContents();
}
