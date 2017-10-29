package is.ru.tictac;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class javaToes implements SparkApplication {

    private final TicTac toeJava = new TicTac();
    
        public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication javaToes = new javaToes();
        port(getPort());                
        javaToes.init();
    }

    // gets a port for our host
    static int getPort() {
    	ProcessBuilder newProcess = new ProcessBuilder();
	    if (newProcess.environment().get("PORT") != null) {
	    	return Integer.parseInt(newProcess.environment().get("PORT"));
    	}
     	return 4567;
     }
    // will initializes a  Spark context for the web app
    public void init(){
        post(
          "/", 
          (request, response) -> {
            toeJava.togglePlayer();
            char currPlayer = toeJava.getCurrPlayer();
            toeJava.addToBoard(Integer.parseInt(request.queryParams("id")));
            return currPlayer;
        });
        
        // will reset the board, so that we can play again
        post(
            "/newBoard", 
            (request, response) -> {
              toeJava.newBoard();
              response.status(200);
              return response;
          });
          
          // check if there is a winner
          post(
            "/hasWon", 
            (request, response) -> {
             return toeJava.isWinner();
          });

    }        
}