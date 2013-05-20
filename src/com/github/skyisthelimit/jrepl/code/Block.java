package com.github.skyisthelimit.jrepl.code;

import java.util.ArrayList;
import java.util.List;

import com.github.skyisthelimit.jrepl.api.code.models.IBlockModel;
import com.github.skyisthelimit.jrepl.api.code.models.IClassModel;
import com.github.skyisthelimit.jrepl.api.code.models.IStatementModel;

public class Block extends AbstractCodeElement implements IBlockModel {
	private List<IStatementModel> statements;
	private List<IBlockModel> blocks;
	private List<IClassModel> classes;

	public Block() {
		this.statements = new ArrayList<IStatementModel>();
		this.blocks = new ArrayList<IBlockModel>();
		this.classes = new ArrayList<IClassModel>();
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
		return "{" + super.getCode() + "}";
	}
}
