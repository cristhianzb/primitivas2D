package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

//comentario
//comentario
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Computer Graphics");
		
		StackPane root = new StackPane();
		Scene scene= new Scene(root,500,200);
		//comentario
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
