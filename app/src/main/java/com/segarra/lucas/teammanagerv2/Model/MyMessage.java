package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 27/09/2016.
 */

public class MyMessage implements Serializable {
    private String text,idAutor;
    public MyMessage(String t, String phone){
        idAutor=phone;
        text=t;
    }
    public String getText(){
        return text;
    }
    public String getIdAutor(){return idAutor;}
}
