package com.github.skyisthelimit.jrepl.code;

import java.util.ArrayList;
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

		this.arguments = new ArrayList<java.lang.Class<?>>();
	}

	@Override
	public String getAccessSpecifier() {
		return this.accessSpecifier;
	}

	@Override
	public String getMethodName() {
		return this.methodName;
	}

	@Override
	public Class<?> getReturnType() {
		return this.returnType;
	}

	@Override
	public Class<?>[] getArgumentTypes() {
		return this.arguments.toArray(new Class<?>[] {});
	}

	@Override
	public IBlockModel[] getBlocks() {
		return this.blocks.toArray(new IBlockModel[] {});
	}

	@Override
	public IStatementModel[] getStatements() {
		return this.statements.toArray(new IStatementModel[] {});
	}

	@Override
	public String getCode() {
		String code = super.getCode();

		String signature = getAccessSpecifier() + " "
				+ getReturnType().getName() + " " + getMethodName();

		signature += "(";

		for (int i = 0; i < getArgumentTypes().length; i++) {
			signature += getArgumentTypes()[i] + " arg" + i;

			if (i != getArgumentTypes().length - 1)
				signature += ", ";
		}

		signature += ")";

		return signature + code;
	}
}
