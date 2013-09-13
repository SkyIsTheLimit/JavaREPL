package com.skyisthelimit.jrepl.cr.clazz;

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
