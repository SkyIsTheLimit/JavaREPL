package com.github.skyisthelimit.jrepl.code;

import java.util.ArrayList;
import java.util.List;

import com.github.skyisthelimit.jrepl.api.code.ICodeElement;
import com.github.skyisthelimit.jrepl.api.code.models.IBlockModel;
import com.github.skyisthelimit.jrepl.api.code.models.IClassModel;
import com.github.skyisthelimit.jrepl.api.code.models.IMethodModel;
import com.github.skyisthelimit.jrepl.api.code.models.IStatementModel;

public abstract class AbstractCodeElement implements ICodeElement {
	protected List<ICodeElement> codeElements;

	public AbstractCodeElement() {
		this.codeElements = new ArrayList<>();
	}

	@Override
	public String getCode() {
		ICodeElement[] codeElements = null;

		if (this instanceof IClassModel)
			codeElements = ((IClassModel) this).getCodeElements();

		if (this instanceof IMethodModel)
			codeElements = ((IMethodModel) this).getCodeElements();

		if (this instanceof IBlockModel)
			codeElements = ((IBlockModel) this).getCodeElements();

		if (this instanceof IStatementModel)
			codeElements = ((IStatementModel) this).getCodeElements();

		if (codeElements == null)
			return "";

		StringBuilder code = new StringBuilder();

		for (ICodeElement codeElement : codeElements)
			code.append(codeElement.getCode());

		return code.toString();
	}

	@Override
	public ICodeElement[] getCodeElements() {
		return this.codeElements.toArray(new ICodeElement[] {});
	}

	@Override
	public boolean addCodeElement(ICodeElement element) {
		this.codeElements.add(element);

		return true;
	}

	@Override
	public ICodeElement removeCodeElement(ICodeElement element) {
		return this.codeElements.remove(this.codeElements.indexOf(element));
	}
}
