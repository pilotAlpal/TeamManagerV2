package com.segarra.lucas.teammanagerv2.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class DatabaseHandler implements Serializable{

    /**
     * Comprueba si un id de usuario (teléfono) se corresponde con una contraseña.
     * @param phone idUsuario
     * @param pass contraseña
     * @return si la información de inicio de sesión es correcta
     */
    public boolean validLogin(String phone, String pass) {
        return true;
    }

    /**
     *
     * @param phone id de usuario
     * @return el jugador asociado a un teléfono
     */
    public Player getPlayer(String phone) {
        ArrayList<String> equipos=new ArrayList<>();
        equipos.add("Deporrito");equipos.add("Bravas");equipos.add("Remendados");
        return new Player("Lucas",phone,Position.Mediapunta,equipos);
    }

    /**
     *
     * @param phone id de usuario
     * @return ultimo equipo con el que se ha registrado un jugador
     */
    public Team getLastTeamLogged(String phone) {
        return new Team("Rayo Vaticano",new TeamStats(),new ArrayList<Player>(),new Diary());
    }

    /**
     * Comprueba que un usuario no esté ya registrado para registrarlo
     * @param phone id de usuario
     * @return si no lo está y se puede registrar
     */
    public boolean validSignUp(String phone) {
        return true;
    }

    /**
     * Registra un nuevo jugador en la BBDD
     * @param phone id usuario
     * @param name nombre
     * @param pass contraseña
     * @param position posicion
     * @return jugador que acaba de ser creado
     */
    public Player signUpPlayer(String phone, String name, String pass, Position position) {
        return new Player(name,phone,position);
    }

    /**
     * Comprueba que un nombre concreto no esté ocupado para registrarlo
      * @param teamName
     * @return
     */
    public boolean validCreateTeamName(String teamName) {
        return true;
    }

    /**
     * Permite a un usuario ya identificado crear un equipo
     * @param tName nombre del equipo
     * @param p
     * @return
     */
    public Team createTeam(String tName,Player p) {
        ArrayList<Player> teamComps=new ArrayList<>();
        teamComps.add(p);
        return new Team(tName,teamComps);
    }

    /**
     *
     * @param teamName
     * @param teamMates
     * @return
     */
    public Team createTeam(String teamName, ArrayList<Player> teamMates) {
        return new Team(teamName,teamMates);
    }

    /**
     *
     * @param teamName nombre del equipo
     * @return Información asociada a un equipo
     */
    public Team getTeam(String teamName) {
        return new Team(teamName,new TeamStats(),new ArrayList<Player>(),new Diary());
    }


    /**
     * Guarda una relacion entre un jugador y su nueva imagen
     * @param myPlayerId
     * @param newIm
     */
    public void changePlayerPic(String myPlayerId, Bitmap newIm) {
    }

    /**
     * Guarda una nueva posicion para el jugador en la BBDD
     * @param myPlayerId
     * @param newPos
     */
    public void changePlayerPos(String myPlayerId, Position newPos) {

    }

    /**
     * Permite a un jugador borrar su perfil
     * @param myPlayerId
     */
    public void deleteProfile(String myPlayerId) {
    }

    /**
     * Permite a un jugador ababdonal el equipo que tiene cargado
     * @param myPlayerId
     * @param myTeamName
     */
    public void leavesTeam(String myPlayerId, String myTeamName) {
    }

    /**
     * Permite crear un evento
     * @param myTeamName
     * @param newEvent
     */
    public void createEvent(String myTeamName, MyEvents newEvent) {
    }

    /**
     * Permite crear un partido
     * @param teamName
     * @param newMatch
     */
    public void createMatch(String teamName,Match newMatch) {

    }

    /**
     *
     * @return cierto si un equipo existe y me puedo apuntar a el
     */
    public boolean validEnrollTeamName() {
        return true;
    }

    /**
     * Guarda la relacion entre un equipo y un jugador
     * @param phone
     * @param team
     */
    public void linkTeamAndPlayer(String phone, String team) {

    }
}
