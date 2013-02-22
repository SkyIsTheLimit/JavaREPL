package com.github.skyisthelimit.jrepl.api.execute;

import com.github.skyisthelimit.jrepl.api.code.IExecutable;

/**
 * Represents the run time.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface IExecutor {
	IExecutionResult execute(IExecutable executable);
}
