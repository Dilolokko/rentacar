/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

/**
 *
 * @author a
 */
public class kvalue {
    private String kadi;
    private String parola;
    private int role;
    public kvalue(String kadi,String parola,Integer role)
    {
        this.kadi=kadi;
        this.parola=parola;
        this.role=role;
    }

    public String getKadi() {
        return kadi;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
