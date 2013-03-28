package com.github.skyisthelimit.jrepl.api.code.compile;

import com.github.skyisthelimit.jrepl.api.code.execute.IExecutable;
import com.github.skyisthelimit.jrepl.api.code.execute.IExecutionResult;
import com.github.skyisthelimit.jrepl.api.code.execute.IExecutor;

/**
 * Represents an entity which can be compiled. This would be the source code
 * elements.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 * @see IExecutable
 * @see ICompiler
 * @see IExecutor
 * @see ICompilationResult
 * @see IExecutionResult
 */

public interface ICompilable {
	ICompilable compile();

	boolean isCompiled();

	ICompilationResult getCompilationResult();

	String getCompilableCode();

	String getQualifiedName();

	String[] getQualifiedNames();
}
