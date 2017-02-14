/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author a
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button_1;
    @FXML
    private Label label1;
    @FXML
    private TextField txt_1;
    @FXML
    private TextField txt_2;
    @FXML
    private Button button_2;
    String kadi,parola,role;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        kadi=txt_1.getText().toString();
        parola=txt_2.getText().toString();
        gislemleri gi=new gislemleri();
        role = gi.kullanicicek(kadi, parola);
        if(role.equals("user"))
        {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Rent a Car - Administrator");
            stage.show();
        }
        if(role.equals("guest"))
        {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent root2 = FXMLLoader.load(getClass().getResource("toor.fxml"));
        
            Scene scene2 = new Scene(root2);
            Stage stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setTitle("Rent a Car");
            stage2.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iptal(ActionEvent event) {
        
        
    }
    
}
