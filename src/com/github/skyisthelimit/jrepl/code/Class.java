package com.github.skyisthelimit.jrepl.code;

import java.util.ArrayList;
import java.util.List;

import com.github.skyisthelimit.jrepl.api.code.IAccessible;
import com.github.skyisthelimit.jrepl.api.code.compile.ICompilable;
import com.github.skyisthelimit.jrepl.api.code.compile.ICompilationResult;
import com.github.skyisthelimit.jrepl.api.code.execute.IExecutable;
import com.github.skyisthelimit.jrepl.api.code.models.IBlockModel;
import com.github.skyisthelimit.jrepl.api.code.models.IClassModel;
import com.github.skyisthelimit.jrepl.api.code.models.IMethodModel;

public class Class extends AbstractCodeElement implements IClassModel {
	private String packageName;
	private String accessSpecifier;
	private String className;

	private boolean isCompiled;

	private List<IBlockModel> blocks;
	private List<IMethodModel> methods;
	private List<IClassModel> classes;

	public Class(String className) {
		this("", IAccessible.PUBLIC, className);
	}

	public Class(String packageName, String className) {
		this(packageName, IAccessible.PUBLIC, className);
	}

	public Class(String packageName, String accessSpecifier, String className) {
		super();

		this.packageName = packageName;
		this.accessSpecifier = accessSpecifier;
		this.className = className;

		this.isCompiled = false;

		this.blocks = new ArrayList<>();
		this.methods = new ArrayList<>();
		this.classes = new ArrayList<>();
	}

	@Override
	public String getAccessSpecifier() {
		return this.accessSpecifier;
	}

	@Override
	public ICompilable compile() {
		this.isCompiled = true;
		return null;
	}

	@Override
	public boolean isCompiled() {
		return this.isCompiled;
	}

	@Override
	public ICompilationResult getCompilationResult() {
		return null;
	}

	@Override
	public String getCompilableCode() {
		return this.getCode();
	}

	@Override
	public String getQualifiedName() {
		return this.packageName + "." + this.className;
	}

	@Override
	public String[] getQualifiedNames() {
		return null;
	}

	@Override
	public IExecutable execute() {
		return null;
	}

	@Override
	public String getPackageName() {
		return this.packageName;
	}

	@Override
	public String getClassName() {
		return this.className;
	}

	@Override
	public IBlockModel[] getBlocks() {
		return this.blocks.toArray(new IBlockModel[] {});
	}

	@Override
	public IMethodModel[] getMethods() {
		return this.methods.toArray(new IMethodModel[] {});
	}

	@Override
	public IClassModel[] getClasses() {
		return this.classes.toArray(new IClassModel[] {});
	}
}
