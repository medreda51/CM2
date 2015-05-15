package com.footingcycling;

/**
 * Created by Amin on 24/04/2015.
 */
public class TablaRegistros {
    private int _id;
    private String fecha;
    private String distancia;
    private String tiempo;
    private String calorias;
    private Integer imageSource;

    public TablaRegistros(String calorias, String fecha, String distancia, String tiempo,Integer imageSource){
        this.fecha = fecha;
        this.calorias = calorias;
        this.tiempo = tiempo;
        this.distancia = distancia;
        this.imageSource = imageSource;

    }
    public TablaRegistros(){

    }
    public String getFecha() {
        return fecha;
    }
    public Integer getimageSource() {
        return imageSource;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getcalorias() {
        return calorias;
    }

    public void setcalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getdistancia() {
        return distancia;
    }

    public void setdistancia(String distancia) {
        this.distancia = distancia;
    }

    public String gettiempo() {
        return tiempo;
    }

    public void settiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int get_id() {
        return _id;
    }
    public void setId(int _id ) {
        this._id = _id;
    }


}


