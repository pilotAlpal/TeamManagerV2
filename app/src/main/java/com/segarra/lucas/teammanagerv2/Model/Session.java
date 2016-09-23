package com.segarra.lucas.teammanagerv2.Model;


import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */

public class Session implements MyObservable<Session.MyObserver>,Serializable {
    private Player jugador;
    private Team equipo;
    private DatabaseHandler dao;
    private ArrayList<MyObserver> observadores;

    public Session(){
        observadores=new ArrayList<>();
        dao=new DatabaseHandler();
    }

    public void logIn(String phone,String pass){
        if(dao.validLogin(phone,pass)){
            jugador=dao.getPlayer(phone);
            equipo=dao.getLastTeamLogged(phone);
        }
        else
            notifyInvalidLogin();
    }

    public void signUp(String phone,String name,String pass,Position position){
        if(dao.validSignUp(phone)){
            jugador=dao.signUpPlayer(phone,name,pass,position);
            checkAtLeastOneTeam();
        }
        else
            notifyInvalidSignUp();
    }

    private void checkAtLeastOneTeam(){
        int numTeams=jugador.getCountTeams();
        if(numTeams==0)
            notifyNoTeamUser();
    }

    public void createTeam(String teamName){
        if(dao.validCreateTeamName(teamName)) {
            jugador.enrollTeam(teamName);
            equipo =dao.createTeam(teamName,jugador);
        }
        else notityInvalidCreateTeamName();
    }

    public void createTeam(String teamName,ArrayList<Player> teamMates){
        if(dao.validCreateTeamName(teamName)){
            jugador.enrollTeam(teamName);
            teamMates.add(jugador);
            equipo=dao.createTeam(teamName,teamMates);
        }
        else notityInvalidCreateTeamName();
    }

    public void changePlayerPicture(Bitmap newIm){
        jugador.changePic(newIm);
        dao.changePlayerPic(getMyPlayerId(),newIm);
    }

    public void changeLoadedTeam(String teamName){
        equipo=dao.getTeam(teamName);
    }

    public void changePlayerPos(Position newPos){
        jugador.changePos(newPos);
        dao.changePlayerPos(getMyPlayerId(),newPos);
    }

    public void deletePlayerProfile(){
        dao.deleteProfile(getMyPlayerId());
    }

    public void joinTeam(String teamName){
        jugador.enrollTeam(teamName);
        changeLoadedTeam(teamName);
    }

    public void leaveTeam(){
        dao.leavesTeam(getMyPlayerId(),getMyTeamName());
        jugador.removeEnrolledTeam(getMyTeamName());
        checkAtLeastOneTeam();
    }

    public void createEvent(MyEvents newEvent){
        dao.createEvent(getMyTeamName(),newEvent);
        equipo.addEvent(newEvent);
    }

    public void createMatch(Match newMatch){
        dao.createMatch(getMyTeamName(),newMatch);
        equipo.addMatch(newMatch);
    }

    private void notifyNoTeamUser() {
        for (MyObserver o:observadores)
            o.onNoTeamUser();
    }


    private void notityInvalidCreateTeamName() {
        for (MyObserver obs:observadores)
            obs.onInvalidCreateTeamName();
    }

    private void notifyInvalidSignUp() {
        for (MyObserver obs:observadores)
            obs.onInvalidSignUp();
    }

    private void notifyInvalidLogin() {
        for(MyObserver obs:observadores)
            obs.onInvalidLogin();
    }

    private String getMyPlayerId(){
        return jugador.getPhone();
    }

    private String getMyTeamName(){
        return equipo.getName();
    }

    @Override
    public void addObserver(MyObserver observer) {
        observadores.add(observer);
    }

    @Override
    public void delObserver(MyObserver observer) {
        observadores.remove(observer);
    }

    public interface MyObserver extends java.util.Observer{

        void onInvalidLogin();

        void onInvalidSignUp();

        void onInvalidCreateTeamName();

        void onNoTeamUser();
    }
}
