package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class PlayerStats implements Serializable {
    private int goles,asistencias,partidos;
    private float rating;
    private Position posicion;

    public PlayerStats(int g,int a,int p,float r,Position pos){
        goles=g;asistencias=a;partidos=p;rating=r;posicion=pos;
    }


    public int getGols(){return goles;}
    public int getAsists(){return asistencias;}
    public int getMatches(){return partidos;}
    public float getRating(){return rating;}
    public Position getPosition(){return posicion;}


    public void setPosition(Position newPosition){
        posicion=newPosition;
    }
}
