/**
 * 
 */
package Design;

import javafx.scene.control.TextField;

/**
 * @author Saif_sust_2013331007
 *
 */
public class textField extends TextField implements constant {

	/**
	 * 
	 */
	public textField(String promptText, double layoutX, double layoutY) {
		super.setLayoutX(layoutX);
		super.setLayoutY(layoutY);
		super.setPrefSize(columnPrefWidth,30);
		super.setPromptText(promptText);
		//super.setStyle("-fx-background-color: " + color + ";");

	}

}
