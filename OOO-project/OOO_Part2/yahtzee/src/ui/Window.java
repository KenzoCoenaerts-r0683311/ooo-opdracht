package ui;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public interface Window {
	public void start(Stage primaryStage) throws Exception;

	public Stage getStage();

	public Pane getPane();

	public Scene getScene();

	public void setStage(String title);

	public void setPane();

	public void setScene(Pane pane, int x, int y);

	void renderWindow(Window windowReference) throws Exception;
}
