package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 23/09/2016.
 */

public class Gol implements Serializable {
    private String goleador,asistente;
    public Gol(String golerId,String asistantId){
        goleador=golerId;
        asistente=asistantId;
    }
    public String getGolerId(){
        return goleador;
    }
    public String getAsistentId(){
        return asistente;
    }
}
