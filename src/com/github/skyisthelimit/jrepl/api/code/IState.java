package com.github.skyisthelimit.jrepl.api.code;

/**
 * The global state of the REPL. Maintains the loaded Objects and Classes. The
 * REPL provides access to all the built in classes of the java library. Along
 * with the built in library, the REPL provides access to the classes and
 * objects present in the state.
 * 
 * NOTE: The classes in a state will be all the classes added by the user (new
 * classes created in the REPL and other classes imported into the REPL).
 * However the objects will not ONLY be the objects created from these new
 * classes but also objects created from ALL the classes within state.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface IState {
	void addClass(Class<?> clazz);

	Class<?>[] getClasses();

	Class<?> removeClass(Class<?> clazz);

	void addObject(Object object);

	Object[] getObjects();

	Object removeObject(Object object);
}
