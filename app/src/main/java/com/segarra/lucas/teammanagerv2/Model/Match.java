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

    public Match(Date d, Time t){
        super(d,t);
        resultado=MatchResult.Drawn;
        estado=MatchState.Unstarted;
        convocatoria=new ArrayList<>();
    }
}
