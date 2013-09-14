package com.skyisthelimit.jrepl.cr.clazz;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;

import javax.tools.SimpleJavaFileObject;

import com.skyisthelimit.jrepl.cr.reader.CodeReader;
import com.skyisthelimit.jrepl.cr.reader.StringReader;
import com.skyisthelimit.jrepl.cr.utils.StringUtilities;

/**
 * 
 * This class represents a java class file. Simply pass in a
 * <code>CodeReader</code> and create a java class. This class is important in
 * the sense that it is the basic structure for a java class. Any more
 * functionality can be obtained by extending this class.
 * 
 * For example. The <code>ExecutableClass</code> is derived from the
 * <code>JavaClass</code>. The executable class is just a simple java class with
 * addition to extra information being provided about what can and should be
 * executed. This provides a flexible way of adding more types of classes
 * (UserDefinedClass, etc.)
 * 
 * The class is abstract since it does not provide an implementation to the
 * compile method within the <code>Compilable</code> interface. The compile
 * method is essentially a callback indicating that the class is compiled, thus
 * allowing for any house keeping activities to take place.
 * 
 * @author Sandeep Prasad
 * 
 * @see ExecutableClass
 * @see Compilable
 * @see Executable
 */
abstract public class JavaClass extends SimpleJavaFileObject implements
		Compilable {
	protected String fullyQualifiedName;
	protected String compilableCode;
	private CodeReader reader;
	private URI uri;

	/**
	 * Private contructor used for creating the actual <code>JavaClass</code>
	 * object.
	 * 
	 * @param uri
	 *            The URI to the Source.
	 * @param kind
	 *            The kind of the source.
	 */
	private JavaClass(URI uri, Kind kind) {
		super(uri, kind);

		this.uri = uri;
	}

	/**
	 * Returns the URI of the source.
	 * 
	 * @return Returns the URI of the source.
	 */
	public URI uri() {
		return this.uri;
	}

	/**
	 * The public constructor which accepts a <code>CodeReader</code>.
	 * 
	 * @param reader
	 *            The code reader which provides the source code.
	 * 
	 * @see StringReader
	 */
	@SuppressWarnings("deprecation")
	public JavaClass(CodeReader reader) {
		this(
				URI.create(URLEncoder.encode(reader.getProtocol()
						+ ":///"
						+ StringUtilities.replace(".", "/",
								reader.getFullyQualifiedName())
						+ Kind.SOURCE.extension)), Kind.SOURCE);

		this.reader = reader;
		this.fullyQualifiedName = this.reader.getFullyQualifiedName();
		this.compilableCode = this.reader.getCode();
	}

	/**
	 * Returns the fully qualified name of the enclosed java class.
	 * 
	 * @return Returns the fully qualified name of the enclosed java class.
	 */
	public String getQualifiedName() {
		return this.fullyQualifiedName;
	}

	/**
	 * Returns the class name of the enclosed type.
	 * 
	 * @return Returns the class name of the enclosed type.
	 */
	@Override
	public String getName() {
		if (fullyQualifiedName.indexOf('.') == -1)
			return fullyQualifiedName;

		return StringUtilities.between(
				fullyQualifiedName + "|",
				fullyQualifiedName.substring(0,
						fullyQualifiedName.lastIndexOf('.') + 1), "|");

	}

	/**
	 * Returns the package name of the enclosed type.
	 * 
	 * @return Returns the package of the enclosed type.
	 */
	public String getPackage() {
		if (fullyQualifiedName.indexOf('.') == -1)
			return "";

		return fullyQualifiedName.substring(0,
				fullyQualifiedName.lastIndexOf('.'));
	}

	/**
	 * Overriden method. Returns the character content.
	 */
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		return this.compilableCode;
	}

	/**
	 * Returns the compilable code of the enclosed java class.
	 * 
	 * @return Returns the compilable code of the enclosed java class.
	 */
	@Override
	public String getCode() {
		return this.compilableCode;
	}

	/**
	 * The string representation of the object is the compilable code.
	 */
	@Override
	public String toString() {
		return this.compilableCode;
	}
}
