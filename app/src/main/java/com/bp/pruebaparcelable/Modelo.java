package com.bp.pruebaparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Borja on 11/09/2017.
 */

public class Modelo implements Parcelable{ //Debe implementar Parcelable para poder pasar objetos a otra actividad
    
    private String user;
    private String pass;

    /*Constructor por defecto*/
    public Modelo(String user, String pass){
        super();
        this.user = user;
        this.pass = pass;
    }

    /*Sirve para crear un objeto Modelo desde un Parcel*/
    public Modelo(Parcel source) {
        this.user = source.readString();
        this.pass = source.readString();
    }

    /*Getters y Setters*/
    public String getUser(){
        return user;
    }
    
    public String getPass(){
        return pass;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    public void setPass(String pass){
        this.pass = pass;
    }

    /*Describe el contenido del Parcel*/
    @Override
    public int describeContents() {
        return 0; //Devuelve 0 pues nuestro objeto no contiene ningun objeto especial
    }

    /*Escribe el contenido en un Parcel*/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user); //Escribe las dos cadenas de caracteres de los datos del usuario
        dest.writeString(pass);
    }
    
    /*Creación de objeto CREATOR. Permite crear una instancia de nuestro objeto desde un Parcel*/
    public static final Parcelable.Creator<Modelo> CREATOR = new Parcelable.Creator<Modelo>(){

        /*Permite crear un objeto Modelo desde un Parcel*/
        @Override
        public Modelo createFromParcel(Parcel source) {
            return new Modelo(source); //Es necesario crear un constructor que recibe un Parcel y devuelve un usuario.
        }

        /*Permite crear un array de objetos de tipo Modelo*/
        @Override
        public Modelo[] newArray(int size) {
            return new Modelo[size];
        }
    };
}
