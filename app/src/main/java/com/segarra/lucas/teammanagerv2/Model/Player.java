package com.segarra.lucas.teammanagerv2.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class Player implements Serializable {
    private String name,phone;
    private PlayerStats playerInfo;
    private Bitmap photo;
    private ArrayList<String> teamNames;


    public Player(String telefono, String nombre, Position pos, ArrayList<String> equipos) {
        name=nombre;phone=telefono;playerInfo=MyUtils.getEmptyPlayerStats(pos);
        teamNames=equipos;
    }

    public String getName(){return name;}
    public String getPhone(){return phone;}
    public int getGols(){return playerInfo.getGols();}
    public int getAsists(){return playerInfo.getAsists();}
    public int getMatches(){return playerInfo.getMatches();}
    public float getRating(){return playerInfo.getRating();}
    public Position getPosition(){return playerInfo.getPosition();}
    public PlayerStats getPlayerInfo(){return playerInfo;}
    public Bitmap getPhoto(){return photo;}
    public void changePic(Bitmap newPic){
        photo=newPic;
    }


    public void changePos(Position newPos) {
        playerInfo.setPosition(newPos);
    }

    public void removeEnrolledTeam(String myTeamName) {
        teamNames.remove(myTeamName);
    }

    public void enrollTeam(String teamName) {
        teamNames.add(teamName);
    }

    public int getCountTeams() {
        return teamNames.size();
    }
}
