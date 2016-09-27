package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 27/09/2016.
 */
public class MatchInfo implements Serializable {
    ArrayList<Gol> gF,gC;
    MatchState state;
    ArrayList<Player> convs;
    MatchResult resultado;

    public MatchInfo(ArrayList<Gol> favor, ArrayList<Gol> contra, MatchState estado, ArrayList<Player> convocados) {
        gF=favor;gC=contra;
        state=estado;
        convs=convocados;
        resultado=MatchResult.getResult(favor,contra);
    }

}
