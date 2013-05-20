package com.github.skyisthelimit.jrepl.code;

import java.util.ArrayList;
import java.util.List;

import com.github.skyisthelimit.jrepl.api.code.ICodeElement;

public abstract class AbstractCodeElement implements ICodeElement {
	protected List<ICodeElement> codeElements;

	public AbstractCodeElement() {
		this.codeElements = new ArrayList<ICodeElement>();
	}

	@Override
	public String getCode() {
		/*
		 * ICodeElement[] codeElements = null;
		 * 
		 * if (this instanceof IClassModel) codeElements = ((IClassModel)
		 * this).getCodeElements();
		 * 
		 * if (this instanceof IMethodModel) codeElements = ((IMethodModel)
		 * this).getCodeElements();
		 * 
		 * if (this instanceof IBlockModel) codeElements = ((IBlockModel)
		 * this).getCodeElements();
		 * 
		 * if (this instanceof IStatementModel) codeElements =
		 * ((IStatementModel) this).getCodeElements();
		 * 
		 * if (codeElements == null) return "";
		 */

		// System.out.println("HERE");
		StringBuilder code = new StringBuilder();

		for (ICodeElement codeElement : codeElements) {
			// System.out.println("Adding code: " + codeElement.getCode());
			// if (codeElement instanceof IStatementModel)
			// code.append(((IStatementModel) codeElement).getStatement());
			// else
			code.append(codeElement.getCode());
		}

		// System.out.println("Returning code: " + code.toString() + " LENGTH: "
		// + this.codeElements.size());

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

	@Override
	public String toString() {
		return this.getCode();
	}
}
