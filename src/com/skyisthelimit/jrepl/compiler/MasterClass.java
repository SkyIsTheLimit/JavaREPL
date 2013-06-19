package com.skyisthelimit.jrepl.compiler;

public class MasterClass extends JavaSourceCode {
	private StringBuffer globalCode;
	private String extraCode;

	public MasterClass() {
		super(new StringReader("master.Master", ""));
		this.fullyQualifiedName = "master.Master";
		this.code = "";
		this.globalCode = new StringBuffer();
		this.extraCode = "";
	}

	private void constructMasterCode() {
		this.code = "package master;\n" + "public class Master{\n"
				+ "\tpublic void main(){\n\t\t" + this.extraCode + "\n\t}"
				+ "\n}";
	}

	public void addGlobalCode(String code) {
		this.globalCode.append(code + "\n");
		this.extraCode = code;
		constructMasterCode();
	}
}
