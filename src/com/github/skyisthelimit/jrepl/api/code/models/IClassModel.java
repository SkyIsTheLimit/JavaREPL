package com.github.skyisthelimit.jrepl.api.code.models;

import com.github.skyisthelimit.jrepl.api.code.IAccessible;
import com.github.skyisthelimit.jrepl.api.code.ICodeElement;
import com.github.skyisthelimit.jrepl.api.code.ICompilable;
import com.github.skyisthelimit.jrepl.api.code.IExecutable;

public interface IClassModel extends ICodeElement, IAccessible, ICompilable,
		IExecutable {
	String getPackageName();

	String getClassName();

	IBlockModel[] getBlocks();

	IMethodModel[] getMethods();

	IClassModel[] getClasses();

	ICodeElement[] getCodeElements();
}
