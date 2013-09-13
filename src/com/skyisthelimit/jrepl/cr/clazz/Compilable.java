package com.skyisthelimit.jrepl.cr.clazz;

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
	String getCompilableCode();
}
