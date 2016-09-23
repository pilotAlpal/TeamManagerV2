package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class Diary implements Serializable {
    private ArrayList<MyEvents> eventos;
    private ArrayList<Match> ultimos,proximos;
    private Match prPartido;
    public Diary(ArrayList<MyEvents> e,ArrayList<Match> u,ArrayList<Match> p,Match m){
        eventos=e;ultimos=u;proximos=p;prPartido=m;
    }
    public Diary(){
        eventos=new ArrayList<>();ultimos=new ArrayList<>();proximos=new ArrayList<>();
        prPartido=new NoShceduledMatches();
    }
    private Match getNext(){
        if(proximos.isEmpty())
            return new NoShceduledMatches();
        Match ret=proximos.get(0);
        for(Match m:proximos){
            ret=getSooner(ret,m);
        }
        return ret;
    }
    private Match getSooner(Match m1,Match m2){
        Date date1=m1.getDate();
        Date date2=m2.getDate();
        if(date1.before(date2))
            return m1;
        else if (date2.before(date1))
            return m2;
        else {
            Time t1=m1.getTime();
            Time t2=m2.getTime();
            if (t1.before(t2))
                return m1;
            return m2;
        }
    }
    public void createMatch(Match m){
        if (m.equals(getSooner(m,prPartido))){
            proximos.add(prPartido);
            prPartido=m;
        }
        else
            proximos.add(m);
    }
    public void addEvent(MyEvents e){
        eventos.add(e);
    }
    public void addToNextMatch(Player p){
        prPartido.addToConvocatory(p);
    }
    public void removeFromNextMatch(Player p){
        prPartido.removeFromConvocatory(p);
    }
    public void nextMatchFinished(){
        prPartido.matchFinished();
        ultimos.add(prPartido);
        prPartido=getNext();
        proximos.remove(prPartido);
    }

    public void addScoredGol(Gol gol) {
        prPartido.scoreGol(gol);
    }
    public void addRecievedGol(Gol g){
        prPartido.recieveGol(g);
    }
    public Match getNextMatch(){
        return prPartido;
    }



}
