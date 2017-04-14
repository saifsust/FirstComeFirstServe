/**
 * 
 */
package Design;

import javafx.scene.layout.Pane;

/**
 * @author Saif_sust_2013331007
 *
 */
public class panel extends Pane implements constant {

	/**
	 * 
	 */
	public panel(double layoutX, double layoutY) {

		super.setLayoutX(layoutX);
		super.setLayoutY(layoutY);
		super.setPrefSize(table_prefWidth+80, panePrefHeight);
	//	super.setStyle("-fx-background-color: GREEN;");

	}

}
