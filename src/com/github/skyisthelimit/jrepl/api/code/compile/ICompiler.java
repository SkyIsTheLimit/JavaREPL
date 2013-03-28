package com.github.skyisthelimit.jrepl.api.code.compile;


/**
 * Represents the compiler. Has features to pass in parameters, etc. to the
 * compiler.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface ICompiler {
	/**
	 * Compiles the compilable object and returns the compilation results.
	 * 
	 * @param compilable
	 *            An object which can be compiled.
	 * @return The compilation result.
	 * 
	 * @see ICompilable
	 */
	ICompilationResult compile(ICompilable compilable);

	/**
	 * Returns the options passed to the compiler.
	 * 
	 * @return The options passed to the compiler.
	 */
	String[] getOptions();
}