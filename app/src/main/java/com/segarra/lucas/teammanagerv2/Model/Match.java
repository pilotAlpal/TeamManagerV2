package com.segarra.lucas.teammanagerv2.Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 22/09/2016.
 */

public class Match extends MyEvents {
    private MatchResult resultado;
    private MatchState estado;
    private ArrayList<Player> convocatoria;
    private int scored,recieved;

    public Match(Date d, Time t){
        super(d,t);
        resultado=MatchResult.Drawn;
        estado=MatchState.Unstarted;
        convocatoria=new ArrayList<>();
    }
    public MatchResult getResult(){return resultado;}
    public MatchState getState(){return estado;}
    public ArrayList<Player> getConvocatory(){return convocatoria;}
    public int getScored(){return scored;}
    public int getRecieved(){return recieved;}
    public void startMatch(){
        estado=MatchState.BeeingPlayed;
        scored=0;recieved=0;
    }
    public void matchFinished(int fav,int aga){
        scored=fav;recieved=aga;
        estado=MatchState.Finished;
        setResultado();
    }
    public void addToConvocatory(Player p){
        convocatoria.add(p);
    }
    public void removeFromConvocatory(Player p){
        convocatoria.remove(p);
    }
    private void setResultado(){
        if(scored<recieved)
            resultado=MatchResult.Lost;
        else if(scored>recieved)
            resultado=MatchResult.Won;
        else resultado=MatchResult.Drawn;
    }
}
