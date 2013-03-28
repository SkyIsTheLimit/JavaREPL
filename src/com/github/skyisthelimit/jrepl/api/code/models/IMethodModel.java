package com.github.skyisthelimit.jrepl.api.code.models;

import com.github.skyisthelimit.jrepl.api.code.IAccessible;
import com.github.skyisthelimit.jrepl.api.code.ICodeElement;

public interface IMethodModel extends ICodeElement, IAccessible {
	String getMethodName();

	Class<?> getReturnType();

	Class<?>[] getArgumentTypes();

	IBlockModel[] getBlocks();

	IStatementModel[] getStatements();
}
