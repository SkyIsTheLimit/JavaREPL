package com.github.skyisthelimit.jrepl.code;

import java.util.ArrayList;
import java.util.List;

import com.github.skyisthelimit.jrepl.api.code.ICodeElement;
import com.github.skyisthelimit.jrepl.api.code.models.IBlockModel;
import com.github.skyisthelimit.jrepl.api.code.models.IClassModel;
import com.github.skyisthelimit.jrepl.api.code.models.IStatementModel;

public class Block implements IBlockModel {
	List<ICodeElement> codeElements;
	List<IStatementModel> statements;
	List<IBlockModel> blocks;
	List<IClassModel> classes;

	public Block() {
		this.codeElements = new ArrayList<>();
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
		StringBuilder code = new StringBuilder();

		for (ICodeElement codeElement : codeElements)
			code.append(codeElement.getCode());

		/**
		 * Give these program elements an order. The order would be dictated by
		 * the order in which they were added to the block. One way in which
		 * this could be done is by giving all the program elements a common
		 * type, and then adding that type to a list, rather than adding blocks,
		 * statements, methods, etc. separately.
		 */

		return code.toString();
	}

	@Override
	public ICodeElement[] getCodeElements() {
		return codeElements.toArray(new ICodeElement[] {});
	}
}
