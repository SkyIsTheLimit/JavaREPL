package com.github.skyisthelimit.jrepl.code;

import java.util.ArrayList;
import java.util.List;

import com.github.skyisthelimit.jrepl.api.code.models.IBlockModel;
import com.github.skyisthelimit.jrepl.api.code.models.IClassModel;
import com.github.skyisthelimit.jrepl.api.code.models.IStatementModel;

public class Block implements IBlockModel {
	List<IStatementModel> statements;
	List<IBlockModel> blocks;
	List<IClassModel> classes;

	public Block() {
		this.statements = new ArrayList<>();
		this.blocks = new ArrayList<>();
		this.classes = new ArrayList<>();
	}

	@Override
	public IStatementModel[] getStatements() {
		return statements.toArray(new IStatementModel[] {});
	}

	@Override
	public IBlockModel[] getBlocks() {
		return blocks.toArray(new IBlockModel[] {});
	}

	@Override
	public IClassModel[] getClasses() {
		return classes.toArray(new IClassModel[] {});
	}

	@Override
	public String getCode() {
		String code = "";

		// Taking any order for now...
		for (IBlockModel block : blocks)
			code += block.getCode();

		for (IStatementModel statement : statements)
			code += statement.getCode();

		for (IClassModel clazz : classes)
			code += clazz.getCode();

		return code;
	}
}
