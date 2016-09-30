package com.segarra.lucas.teammanagerv2.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class Player implements Serializable {
    private PlayerStats playerInfo;
    private Bitmap photo;



    public Player(String telefono, String nombre, Position pos, ArrayList<String> equipos) {
        playerInfo=MyUtils.getEmptyPlayerStats(nombre,telefono,pos,equipos);
    }

    public String getName(){return playerInfo.getName();}
    public String getPhone(){return playerInfo.getPhone();}
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
        playerInfo.remove(myTeamName);
    }

    public void enrollTeam(String teamName) {
        playerInfo.add(teamName);
    }

    public int getCountTeams() {
        return playerInfo.getTeams().size();
    }
}
