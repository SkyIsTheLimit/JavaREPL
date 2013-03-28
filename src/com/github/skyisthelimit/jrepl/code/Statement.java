package com.github.skyisthelimit.jrepl.code;

import com.github.skyisthelimit.jrepl.api.code.models.IStatementModel;

public class Statement implements IStatementModel {
	private String statementString;

	public Statement(String statementString) {
		this.statementString = statementString;
	}

	public void setStatementString(String statementString) {
		this.statementString = statementString;
	}

	@Override
	public String getStatement() {
		return this.statementString;
	}

	public static Statement getStatement(String statementString) {
		return new Statement(statementString);
	}

	@Override
	public String getCode() {
		return this.getStatement();
	}

}