/**
 * 
 */
package Design;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Saif_sust_2013331007
 *
 */
public class label extends Label {

	public label(String Text, double layoutX, double layoutY, double prefWidth, double prefHeight, double fontSize,
			String color) {
		Text text = new Text(Text);
		super.setText(Text);
		super.setLayoutX(layoutX);
		super.setLayoutY(layoutY);
		super.setPrefSize(prefWidth, prefHeight);
		//super.setTextFill(Color.web("#ff6f00"));
		super.setStyle("-fx-background-color: " + color + ";" + "-fx-background-insets: 10; "
				+ "-fx-background-radius: 10;" + "-fx-effect: dropshadow(three-pass-box, purple, 10, 0, 0, 0);");
		super.setFont(new Font("Arial", fontSize));
		super.setAlignment(Pos.CENTER);

	}

}
