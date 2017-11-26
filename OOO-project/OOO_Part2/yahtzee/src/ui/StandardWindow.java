package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StandardWindow extends Application implements Window, EventHandler<ActionEvent> {
	Stage stage;
	Pane pane;
	Scene scene;

	public StandardWindow(String title, int x, int y) {
		this.setStage(title);
		this.setPane();
		this.setScene(pane, x, y);
	}

	public Stage getStage() {
		return stage;
	}

	public Pane getPane() {
		return pane;
	}

	public Scene getScene() {
		return scene;
	}

	public void setStage(String title) {
		this.stage = new Stage();
		stage.setResizable(false);
		stage.setTitle(title);
	}

	public void setPane() {
		this.pane = new Pane();
	}

	public void setScene(Pane pane, int x, int y) {
		this.scene = new Scene(pane, x, y);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage = this.getStage();
		primaryStage.show();
	}

	@Override
	public void renderWindow() throws Exception {
		this.start(this.getStage());
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
