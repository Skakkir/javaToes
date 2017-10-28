package is.ru.tictac;

import static spark.Spark.*;
import static spark.Spark.get;
public class TicTac {
	public static void main(String[] args) {
    	port(getPort());        
    	get("/hello", (req, res) -> "Hello World");
	}
	static int getPort() {
    	ProcessBuilder newProcess = new ProcessBuilder();
	    if (newProcess.environment().get("PORT") != null) {
	    	return Integer.parseInt(newProcess.environment().get("PORT"));
    	}
     	return 4567;
 	}

}