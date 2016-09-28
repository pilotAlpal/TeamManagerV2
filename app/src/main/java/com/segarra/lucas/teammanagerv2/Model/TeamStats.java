package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class TeamStats implements Serializable{
    private int jugados,ganados,empatados,perdidos,favor,contra;
    private HashMap<String,Integer> jugGoles,jugAsistencias,jugPlayed;
    private String topScorer,topAsistant,topPlayed;

    public TeamStats(int j,int g,int e,int p,int f,int c,
                     HashMap<String,Integer> jG,HashMap<String,Integer> jA,HashMap<String ,Integer> jP,
                     String tS,String tA,String tP){
        jugados=j;ganados=g;empatados=e;perdidos=p;favor=f;contra=c;
        jugGoles=jG;jugAsistencias=jA;jugPlayed=jP;
        topAsistant=tA;topPlayed=tP;topScorer=tS;
    }
    public int getPlayed(){return jugados;}
    public int getWon(){return ganados;}
    public int getDrawn(){return empatados;}
    public int getLost(){return perdidos;}
    public int getGolsFavor(){return favor;}
    public int getGolsAgainst(){return contra;}
    public int getGolsRecord(){return jugGoles.get(topScorer);}
    public int getAsistancesRecord(){return jugAsistencias.get(topAsistant);}
    public int getPlayedRecord(){return jugPlayed.get(topPlayed);}
    public String getTopScorerId(){return topScorer;}
    public String getTopAsistantId(){return topAsistant;}
    public String getTopPlayedId(){return topPlayed;}

    public void registerScored(Gol gol) {
        favor++;
        String name=gol.getGolerId();
        int aux=jugGoles.get(name)+1;
        jugGoles.put(name,aux);
        checkTopScorer(name);
        name=gol.getAsistentId();
        aux=jugAsistencias.get(name)+1;
        jugAsistencias.put(name,aux);
        checkTopAsistant(name);
    }

    public void registerRecieved(Gol gol){
        contra++;
    }

    public void storeMatch(Match m){
        ArrayList<Gol> fav=m.getScoredGols(),con=m.getRecievedGols();
        for(Gol g:fav)
            registerScored(g);
        for(Gol g:con)
            registerRecieved(g);
        jugados++;
        MatchResult res=m.getResult();
        if(res.isDrawn()){
            empatados++;
        }
        else  if(res.isLost())
            perdidos++;
        else ganados++;
    }

    private void checkTopAsistant(String n) {
        int ant=jugAsistencias.get(topAsistant),prox=jugAsistencias.get(n);
        if(prox>ant){
            topAsistant=n;
        }
    }
    private void checkTopScorer(String n){
        int ant=jugGoles.get(topScorer),prox=jugGoles.get(n);
        if(prox>ant){
            topScorer=n;
        }
    }


}
