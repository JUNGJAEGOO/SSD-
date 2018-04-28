package javafxParc;

import java.util.*;
import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class HelloJavaFX extends Application {

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass());
		System.out.println(getClass().getResource("HelloJavaFX.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("HelloJavaFX.fxml"));
		primaryStage.setTitle("Hello JavaFX");
		primaryStage.setScene(new Scene(root,300,275));
		primaryStage.show();
	}
}
