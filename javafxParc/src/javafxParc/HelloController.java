package javafxParc;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.event.*;
import java.net.*;
import java.util.*;

public class HelloController implements Initializable{

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
	
	@FXML
	private void buttonPress(ActionEvent event) {
		Object buttonObject = event.getSource();
		Button button = (Button)buttonObject;
		System.out.println(button.getId());
	}
	
	@FXML
	private void checkBoxPress(ActionEvent event) {
		Object checkboxObject = event.getSource();
		CheckBox checkbox = (CheckBox)checkboxObject;
		System.out.println(checkbox.getId());
	}

}
