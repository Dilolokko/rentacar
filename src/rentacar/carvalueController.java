/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author a
 */
public class carvalueController extends baglanti{
    public ObservableList <carvalue> vericek()
    {
        ObservableList <carvalue> cekilenveri = FXCollections.observableArrayList();
        try
        {
            rbaglan();
            PreparedStatement cars=con.prepareStatement("select * from cars");
            ResultSet rs= cars.executeQuery();
            while(rs.next())
            {
                cekilenveri.add(new carvalue(rs.getString("plaka"),rs.getString("marka"),rs.getString("model"),rs.getString("yil"),rs.getInt("km"),rs.getString("durum")));
            }
            rs.close();
            cars.close();
            
        }
        catch(Exception e)
        {
            System.out.println("baglanti sıkıntısı");
        }
        return cekilenveri;
    }
    public ObservableList <carvalue> ara(String marka,String model)
    {
        ObservableList <carvalue> ckv = FXCollections.observableArrayList();
        try
        {
            rbaglan();
            PreparedStatement cars=con.prepareStatement("select * from cars where marka=? and model=? ");
            cars.setString(1, marka);
            cars.setString(2, model);
            ResultSet rs= cars.executeQuery();
            while(rs.next())
            {
                ckv.add(new carvalue(rs.getString("plaka"),rs.getString("marka"),rs.getString("model"),rs.getString("yil"),rs.getInt("km"),rs.getString("durum")));
            }
            System.out.println("arıyor");
            rs.close();
            cars.close();
            
        }
        catch(Exception e)
        {
            System.out.println("baglanti sıkıntısı");
        }
        return ckv;
    }
    public void carekle(carvalue car) throws SQLException
    {
        try
        {
            rbaglan();
            PreparedStatement ps=con.prepareStatement("insert into cars (plaka,marka,model,yil,km,durum) value(?,?,?,?,?,?)");
            ps.setString(1, car.getPlaka());
            ps.setString(2, car.getMarka());
            ps.setString(3, car.getModel());
            ps.setString(4, car.getTarih());
            ps.setInt(5, car.getKm());
            ps.setString(6, car.getDurum());
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    
        
    }
    public void sil(String plaka) throws SQLException
    {
        try
        {
            rbaglan();
        PreparedStatement st = con.prepareStatement("delete from cars where plaka=?");
        st.setString(1, plaka);
        st.executeUpdate();
        st.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    public void degistir(String plaka,String durum)
    {
        try
        {
            rbaglan();
            
            PreparedStatement pt= con.prepareStatement("update cars set durum=? where plaka=?");
            pt.setString(1, durum);
            pt.setString(2, plaka);
            pt.executeUpdate();
            pt.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
