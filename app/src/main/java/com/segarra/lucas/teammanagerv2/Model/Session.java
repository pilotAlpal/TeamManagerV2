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
            loadFromBd(phone);
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
            ArrayList<Player> teamComps=new ArrayList<>();
            teamComps.add(jugador);
            equipo =dao.createTeam(teamName,teamComps);
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

    public void logOut() {
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void addToNextMatch(){
        equipo.addToNextMatch(jugador);
        dao.addToNextMatch(jugador);
    }

    public void removeFromNextMatch(){
        equipo.removeFromNextMatch(jugador);
        dao.removeFromNextMatch(jugador);
    }

    
    //BUTTONS FLOW METHODS
    public void showMyPlayerProfile() {
        notifyMyPlayerProfile();
    }

    public void showMyTeamProfile(){
        notifyMyTeamProfile();
    }
    
    public void showMyEvents(){
        notifyEvents();
    }

    public void searchTeam() {
        notifyTeamSearch();
    }

    public void saveProfileChanges(Position p, String team) {
        dao.saveProfileChanges(getMyPlayerId(),p,team);
        notifyChangesSaved();
    }


    public void showNewTeam() {
        notifyNewTeam();
    }


    //AUXILIAR METHODS

    private void checkAtLeastOneTeam(){
        int numTeams=jugador.getCountTeams();
        if(numTeams==0)
            notifyNoTeamUser();
    }

    private void loadFromBd(String phone){
        jugador=dao.getPlayer(phone);
        equipo=dao.getLastTeamLogged(phone);
    }

    //COMPONENT GETTERS (USED BY CONTROLLER FOR FILLING VIEWS)
    
    private String getMyPlayerId(){
        return jugador.getPhone();
    }

    private String getMyTeamName(){
        return equipo.getName();
    }

    public PlayerStats getMyPlayerStats() {
        return jugador.getPlayerInfo();
    }

    public TeamStats getMyTeamStats(){
        return equipo.getInfo();
    }

    public ArrayList<MyEvents> getMyTeamEvents(){
        return equipo.getEvents();
    }

    public ArrayList<Match> getLastMatches(){
        return equipo.getLastMatches();
    }

    public ArrayList<Match> getNextMatches(){
        return equipo.getNextMatches();
    }

    public ArrayList<MyMessage> getTeamMessages() {
        return equipo.getTeamMessages();
    }

    public MatchInfo getNextMatchInfo() {
        return equipo.getNextMatchInfo();
    }

    public EventsInfo getEventsInfo() {
        return equipo.getEventsInfo();
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
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onInvalidEnrollTeamName();
    }

    private void notifyNewTeam() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onNewTeam();
    }


    private void notifyMatchCreated() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onMatchCreated();

    }

    private void notifyTeamChanged() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onTeamChanged();
    }

    private void notifyPictureChanged() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onPictureChanged();
    }

    private void notifyTeamCreated() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onTeamCreated();

    }

    private void notifySigned() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onSigned();
    }

    private void notifyChangesSaved() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onChangesSaved();

    }


    private void notifyLogged() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onLogged();
    }
    
    private void notifyNoTeamUser() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onNoTeamUser();
    }

    private void notifyInvalidCreateTeamName() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onInvalidCreateTeamName();
    }

    private void notifyInvalidSignUp() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onInvalidSignUp();
    }

    private void notifyInvalidLogin() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onInvalidLogin();
    }

    private void notifyMyPlayerProfile() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onMyPlayerProfile();
    }

    private void notifyMyTeamProfile() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onMyTeamProfile();
    }

    private void notifyEvents() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onEvents();
    }

    private void notifyTeamSearch() {
        for(int i = 0 ; i < observadores.size() ; i++)
            observadores.get(i).onTeamSearch();
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

        void onMyPlayerProfile();

        void onMyTeamProfile();

        void onEvents();

        void onTeamSearch();

        void onNewTeam();

        void onChangesSaved();
    }
}
