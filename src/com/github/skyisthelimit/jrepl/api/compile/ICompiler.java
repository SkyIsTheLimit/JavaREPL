package com.github.skyisthelimit.jrepl.api.compile;

import com.github.skyisthelimit.jrepl.api.code.ICompilable;

/**
 * Represents the compiler. Has features to pass in parameters, etc. to the
 * compiler.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface ICompiler {
	ICompilationResult compile(ICompilable compilable);

	String[] getOptions();
}