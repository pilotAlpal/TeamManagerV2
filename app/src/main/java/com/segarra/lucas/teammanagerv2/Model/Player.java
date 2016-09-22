package com.segarra.lucas.teammanagerv2.Model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class Player implements Serializable {
    private String name,phone;
    private PlayerStats playerInfo;
    private Bitmap photo;

    public Player(String nombre,String telefono,Position posicion){
        name=nombre;phone=telefono;playerInfo=new PlayerStats(posicion);
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


}
