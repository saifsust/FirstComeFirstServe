/**
 * 
 */
package luaner;

import Design.appDesign;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Saif_sust_2013331007
 *
 */
public class Main extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new appDesign(primaryStage);

	}

}
