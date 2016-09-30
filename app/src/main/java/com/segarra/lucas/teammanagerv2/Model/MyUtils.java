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
            jugados.add(new Match(d,t,String.valueOf(i),getSampleConvocatory()));
        }
        return new Diary(eventos,jugados,pendientes,new Match(d,t,"Example Match",getSampleConvocatory()),conversa);
    }

    public static ArrayList<Player> getSampleConvocatory() {
        ArrayList<Player> convocados=new ArrayList<>();
        String phone="626992478";
        ArrayList<String> equipos =new ArrayList<>();
        convocados.add(new Player(phone,"Cañizares",Position.Portero,equipos));
        convocados.add(new Player(phone,"Anglomá",Position.Lateral,equipos));
        convocados.add(new Player(phone,"Pelegrino",Position.Central,equipos));
        convocados.add(new Player(phone,"Ayala",Position.Central,equipos));
        convocados.add(new Player(phone,"Carboni",Position.Lateral,equipos));
        convocados.add(new Player(phone,"Albelda",Position.Medio,equipos));
        convocados.add(new Player(phone,"Baraja",Position.Medio,equipos));
        convocados.add(new Player(phone,"Aimar",Position.Mediapunta,equipos));
        convocados.add(new Player(phone,"Angulo",Position.Extremo,equipos));
        convocados.add(new Player(phone,"Vicente",Position.Extremo,equipos));
        convocados.add(new Player(phone,"Carew",Position.Delantero,equipos));
        return convocados;
    }

    public static TeamStats getEmptyTeamStats(){
        return new TeamStats(0,0,0,0,0,0,new HashMap<String,Integer>(),new HashMap<String,Integer>(),new HashMap<String ,Integer> (),"Empty","Empty","Empty");
    }
    public static PlayerStats getEmptyPlayerStats(String nombre, String telf, Position p, ArrayList<String> equipos){
        return new PlayerStats(telf,nombre,0,0,0,0,p,"Valencia",14,15,equipos);
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
