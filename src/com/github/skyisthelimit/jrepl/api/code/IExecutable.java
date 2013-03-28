package com.github.skyisthelimit.jrepl.api.code;

import com.github.skyisthelimit.jrepl.api.code.compile.ICompilationResult;
import com.github.skyisthelimit.jrepl.api.code.compile.ICompiler;
import com.github.skyisthelimit.jrepl.api.code.execute.IExecutionResult;
import com.github.skyisthelimit.jrepl.api.code.execute.IExecutor;

/**
 * Represents an entity which can be executed. This would be the source code
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
public interface IExecutable {
	IExecutable execute();
}
