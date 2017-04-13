/**
 * 
 */
package Design;

import javafx.scene.control.Button;

/**
 * @author Saif_sust_2013331007
 *
 */
public class button extends Button implements constant {

	/**
	 * 
	 */
	public button(String title, double layoutX, double layoutY, double width, double height) {
		super.setText(title);
		super.setLayoutX(layoutX);
		super.setLayoutY(layoutY);
		super.setPrefSize(width, height);
		super.setStyle("-fx-baxkgroung-color: GREEN;");
	}

}
