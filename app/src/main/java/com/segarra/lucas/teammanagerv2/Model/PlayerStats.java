package com.segarra.lucas.teammanagerv2.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class PlayerStats implements Serializable {
    private String phone,name;
    private int goles,asistencias,partidos,dorsal,expulsiones;
    private float rating;
    private Position posicion;
    private String loadedTeam;
    private ArrayList<String> teams;
    private Bitmap playerPic;


    private void initialStats(){
        goles=0;asistencias=0;partidos=0;expulsiones=0;
        rating=0;
    }

    public PlayerStats(String telefono, String nombre, Position pos, ArrayList<String> equipos) {
        phone=telefono;
        name=nombre;
        posicion=pos;
        teams=equipos;
        initialStats();
    }

    public ArrayList<String> getTeams(){
        return teams;
    }


    public int getGols(){return goles;}
    public int getAsists(){return asistencias;}
    public int getMatches(){return partidos;}
    public float getRating(){return rating;}
    public Position getPosition(){return posicion;}


    public void setPosition(Position newPosition){
        posicion=newPosition;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLoadedTeam() {
        return loadedTeam;
    }

    public int getNumber() {
        return dorsal;
    }

    public int getExpulsions() {
        return expulsiones;
    }

    public int getPlayed() {
        return partidos;
    }

    public void remove(String myTeamName) {
        teams.remove(myTeamName);
    }

    public void add(String teamName) {
        teams.add(teamName);
    }

    public void changePic(Bitmap newPic) {
        playerPic=newPic;
    }

    public Bitmap getPhoto() {
        return playerPic;
    }
}
