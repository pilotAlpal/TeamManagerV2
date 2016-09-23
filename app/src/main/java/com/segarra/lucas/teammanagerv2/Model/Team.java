package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class Team implements Serializable{
    private String name;
    private TeamStats info;
    private ArrayList<Player> players;
    private Diary agenda;

    public Team(String teamName,TeamStats ts,ArrayList<Player> plantilla,Diary diario){
        name=teamName;info=ts;players=plantilla;agenda=diario;
    }


    public Team(String teamName, ArrayList<Player> plantilla) {
        name=teamName;info=new TeamStats();players=plantilla;agenda=new Diary();
    }

    public String getName(){return name;}
    public TeamStats getInfo(){return info;}
    public ArrayList<Player> getPlayers(){
        return players;
    }
    public Diary getDiary(){
        return agenda;
    }
    public void addMatch(Match m){
        agenda.createMatch(m);
    }
    public void addEvent(MyEvents e){
        agenda.addEvent(e);
    }
    public void addToNextMatch(Player p){
        agenda.addToNextMatch(p);
    }
    public void removeFromNextMatch(Player p){
        agenda.removeFromNextMatch(p);
    }
    public int getCountPlayed(){
        return info.getPlayed();
    }
    public int getCountWon(){
        return info.getWon();
    }
    public int getCountDrawn(){
        return info.getDrawn();
    }
    public int getCountLost(){
        return info.getLost();
    }
    public int getCountScored(){
        return info.getGolsFavor();
    }
    public int getCountRecieved(){
        return info.getGolsAgainst();
    }
    public String getTopScorerId(){
        return info.getTopScorerId();
    }
    public String getTopAsistantId(){
        return info.getTopAsistantId();
    }
    public String getTopPlayedId(){
        return info.getTopPlayedId();
    }
    public void scoreOnNextMatch(Gol gol){
        agenda.addScoredGol(gol);
        info.registerScored(gol);
    }
    public void recieveOnNextMatch(Gol gol){
        agenda.addRecievedGol(gol);
        info.registerRecieved(gol);
    }
    public void nextMatchFinished(){
        info.storeMatch(agenda.getNextMatch());
    }
    public int getGolsRecord(){return info.getGolsRecord();}
    public int getAsistancesRecord(){return info.getAsistancesRecord();}
    public int getPlayedRecord(){return info.getPlayedRecord();}



}
