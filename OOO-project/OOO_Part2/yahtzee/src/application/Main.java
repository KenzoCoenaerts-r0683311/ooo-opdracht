package application;

import domain.DomainException;
import domain.Speler;
import domain.SpelersLijst;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

	int counter = 1;
	Button registratieOk;
	Button registratieCancel;
	Label registratieLabel = new Label("What's your name?");
	TextField registratieInput = new TextField();
	Label registratieError = new Label();
	SpelersLijst spelers = new SpelersLijst();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == registratieOk) {
			try {
				spelers.beschikbareSpeler(registratieInput.getText());
				Speler nieuweSpeler = new Speler(registratieInput.getText());
				System.out.println(nieuweSpeler.getNaam());
				spelers.addSpeler(nieuweSpeler);
				Stage stage = (Stage) registratieOk.getScene().getWindow();
				stage.close();
				counter++;
				registratieError.setText("");
				registratieInput.setText("");
				Stage stage2 = new Stage();
				try {
					start(stage2);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (DomainException e) {
				Stage stage = (Stage) registratieOk.getScene().getWindow();
				stage.close();
				Stage stage2 = new Stage();
				try {
					start(stage2);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				registratieError.setText(e.getMessage());
				registratieInput.setText("");
			}
		}

		if (event.getSource() == registratieCancel) {
			Stage stage = (Stage) registratieCancel.getScene().getWindow();
			stage.close();
		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Register player " + counter);
		primaryStage.setResizable(false);

		registratieOk = new Button();
		registratieOk.setText("Ok");
		registratieCancel = new Button();
		registratieCancel.setText("Cancel");

		registratieOk.setOnAction(this);
		registratieCancel.setOnAction(this);

		Pane pane1 = new Pane();

		registratieLabel.setLayoutX(100);
		registratieLabel.setLayoutY(20);
		registratieLabel.setFont(Font.font("system", 14));
		pane1.getChildren().add(registratieLabel);

		registratieError.setLayoutX(100);
		registratieError.setLayoutY(5);
		registratieError.setFont(Font.font("system", 14));
		registratieError.setTextFill(Color.RED);
		pane1.getChildren().add(registratieError);

		registratieInput.setLayoutX(100);
		registratieInput.setLayoutY(50);
		registratieInput.setPrefWidth(275);
		registratieInput.setPrefHeight(20);
		registratieInput.setFont(Font.font("system", 14));
		pane1.getChildren().add(registratieInput);

		registratieOk.setLayoutX(300);
		registratieOk.setLayoutY(90);
		registratieOk.setPrefWidth(75);
		registratieOk.setPrefHeight(25);
		pane1.getChildren().add(registratieOk);

		registratieCancel.setLayoutX(200);
		registratieCancel.setLayoutY(90);
		registratieCancel.setPrefWidth(75);
		registratieCancel.setPrefHeight(25);
		pane1.getChildren().add(registratieCancel);

		Scene scene = new Scene(pane1, 500, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		/*@Override
		public void start(Stage primaryStage) {
			try {
				BorderPane root = new BorderPane();
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}*/
	}
}
