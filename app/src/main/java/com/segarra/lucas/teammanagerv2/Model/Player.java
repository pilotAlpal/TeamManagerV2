package com.segarra.lucas.teammanagerv2.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class Player implements Serializable {
    private PlayerStats playerInfo;



    public Player(String telefono, String nombre, Position pos, ArrayList<String> equipos) {
        playerInfo=new PlayerStats(telefono,nombre,pos,equipos);
    }

    public String getName(){return playerInfo.getName();}
    public String getPhone(){return playerInfo.getPhone();}
    public Position getPosition(){return playerInfo.getPosition();}
    public PlayerStats getPlayerInfo(){return playerInfo;}
    public void changePic(Bitmap newPic){
        playerInfo.changePic(newPic);
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
