/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author a
 */
public class ToorController implements Initializable {

    @FXML
    private TableView<carvalue> tw;
    @FXML
    private TableColumn<carvalue, String> tc_plaka;
    @FXML
    private TableColumn<carvalue, String> tc_marka;
    @FXML
    private TableColumn<carvalue, String> tc_model;
    @FXML
    private TableColumn<carvalue, String> tc_yil;
    @FXML
    private TableColumn<carvalue, Integer> tc_kilometre;
    @FXML
    private TableColumn<carvalue, String> tc_durum;
    @FXML
    private AnchorPane ap;
    private TextField txt_marka;
    private TextField txt_model;
    private TextField txt_km;
    private TextField txt_durum;
    @FXML
    private Button btn_ara;
    @FXML
    private Button btn_yenile;
    @FXML
    private ComboBox<String> combobx;

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        doldur();
    }    
    
    public void doldur()
    {
        tc_plaka.setCellValueFactory(new PropertyValueFactory<carvalue,String>("plaka"));
        tc_marka.setCellValueFactory(new PropertyValueFactory<carvalue,String>("marka"));
        tc_model.setCellValueFactory(new PropertyValueFactory<carvalue,String>("model"));
        tc_yil.setCellValueFactory(new PropertyValueFactory<carvalue,String>("tarih"));
        tc_kilometre.setCellValueFactory(new PropertyValueFactory<carvalue,Integer>("km"));
        tc_durum.setCellValueFactory(new PropertyValueFactory<carvalue,String>("durum"));
        carvalueController cac=new carvalueController();
        tw.setItems(cac.vericek());
        ObservableList<carvalue> list=cac.vericek();
         ObservableList<String> marka=FXCollections.observableArrayList();
        for(carvalue c:list){
            marka.add(c.getMarka());
        }
        
        combobx.setItems(marka);
        
    }

    @FXML
    private void ara_click(ActionEvent event) {
        String marka;
        combobx.getSelectionModel().getSelectedItem();
        int km;
    }

    @FXML
    private void yenile_click(ActionEvent event) {
        doldur();
    }
    
}
