package groovy.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Lists ScriptEngine factories and runs Groovy scripts via ScriptEngine.
 */
public class ScriptEngineFactories {
	
	private static Logger log = Logger.getLogger(ScriptEngineFactories.class.getName());
	
	public static void main(String [] args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		List<ScriptEngineFactory> factories = manager.getEngineFactories();
		
		//To have groovy factory listed, the groovy-all jar should be in the classpath
		for(ScriptEngineFactory sef : factories) {
			log.info("lang name: " + sef.getLanguageName());
			log.info("engine name: " + sef.getEngineName());
			log.info(sef.getNames().toString());
		}
		
		//running Groovy scripts
		ScriptEngine engine = manager.getEngineByName("groovy");
		try {
			engine.eval("println 'Hello Groovy!'");
			engine.eval(new FileReader("src/groovy/examples/GroovyExamples.groovy"));
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
