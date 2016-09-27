package com.segarra.lucas.teammanagerv2.Controller;

import android.graphics.Bitmap;

import com.segarra.lucas.teammanagerv2.Model.Match;
import com.segarra.lucas.teammanagerv2.Model.MyEvents;
import com.segarra.lucas.teammanagerv2.Model.Player;
import com.segarra.lucas.teammanagerv2.Model.Position;
import com.segarra.lucas.teammanagerv2.Model.Session;
import com.segarra.lucas.teammanagerv2.View.EventsFragment;
import com.segarra.lucas.teammanagerv2.View.NewsFragment;
import com.segarra.lucas.teammanagerv2.View.NextMatchFragment;
import com.segarra.lucas.teammanagerv2.View.PlayerFragment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 23/09/2016.
 */

public class Controller implements Serializable{
    private Session mySession;

    public Controller(){
        mySession=new Session();
    }
    public void logIn(String id,String pass){
        mySession.logIn(id,pass);
    }
    public void signUp(String phone,String name,String pass,Position position){
        mySession.signUp(phone,name,pass,position);
    }
    public void signUp(String phone, String name, String pass, Position pos, String team) {
        mySession.signUp(phone,name,pass,pos,team);
    }
    public void createTeam(String idTeam){
        mySession.createTeam(idTeam);
    }
    public void createTeam(String idTeam, ArrayList<Player> plantilla){
        mySession.createTeam(idTeam,plantilla);
    }
    public void changePicture(Bitmap bitmap){
        mySession.changePlayerPicture(bitmap);
    }
    public void changeTeam(String myOtherTeam){
        mySession.changeLoadedTeam(myOtherTeam);
    }
    public void changePos(Position pos){
        mySession.changePlayerPos(pos);
    }
    public void deletePlayerProfile(){
        mySession.deletePlayerProfile();
    }
    public void joinTeam(String newTeamId){
        mySession.joinTeam(newTeamId);
    }
    public void leaveTeam(){
        mySession.leaveTeam();
    }
    public void createEvent(MyEvents newEvent){
        mySession.createEvent(newEvent);
    }
    public void createMatch(Match newMatch){
        mySession.createMatch(newMatch);
    }
    public void addObserver(Session.MyObserver observer){
        mySession.addObserver(observer);
    }
    public void deleteObserver(Session.MyObserver observer){
        mySession.delObserver(observer);
    }

    public Position[] getPlayersPositions() {
        return Position.values();
    }

    public void logOut() {
        mySession.logOut();
    }

    public void removeObservers() {
        mySession.removeObservers();
    }

    //METHOS FILLING VIEWS DATA
    public void fillData(PlayerFragment p) {
        p.fill(mySession.getMyPlayerStats());
    }
    public void fillData(NewsFragment n){n.fill(mySession.getTeamMessages());}
    public void fillData(NextMatchFragment nM){nM.fill(mySession.getNextMatchInfo());}
    public void fillData(EventsFragment eF){eF.fill(mySession.getEventsInfo());}

}
