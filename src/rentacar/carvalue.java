/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.util.Date;

/**
 *
 * @author a
//// */
public class carvalue {
    private String plaka;
    private String marka;
    private String model;
    private String tarih;
    private String durum;
    private int km;
    public carvalue(String plaka,String marka,String model,String tarih,int km,String durum)
    {
        this.plaka=plaka;
        this.marka=marka;
        this.model=model;
        this.tarih=tarih;
        this.durum=durum;
        this.km=km;
    }

    carvalue(String plaka, String marka, String model, java.sql.Date yil, String durum, int km) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
    
    
}
