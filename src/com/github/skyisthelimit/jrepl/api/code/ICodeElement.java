package com.github.skyisthelimit.jrepl.api.code;

import com.github.skyisthelimit.jrepl.api.code.models.IBlockModel;
import com.github.skyisthelimit.jrepl.api.code.models.IClassModel;
import com.github.skyisthelimit.jrepl.api.code.models.IMethodModel;
import com.github.skyisthelimit.jrepl.api.code.models.IStatementModel;

/**
 * Makes it easier to build up the source code of the entire class by allowing
 * the individual methods, statments, blocks, etc. to build up their own code.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 * @see IClassModel
 * @see IMethodModel
 * @see IBlockModel
 * @see IStatementModel
 */
public interface ICodeElement {
	String getCode();
}
