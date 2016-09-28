package com.segarra.lucas.teammanagerv2.Model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by lucas.segarra on 28/09/2016.
 */

public  class MyUtils {

    public static Diary getSampleDiary(){
        ArrayList<MyEvents> eventos=new ArrayList<>();
        ArrayList<Match> jugados=new ArrayList<>(),pendientes=new ArrayList<>();
        ArrayList<Message> conversa=new ArrayList<Message>();
        Date d=new Date();
        Time t=new Time(d.getTime());
        for(int i=1;i< 10;i++){
            eventos.add(new MyEvents(d,t,String.valueOf(i)));
            jugados.add(new Match(d,t,String.valueOf(i)));
        }
        return new Diary(eventos,jugados,pendientes,new Match(d,t,"Example Match"),conversa);
    }
    public static TeamStats getEmptyTeamStats(){
        return new TeamStats(0,0,0,0,0,0,new HashMap<String,Integer>(),new HashMap<String,Integer>(),new HashMap<String ,Integer> (),"Empty","Empty","Empty");
    }
    public static PlayerStats getEmptyPlayerStats(Position p){
        return new PlayerStats(0,0,0,0,p);
    }
    public static Player getSamplePlayer(String id){
        ArrayList<String> equipos=new ArrayList<>();
        equipos.add("Deporrito");equipos.add("Bravas");equipos.add("Remendados");
        return getSamplePlayer(id,"Lucas",Position.Mediapunta,equipos);
    }
    public static Player getSamplePlayer(String phone,String name,Position position,ArrayList<String> equipos){
        return new Player(phone,name,position,equipos);
    }
}
