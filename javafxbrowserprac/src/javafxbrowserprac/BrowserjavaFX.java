package javafxbrowserprac;

import java.util.*;
import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.Parent;

public class BrowserjavaFX extends Application {

	@FXML
	WebView webView;
	private static WebEngine webEngine;
	
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass());
		System.out.println(getClass().getResource("browser.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("browser.fxml"));
		
		webView = new WebView();
		webEngine = webView.getEngine();
		webEngine.load("http://www.naver.com");
		
		primaryStage.setTitle("Browser JavaFX");
		primaryStage.setScene(new Scene(root,600,450));
		primaryStage.show();
	}
	
}
