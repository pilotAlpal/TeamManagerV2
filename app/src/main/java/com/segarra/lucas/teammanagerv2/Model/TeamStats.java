package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class TeamStats implements Serializable{
    private int jugados,ganados,empatados,perdidos,favor,contra,recGoles,recAsists,recPlayed;
    private HashMap<String,Integer> jugGoles,jugAsistencias,jugPlayed;
    private String topScorer,topAsistant,topPlayed;

    public TeamStats(int j,int g,int e,int p,int f,int c,int rG,int rA,int rP,
                        HashMap<String,Integer> jG,HashMap<String,Integer> jA,HashMap<String ,Integer> jP,
                         String tS,String tA,String tP){
        jugados=j;ganados=g;empatados=e;perdidos=p;favor=f;contra=c;recGoles=rG;recAsists=rA;recPlayed=rP;
        jugGoles=jG;jugAsistencias=jA;jugPlayed=jP;
        topAsistant=tA;topPlayed=tP;topScorer=tS;
    }
    public int getPlayed(){return jugados;}
    public int getWon(){return ganados;}
    public int getDrawn(){return empatados;}
    public int getLost(){return perdidos;}
    public int getGolsFavor(){return favor;}
    public int getGolsAgainst(){return contra;}
    public int getGolsRecord(){return recGoles;}
    public int getAsistancesRecord(){return recAsists;}
    public int getPlayedRecord(){return recPlayed;}
    public String getTopScorerId(){return topScorer;}
    public String getTopAsistantId(){return topAsistant;}
    public String getTopPlayedId(){return topPlayed;}

}
