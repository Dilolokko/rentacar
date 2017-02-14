/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *.
 * @author a
 */
public class gislemleri extends baglanti {
    public String kullanicicek(String gelenKadi,String gelenSifre)
    {
        String ckt=null;
        
        try
        {
            baglan();
            PreparedStatement st= con2.prepareStatement("select roleName from roles where roleID=(select roleID from users where userName=? and password=?)");
            st.setString(1, gelenKadi);
            st.setString(2, gelenSifre);
            ResultSet rs= st.executeQuery();
            while(rs.next())
            ckt=rs.getString("roleName");
            System.out.println(ckt);
            st.close();
            rs.close();
            baglantiKes();
                
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return ckt;
        
    }
     public ObservableList<kvalue> kcek ()
    {
        ObservableList<kvalue> gelenk=FXCollections.observableArrayList();
        try
        {
            baglan();
            PreparedStatement ps2=con2.prepareStatement("select * from users");
            ResultSet rs2 = ps2.executeQuery();
            
            while(rs2.next())
            {
                gelenk.add(new kvalue(rs2.getString("userName"),rs2.getString("password"),rs2.getInt("roleID")));
            }
            
            rs2.close();
            ps2.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        return gelenk;
    }
     public void kullaniciekle(kvalue kullanici)
     {
         try
         {
             baglan();
             PreparedStatement ps=con2.prepareStatement("insert into users(userName,password,roleID) value(?,?,?)");
             ps.setString(1, kullanici.getKadi());
             ps.setString(2, kullanici.getParola());
             ps.setInt(3, kullanici.getRole());
             ps.executeUpdate();
             
             ps.close();
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
     }
    
     public void kullanicisil(String usern)
     {
         try
         {
            baglan();
            PreparedStatement st=con2.prepareStatement("delete from users where userName=?");
            st.setString(1, usern);
            st.executeUpdate();
            st.close();
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
             
         }
     }
    
    
}
