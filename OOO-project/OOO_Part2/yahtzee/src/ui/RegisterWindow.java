package ui;

import domain.DomainException;
import domain.SpelerController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegisterWindow extends DecoratedWindow implements EventHandler<ActionEvent> {

	private Button registratieOk;
	private Button registratieCancel;
	private Label registratieLabel;
	private TextField registratieInput;
	private Label registratieError;
	private static SpelerController controller = new SpelerController();
	private static int counter = controller.getSpelersLijst().getSpelers().size() + 1;

	public RegisterWindow() {
		super("Register player " + counter, 500, 150);
	}

	public void setPane() {
		this.pane = new Pane();

		registratieOk = new Button();
		registratieOk.setText("Ok");
		registratieCancel = new Button();
		registratieCancel.setText("Cancel");

		registratieOk.setOnAction(this);
		registratieCancel.setOnAction(this);

		registratieLabel = new Label("What's your name?");
		registratieLabel.setLayoutX(100);
		registratieLabel.setLayoutY(20);
		registratieLabel.setFont(Font.font("system", 14));
		this.getPane().getChildren().add(registratieLabel);

		registratieError = new Label();
		registratieError.setLayoutX(100);
		registratieError.setLayoutY(5);
		registratieError.setFont(Font.font("system", 14));
		registratieError.setTextFill(Color.RED);
		this.getPane().getChildren().add(registratieError);

		registratieInput = new TextField();
		registratieInput.setLayoutX(100);
		registratieInput.setLayoutY(50);
		registratieInput.setPrefWidth(275);
		registratieInput.setPrefHeight(20);
		registratieInput.setFont(Font.font("system", 14));
		this.getPane().getChildren().add(registratieInput);

		registratieOk.setLayoutX(300);
		registratieOk.setLayoutY(90);
		registratieOk.setPrefWidth(75);
		registratieOk.setPrefHeight(25);
		this.getPane().getChildren().add(registratieOk);

		registratieCancel.setLayoutX(200);
		registratieCancel.setLayoutY(90);
		registratieCancel.setPrefWidth(75);
		registratieCancel.setPrefHeight(25);
		this.getPane().getChildren().add(registratieCancel);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == registratieOk) {
			try {
				controller.createSpeler(registratieInput.getText());
				System.out.println(controller.getNextSpeler());
				for (int i = 0; i < 5; i++) {
					System.out.print(controller.getDice(i) + ", ");
				}
				controller.rolDices();
				System.out.println();
				Stage stage = (Stage) registratieOk.getScene().getWindow();
				stage.close();
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
}
