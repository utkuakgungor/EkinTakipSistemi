package com.utkuakgungor.ekintakipsistemi.utils;

/**
 * Created by utkuakgungor on 5.12.2017.
 */

public class FirebaseModel {

    private String tarla_adi;

    private String ekin_turu;

    private String ekin_tarihi;

    private String son_sulama;

    private String toprak_turu;


    public FirebaseModel(){

    }

    public FirebaseModel(String tarla_adi, String ekin_turu, String ekin_tarihi, String son_sulama,String toprak_turu) {
        this.tarla_adi = tarla_adi;
        this.ekin_turu = ekin_turu;
        this.ekin_tarihi = ekin_tarihi;
        this.son_sulama = son_sulama;
        this.toprak_turu=toprak_turu;
    }

    public String getTarla_adi() {
        return tarla_adi;
    }

    public void setTarla_adi(String tarla_adi) {
        this.tarla_adi = tarla_adi;
    }

    public String getEkin_turu() {
        return ekin_turu;
    }

    public void setEkin_turu(String ekin_turu) {
        this.ekin_turu = ekin_turu;
    }

    public String getEkin_tarihi() {
        return ekin_tarihi;
    }

    public void setEkin_tarihi(String ekin_tarihi) {
        this.ekin_tarihi = ekin_tarihi;
    }

    public String getSon_sulama() {
        return son_sulama;
    }

    public void setSon_sulama(String son_sulama) {
        this.son_sulama = son_sulama;
    }

    public String getToprak_turu() {
        return toprak_turu;
    }

    public void setToprak_turu(String toprak_turu) {
        this.toprak_turu = toprak_turu;
    }
}


