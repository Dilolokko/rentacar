/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author a
 */
public class baglanti {
    protected static final String HOSTNAME="jdbc:mysql://localhost:3306/giris";
    protected static final String USER = "root";
    protected static final String PASSWORD = "";
    protected static final String servis="jdbc:mysql://localhost:3306/rentdb";
    Connection con =null;
    Connection con2=null;
    
    protected void baglan ()
    {
    
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con2=DriverManager.getConnection(HOSTNAME,USER,PASSWORD);
             System.out.println("baglandi");
        } catch (Exception e) {
            System.out.println("Veri tabanına Bağlanamadı");
        }
    
    }
    
        protected void baglantiKes ()
    {
    
        try 
        {
          con2.close();
          System.out.println("baglati kesildi");
          
        } catch (Exception e) 
        {
          System.out.println("Veri tabanına Bağlanamadı");
        }
    
    }
        protected void rbaglan()
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(servis,USER,PASSWORD);
                System.out.println("rbaglandi");
            }
            catch(Exception e)
            {
                System.out.println("r veri tabanına bağlanamadı");
            }
            
        }
        protected void rbaglankes()
        {
            try
            {
                con.close();
            }
            catch(Exception e)
            {
                System.out.println("baglanti kesildi");
            }
        }
}
