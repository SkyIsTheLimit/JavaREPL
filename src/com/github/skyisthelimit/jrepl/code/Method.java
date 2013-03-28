package com.github.skyisthelimit.jrepl.code;

import java.util.List;

import com.github.skyisthelimit.jrepl.api.code.models.IBlockModel;
import com.github.skyisthelimit.jrepl.api.code.models.IMethodModel;
import com.github.skyisthelimit.jrepl.api.code.models.IStatementModel;
import java.lang.Class;

public class Method extends AbstractCodeElement implements IMethodModel {
	private String accessSpecifier;
	private Class<?> returnType;
	private String methodName;
	private List<Class<?>> arguments;

	private List<IBlockModel> blocks;
	private List<IStatementModel> statements;

	public Method(String accessSpecifier, Class<?> returnType, String methodName) {
		this.accessSpecifier = accessSpecifier;
		this.returnType = returnType;
		this.methodName = methodName;
	}

	@Override
	public String getCode() {
		return null;
	}

	@Override
	public String getAccessSpecifier() {
		return null;
	}

	@Override
	public String getMethodName() {
		return null;
	}

	@Override
	public Class<?> getReturnType() {
		return null;
	}

	@Override
	public Class<?>[] getArgumentTypes() {
		return null;
	}

	@Override
	public IBlockModel[] getBlocks() {
		return null;
	}

	@Override
	public IStatementModel[] getStatements() {
		return null;
	}
}
