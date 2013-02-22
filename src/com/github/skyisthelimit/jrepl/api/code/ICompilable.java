package com.github.skyisthelimit.jrepl.api.code;

import com.github.skyisthelimit.jrepl.api.compile.ICompilationResult;
import com.github.skyisthelimit.jrepl.api.compile.ICompiler;
import com.github.skyisthelimit.jrepl.api.execute.IExecutionResult;
import com.github.skyisthelimit.jrepl.api.execute.IExecutor;

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
}
