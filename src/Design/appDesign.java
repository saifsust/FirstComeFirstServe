/**
 *
 */
package Design;

import java.util.ArrayList;
import java.util.List;

import FCFS_algorithm.FCFS;
import FCFS_algorithm.inputPair;
import FCFS_algorithm.outputPair;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Saif_sust_2013331007
 *
 */

public class appDesign extends Application implements constant {

	private ObservableList<outputPair> outList = FXCollections.observableArrayList();
	private ObservableList<inputPair> inList = FXCollections.observableArrayList();

	public appDesign() {

	}

	public appDesign(Stage primaryStage) {
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		initial();

		primaryStage.show();
	}

	private void initial() {

		processColumn();
		ArivalTimeColumn();
		BusrtTimeColumn();
		OutCTColumn();
		OutTATColumn();
		OutWTColumn();
		Scroll();
		root.getChildren()
				.add(new label("First Come, First Serve", 0.0, 0.0, prefLabelWidth, prefLabelHeight, 24, "#ab47bc"));

		configPane();

	}

	/**
	 * @param args
	 */
	private void configPane() {
		Pane pane = new panel(10.0, table_prefHeight + prefLabelHeight + 90);
		double x = 0.0, y = 5.0;
		final TextField TFP = new textField("Process", x, y);
		pane.getChildren().add(TFP);
		final TextField TFA = new textField("Arival Time", x + columnPrefWidth, y);
		pane.getChildren().add(TFA);
		final TextField TFB = new textField("Burst Time", x + 2.0 * columnPrefWidth, y);
		pane.getChildren().add(TFB);
		Button add = new button("ADD", x + 3.0 * columnPrefWidth + 10, y, columnPrefWidth - 20, 30);
		pane.getChildren().add(add);
		root.getChildren().add(pane);

		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (!TFP.getText().trim().isEmpty() && !TFA.getText().trim().isEmpty()
						&& !TFB.getText().trim().isEmpty()) {
					// System.out.println("Ok done");
					String pr = TFP.getText();
					String AT = TFA.getText();
					String BT = TFB.getText();
					double at = Double.parseDouble(AT);
					double bt = Double.parseDouble(BT);
					inList.add(new inputPair(pr, at, bt));
					in.setItems(inList);
					TFP.clear();
					TFA.clear();
					TFB.clear();

				}
			}

		});

	}

	private void Scroll() {
		double x = 10.0, y = prefLabelHeight + 10;
		double outX = x + table_prefWidth + 80, outWidth = table_prefWidth * 2.0;
		Label inlabel = new label("Input Table", x, y, table_prefWidth, 70, 12, "#ff6f00");
		Label outlabel = new label("Output Table", outX, y, outWidth, 70, 12, "#ff6f00");
		// label.setTextFill(Color.web("#ff6f00"));
		root.getChildren().add(inlabel);
		root.getChildren().add(outlabel);
		inScroll = new scrollpane(x, y + 70, table_prefWidth + 15, table_prefHeight);
		in.setPrefSize(table_prefWidth, table_prefHeight);
		outScroll = new scrollpane(outX, y + 70, outWidth, table_prefHeight);
		out.setPrefSize(outWidth, table_prefHeight);
		outScroll.setContent(out);
		inScroll.setContent(in);
		root.getChildren().add(inScroll);
		root.getChildren().add(outScroll);
		Button start = new button("START", outX + 80.0, y + table_prefHeight + 90, 150.0, 40.0);
		root.getChildren().add(start);
		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (!inList.isEmpty()) {
					// System.out.println("Ok done Start");
					outList = new FCFS().FCFS_Algo(inList);
					out.setItems(outList);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("First Come, FIrst Serve");
					alert.setHeaderText("Gantt Chart");
					String text = "";
					for (int i = 0; i < outList.size(); i++) {
						text += " [ " + outList.get(i).getArivalTime() + " " + outList.get(i).getProcess() + " "
								+ outList.get(i).getComplictionTime() + "] ";
					}
					alert.setContentText(text);
					alert.showAndWait();
				}
			}

		});

		Button clear = new button("clear", outX + 260, y + table_prefHeight + 90, 150, 40);
		root.getChildren().add(clear);
		clear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (!outList.isEmpty()) {
					outList.clear();
				}
				if (!inList.isEmpty()) {
					inList.clear();
				}
			}

		});

	}

	private void processColumn() {
		Inprocess.setMaxWidth(columnPrefWidth);
		Inprocess.setEditable(false);
		Inprocess.setResizable(false);
		Inprocess.setCellValueFactory(new PropertyValueFactory<inputPair, String>("process"));

		in.getColumns().add(Inprocess);

		Outprocess.setMaxWidth(columnPrefWidth);
		Outprocess.setEditable(false);
		Outprocess.setResizable(false);
		Outprocess.setCellValueFactory(new PropertyValueFactory<outputPair, String>("process"));

		out.getColumns().add(Outprocess);

	}

	private void ArivalTimeColumn() {
		InArivalTime.setMaxWidth(columnPrefWidth);
		InArivalTime.setEditable(false);
		InArivalTime.setResizable(false);
		InArivalTime.setCellValueFactory(new PropertyValueFactory<inputPair, Double>("arivalTime"));

		in.getColumns().add(InArivalTime);

		OutArivalTime.setMaxWidth(columnPrefWidth);
		OutArivalTime.setEditable(false);
		OutArivalTime.setResizable(false);
		OutArivalTime.setCellValueFactory(new PropertyValueFactory<outputPair, Double>("arivalTime"));
		out.getColumns().add(OutArivalTime);

	}

	private void BusrtTimeColumn() {
		InBusrtTime.setMaxWidth(columnPrefWidth);
		InBusrtTime.setEditable(false);
		InBusrtTime.setResizable(false);
		InBusrtTime.setCellValueFactory(new PropertyValueFactory<inputPair, Double>("burstTime"));

		in.getColumns().add(InBusrtTime);

		OutBusrtTime.setMaxWidth(columnPrefWidth);
		OutBusrtTime.setEditable(false);
		OutBusrtTime.setResizable(false);
		OutBusrtTime.setCellValueFactory(new PropertyValueFactory<outputPair, Double>("burstTime"));
		out.getColumns().add(OutBusrtTime);

	}

	private void OutCTColumn() {

		OutCT.setMaxWidth(columnPrefWidth);
		OutCT.setEditable(false);
		OutCT.setResizable(false);
		OutCT.setCellValueFactory(new PropertyValueFactory<outputPair, Double>("complictionTime"));
		out.getColumns().add(OutCT);

	}

	private void OutTATColumn() {

		OutTAT.setMaxWidth(columnPrefWidth);
		OutTAT.setEditable(false);
		OutTAT.setResizable(false);
		OutTAT.setCellValueFactory(new PropertyValueFactory<outputPair, Double>("turnArroundTime"));
		out.getColumns().add(OutTAT);

	}

	private void OutWTColumn() {

		OutWT.setMaxWidth(columnPrefWidth);
		OutWT.setEditable(false);
		OutWT.setResizable(false);
		OutWT.setCellValueFactory(new PropertyValueFactory<outputPair, Double>("waitingTime"));
		out.getColumns().add(OutWT);

	}

	private ScrollPane inScroll, outScroll;
	private Stage stage;
	private Group root = new Group();
	private Scene scene = new Scene(root, width, height);
	private TableView<inputPair> in = new TableView<inputPair>();
	private TableView<outputPair> out = new TableView<outputPair>();
	private TableColumn<inputPair, String> Inprocess = new TableColumn<inputPair, String>("process");
	private TableColumn<inputPair, Double> InArivalTime = new TableColumn<inputPair, Double>("arivalTime");
	private TableColumn<inputPair, Double> InBusrtTime = new TableColumn<inputPair, Double>("burstTime");

	private TableColumn<outputPair, String> Outprocess = new TableColumn<outputPair, String>("process");
	private TableColumn<outputPair, Double> OutArivalTime = new TableColumn<outputPair, Double>("arivalTime");
	private TableColumn<outputPair, Double> OutBusrtTime = new TableColumn<outputPair, Double>("burstTime");
	private TableColumn<outputPair, Double> OutCT = new TableColumn<outputPair, Double>("CT");
	private TableColumn<outputPair, Double> OutTAT = new TableColumn<outputPair, Double>("TAT");
	private TableColumn<outputPair, Double> OutWT = new TableColumn<outputPair, Double>("WT");

	public static void main(String[] args) {
		try {
			launch(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		new appDesign(primaryStage);

	}

}
