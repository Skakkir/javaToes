package is.ru.tictac;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class javaToes implements SparkApplication {


        public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication javaToes = new javaToes();
        port(getPort());                
        javaToes.init();
    }

    static int getPort() {
    	ProcessBuilder newProcess = new ProcessBuilder();
	    if (newProcess.environment().get("PORT") != null) {
	    	return Integer.parseInt(newProcess.environment().get("PORT"));
    	}
     	return 4567;
     }

    public void init(){
        post(
          "/", 
          (request, response) -> {
            return "X";
        });

    }        
}