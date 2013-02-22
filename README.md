JavaREPL
========

<b>A Java Read Eval Print Loop (REPL)</b>

*What is a Read Eval Print Loop?*

A Read Eval Print Loop (REPL) is a tool used to try out a new language, debug existing code, or 
just play around with the language runtime. As the name suggests, the tool follows the following
workflow:

	1. Read some code.
	2. Evaluate it.
	3. Print the output of the evaluation.
	4. Go back to step 1.

A REPL usually maintains state where in it remembers all the "transactions" the user has already
carried out. So, for instance, if a user has created a new variable age and given it the value 87,
then the REPL maintains that state and the next time the user tries to access age in any transaction,
the REPL returns the previously created variable age which contains the value 87.

These, among many other features make a REPL a very useful tool. Most scripting langauges already have
their own version of REPL. For instance, Python, Ruby, SML, Erlang, etc. all have a REPL devleoped 
already. However, Jave doesn't seem to have one.