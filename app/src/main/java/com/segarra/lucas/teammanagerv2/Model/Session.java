package com.segarra.lucas.teammanagerv2.Model;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */

public class Session implements MyObservable,Serializable {
    private Player jugador;
    private Team equipo;
    private DatabaseHandler dao;
    private ArrayList<MyObserver> observadores;

    public Session(){
        observadores=new ArrayList<>();
        dao=new DatabaseHandler();
    }

    @Override
    public void addObserver(Object observer) {

    }

    @Override
    public void delObserver(Object observer) {

    }

    public interface MyObserver extends java.util.Observer{

    }
}
