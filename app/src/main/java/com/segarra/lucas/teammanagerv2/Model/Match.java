package com.segarra.lucas.teammanagerv2.Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 22/09/2016.
 */

public class Match extends MyEvents {

    private MatchState estado;
    private ArrayList<Player> convocatoria;
    private ArrayList<Gol> golesF,golesC;


    public Match(Date d, Time t, String tit){
        super(d,t,tit);
        estado=MatchState.Unstarted;
        convocatoria=new ArrayList<>();
        golesF=new ArrayList<>();
        golesC=new ArrayList<>();
    }
    public ArrayList<Gol>getScoredGols(){
        return golesF;
    }
    public ArrayList<Gol>getRecievedGols(){
        return golesC;
    }
    public MatchResult getResult(){return MatchResult.getResult(golesF,golesC);}
    public MatchState getState(){return estado;}
    public ArrayList<Player> getConvocatory(){return convocatoria;}
    public int getScoredCount(){return golesF.size();}
    public int getRecieved(){return golesC.size();}
    public void startMatch(){
        estado=MatchState.BeeingPlayed;
    }
    public void matchFinished(){
        estado=MatchState.Finished;
    }
    public void addToConvocatory(Player p){
        convocatoria.add(p);
    }
    public void removeFromConvocatory(Player p){
        convocatoria.remove(p);
    }

    public void scoreGol(Gol gol){
        golesF.add(gol);
    }
    public void recieveGol(Gol gol){
        golesC.add(gol);
    }
    public MatchInfo getMatchInfo(){
        return new MatchInfo(golesF,golesC,estado,convocatoria);
    }
}
