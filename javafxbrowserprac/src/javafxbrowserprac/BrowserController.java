package javafxbrowserprac;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.scene.control.TextField;

public class BrowserController implements Initializable {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	@FXML
	private void onEnter(ActionEvent event) {
		Object textfieldObject = event.getSource();
		TextField field = (TextField)textfieldObject;
		//System.out.println(field.getText());
		String url = field.getText();
		onWebView(url);
	}
	
	@FXML
	private static void onWebView(String url) {

		System.out.println(url);
		webEngine.load(url);
		
	}
}
