/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author a
 */
public class AdminController implements Initializable {

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
    private TableView<carvalue> tw;
    @FXML
    private MenuItem mi_sil;
    @FXML
    private TextField ara_marka;
    @FXML
    private TextField ara_model;
    @FXML
    private Button ara_button;
    @FXML
    private TextField txt_plaka;
    @FXML
    private TextField txt_marka;
    @FXML
    private TextField txt_model;
    @FXML
    private TextField txt_yil;
    @FXML
    private TextField txt_km;
    @FXML
    private TextField txt_drm;
    @FXML
    private Button btn_ekle;
    @FXML
    private TableView<kvalue> tw2;
    @FXML
    private TableColumn<kvalue, String> tc_kadi;
    @FXML
    private TableColumn<kvalue, String> tc_sifre;
    @FXML
    private TableColumn<kvalue, Integer> tc_role;
    @FXML
    private TextField txt_kadi;
    @FXML
    private TextField txt_sifre;
    @FXML
    private RadioButton rb_a;
    @FXML
    private RadioButton rb_g;
    @FXML
    private Button button_kekle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        doldur();
        doldurk();
    }    
    public void doldur()
    {
        tc_plaka.setCellValueFactory(new PropertyValueFactory<carvalue,String>("plaka"));
        tc_marka.setCellValueFactory(new PropertyValueFactory<carvalue,String>("marka"));
        tc_model.setCellValueFactory(new PropertyValueFactory<carvalue,String>("model"));
        tc_yil.setCellValueFactory(new PropertyValueFactory<carvalue,String>("tarih"));
        tc_kilometre.setCellValueFactory(new PropertyValueFactory<carvalue,Integer>("km"));
        tc_durum.setCellValueFactory(new PropertyValueFactory<carvalue,String>("durum"));
        carvalueController cc=new carvalueController();
        tw.setItems(cc.vericek());
    }
    public void doldurk()
    {
        tc_kadi.setCellValueFactory(new PropertyValueFactory<kvalue,String>("kadi"));
        tc_sifre.setCellValueFactory(new PropertyValueFactory<kvalue,String>("parola"));
        tc_role.setCellValueFactory(new PropertyValueFactory<kvalue,Integer>("role"));
        gislemleri gi= new gislemleri();
        tw2.setItems(gi.kcek());
    }
    @FXML
    public void ara()
    {
        
        carvalueController cc =new carvalueController();
        tw.setItems(cc.ara(ara_marka.getText().toString(),ara_model.getText().toString()));
    }
    

    @FXML
    private void ekle(ActionEvent event) throws ParseException, SQLException {
        //DateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
        String plaka=txt_plaka.getText().toString(),marka=txt_marka.getText().toString(),model=txt_model.getText().toString(),durum=txt_drm.getText().toString(),yil=txt_yil.getText().toString();
        int km=Integer.parseInt(txt_km.getText().toString());
       // Date yil=(Date) myformat.parse();
        carvalue cv= new carvalue(plaka,marka,model,yil,km,durum);
        carvalueController cc=new carvalueController();
        cc.carekle(cv);
        doldur();
    }

    @FXML
    private void sil(ActionEvent event) throws SQLException {
        
        carvalue secile=tw.getSelectionModel().getSelectedItem();
        if(JOptionPane.showConfirmDialog(null,secile.getPlaka()+" plakalı arabayı silmek istediğinizden emin misiniz ?","DİKKAT !!!",JOptionPane.YES_NO_OPTION)==(JOptionPane.YES_OPTION))
        {
            carvalueController cc = new carvalueController();
            cc.sil(secile.getPlaka().toString());
            doldur();
        }
        
    }

    @FXML
    private void degis(ActionEvent event) {
        String durum1="kirada";
        String durum2="musait";
        carvalue secilen=tw.getSelectionModel().getSelectedItem();
        carvalueController cc = new carvalueController();
        if(secilen.getDurum().toString().equals(durum2))
        {
            cc.degistir(secilen.getPlaka().toString(), durum1);
        }
        else if(secilen.getDurum().toString().equals(durum1))
        {
            cc.degistir(secilen.getPlaka().toString(), durum2);
        }
        doldur();
    }

    @FXML
    private void eklek(ActionEvent event) {
        String kadi=txt_kadi.getText().toString(),parola=txt_sifre.getText().toString();
        int role=0;
        if(rb_a.isSelected())
        {
            role=1;
        }
        else
        {
            role=2;
        }
        kvalue kd=new kvalue(kadi,parola,role);
        gislemleri gs = new gislemleri();
        gs.kullaniciekle(kd);
        doldurk();
    }

    @FXML
    private void silk(ActionEvent event) {
        kvalue kv =tw2.getSelectionModel().getSelectedItem();
        gislemleri gs = new gislemleri();
        if(JOptionPane.showConfirmDialog(null,kv.getKadi().toString()+" kullanıcısını silmek istediğinizden emin misiniz ?","Dikkat - Kullanıcı Silme İşlemi",JOptionPane.YES_NO_OPTION)==(JOptionPane.YES_OPTION))
        {
            gs.kullanicisil(kv.getKadi().toString());
            doldurk();
        }
        
    }
    
}
