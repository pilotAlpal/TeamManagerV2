package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 27/09/2016.
 */
public class EventsInfo implements Serializable {
    ArrayList<MyEvents> events;
    ArrayList<Match> nextOnes,lastOnes;
    public EventsInfo(ArrayList<MyEvents> evs, ArrayList<Match> ults, ArrayList<Match> proxs) {
        events=evs;
        nextOnes=proxs;
        lastOnes=ults;
    }
    public ArrayList<MyEvents> getEvents(){return events;}
    public ArrayList<Match> getNextMatches(){
        return nextOnes;
    }
    public ArrayList<Match> getLastMatches(){
        return lastOnes;
    }
}
