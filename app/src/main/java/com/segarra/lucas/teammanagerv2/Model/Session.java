package com.segarra.lucas.teammanagerv2.Model;


import android.graphics.Bitmap;

import com.segarra.lucas.teammanagerv2.Controller.Controller;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by lucas.segarra on 22/09/2016.
 * Represents the model.
 */

public class Session implements MyObservable<Session.MyObserver>,Serializable {
    private Player jugador;
    private Team equipo;
    private DatabaseHandler dao;
    private ArrayList<MyObserver> observadores;

    /**
     * Default constructor
     */
    public Session(){
        observadores=new ArrayList<>();
        dao=new DatabaseHandler();
    }

    /**
     * Checks phone and pass. If right loads team and player, otherwise notifys invalid logg-in
     * @param phone player´s id
     * @param pass player´s password
     */
    public void logIn(String phone,String pass){
        if(dao.validLogin(phone,pass)){
            jugador=dao.getPlayer(phone);
            equipo=dao.getLastTeamLogged(phone);
            notifyLogged();
        }
        else
            notifyInvalidLogin();
    }
    
    /**
     * If player´s phone not already registred, creates a new player on database.
     * Otherwise notifies player already registred
     * @param phone player´s id.
     * @param name player´s name.
     * @param pass player´s password.
     * @param position player´s favourite position.
     */
    public void signUp(String phone,String name,String pass,Position position){
        if(dao.validSignUp(phone)){
            jugador=dao.signUpPlayer(phone,name,pass,position);
            checkAtLeastOneTeam();
            notifySigned();
        }
        else
            notifyInvalidSignUp();
    }

    public void signUp(String phone, String name, String pass, Position pos, String team) {
        if(dao.validSignUp(phone)){
            if(dao.validEnrollTeamName()){
                jugador=dao.signUpPlayer(phone,name,pass,pos);
                dao.linkTeamAndPlayer(phone,team);
                equipo=dao.getTeam(team);
                notifySigned();
            }
            else notifyInvalidEnrollTeamName();
        }
        else
            notifyInvalidSignUp();
    }


    /**
     * If not already registered name, creates on database and loads a new team were session´s player gets registered.
     * Otherwise notifies alredy registered team name.
     * @param teamName new team´s id.
     */
    public void createTeam(String teamName){
        if(dao.validCreateTeamName(teamName)) {
            jugador.enrollTeam(teamName);
            equipo =dao.createTeam(teamName,jugador);
            notifyTeamCreated();
        }
        else notifyInvalidCreateTeamName();
    }

    /**
     * If not already registered name, creates on database and loads a new team were session´s player and some teamMates gets registered.
     * Otherwise notifies alredy registered team name.
     * @param teamName new team´s id.
     * @param teamMates partners list.
     */
    public void createTeam(String teamName,ArrayList<Player> teamMates){
        if(dao.validCreateTeamName(teamName)){
            jugador.enrollTeam(teamName);
            teamMates.add(jugador);
            equipo=dao.createTeam(teamName,teamMates);
            notifyTeamCreated();
        }
        else notifyInvalidCreateTeamName();
    }

    /**
     * Changes player´s pic on session and database.
     * @param newIm new bitmap.
     */
    public void changePlayerPicture(Bitmap newIm){
        jugador.changePic(newIm);
        dao.changePlayerPic(getMyPlayerId(),newIm);
        notifyPictureChanged();
    }


    /**
     * Changes session´s loaded team.
     * @param teamName other of player´s teams
     */
    public void changeLoadedTeam(String teamName){
        equipo=dao.getTeam(teamName);
        notifyTeamChanged();
    }


    /**
     * Changes on session and database the position where the user prefers to play.
     * @param newPos new favourite position.
     */
    public void changePlayerPos(Position newPos){
        jugador.changePos(newPos);
        dao.changePlayerPos(getMyPlayerId(),newPos);
    }

    /**
     * Deletes player´s profile.
     */
    public void deletePlayerProfile(){

        dao.deleteProfile(getMyPlayerId());
        logOut();
    }

    /**
     * Add´s a new team to player´s teams list and loads it in session.
     * @param teamName
     */
    public void joinTeam(String teamName){
        jugador.enrollTeam(teamName);
        changeLoadedTeam(teamName);
    }

    /**
     * Deletes on database relationship between session´s player and team.
     * Loads an other of player´s team list on session.
     */
    public void leaveTeam(){
        dao.leavesTeam(getMyPlayerId(),getMyTeamName());
        jugador.removeEnrolledTeam(getMyTeamName());
        checkAtLeastOneTeam();
    }

    /**
     * Creates a new event on both database and session.
     * @param newEvent
     */
    public void createEvent(MyEvents newEvent){
        dao.createEvent(getMyTeamName(),newEvent);
        equipo.addEvent(newEvent);
    }

    /**
     * Creates a new match in both database and session.
     * @param newMatch
     */
    public void createMatch(Match newMatch){
        dao.createMatch(getMyTeamName(),newMatch);
        equipo.addMatch(newMatch);
        notifyMatchCreated();
    }

    //AUXILIAR METHODS

    private void logOut() {
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void checkAtLeastOneTeam(){
        int numTeams=jugador.getCountTeams();
        if(numTeams==0)
            notifyNoTeamUser();
    }

    //COMPONENT GETTERS
    
    private String getMyPlayerId(){
        return jugador.getPhone();
    }

    private String getMyTeamName(){
        return equipo.getName();
    }

    //OBSERVABLE IMPLEMENTED

    @Override
    public void addObserver(MyObserver observer) {
        observadores.add(observer);
    }

    @Override
    public void delObserver(MyObserver observer) {
        observadores.remove(observer);
    }

    public void removeObservers() {
        for(MyObserver o:observadores){
            delObserver(o);
        }
    }


    //OBSERVERS NOTIFIERS
    private void notifyInvalidEnrollTeamName() {
        for (MyObserver o:observadores){
            o.onInvalidEnrollTeamName();
        }
    }

    private void notifyMatchCreated() {
        for(MyObserver o:observadores){
            o.onMatchCreated();
        }
    }

    private void notifyTeamChanged() {
        for(MyObserver o:observadores){
            o.onTeamChanged();
        }
    }

    private void notifyPictureChanged() {
        for(MyObserver o:observadores){
            o.onPictureChanged();
        }
    }

    private void notifyTeamCreated() {
        for(MyObserver o:observadores){
            o.onTeamCreated();
        }
    }

    private void notifySigned() {
        for(MyObserver o:observadores){
            o.onSigned();
        }
    }
    
    private void notifyLogged() {
        for (MyObserver o:observadores)
            o.onLogged();
    }
    
    private void notifyNoTeamUser() {
        for (MyObserver o:observadores)
            o.onNoTeamUser();
    }

    private void notifyInvalidCreateTeamName() {
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


    /**
     * METHODS OBSERVERS WILL IMPLEMENT DEFINITIONS
     */
    public interface MyObserver  extends java.util.Observer{

        void setController(Controller c);

        void onInvalidLogin();

        void onInvalidSignUp();

        void onInvalidCreateTeamName();

        void onNoTeamUser();

        void onLogged();

        void onSigned();

        void onTeamCreated();

        void onPictureChanged();

        void onTeamChanged();

        void onMatchCreated();

        void onInvalidEnrollTeamName();
    }
}
