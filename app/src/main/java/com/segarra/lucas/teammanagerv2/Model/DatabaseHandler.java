package com.segarra.lucas.teammanagerv2.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;
import com.segarra.lucas.teammanagerv2.Model.MyUtils;
class DatabaseHandler implements Serializable{

    /**
     * Comprueba si un id de usuario (teléfono) se corresponde con una contraseña.
     * @param phone idUsuario
     * @param pass contraseña
     * @return si la información de inicio de sesión es correcta
     */
    boolean validLogin(String phone, String pass) {
        return true;
    }

    /**
     *
     * @param phone id de usuario
     * @return el jugador asociado a un teléfono
     */
    Player getPlayer(String phone) {
        return MyUtils.getSamplePlayer(phone);
    }

    /**
     *
     * @param phone id de usuario
     * @return ultimo equipo con el que se ha registrado un jugador
     */
    Team getLastTeamLogged(String phone) {
        return MyUtils.getSampleTeam();
    }

    /**
     * Comprueba que un usuario no esté ya registrado para registrarlo
     * @param phone id de usuario
     * @return si no lo está y se puede registrar
     */
    boolean validSignUp(String phone) {
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
    Player signUpPlayer(String phone, String name, String pass, Position position) {
        return MyUtils.getSamplePlayer(phone,name,position,new ArrayList<String>());
    }

    /**
     * Comprueba que un nombre concreto no esté ocupado para registrarlo
      * @param teamName
     * @return
     */
    boolean validCreateTeamName(String teamName) {
        return true;
    }


    /**
     *
     * @param teamName
     * @param teamMates
     * @return
     */
    Team createTeam(String teamName, ArrayList<Player> teamMates) {
        return MyUtils.getSampleTeam(teamName,teamMates);
    }

    /**
     *
     * @param teamName nombre del equipo
     * @return Información asociada a un equipo
     */
    Team getTeam(String teamName) {
        return MyUtils.getSampleTeam(teamName);
    }


    /**
     * Guarda una relacion entre un jugador y su nueva imagen
     * @param myPlayerId
     * @param newIm
     */
    void changePlayerPic(String myPlayerId, Bitmap newIm) {
    }

    /**
     * Guarda una nueva posicion para el jugador en la BBDD
     * @param myPlayerId
     * @param newPos
     */
    void changePlayerPos(String myPlayerId, Position newPos) {

    }

    /**
     * Permite a un jugador borrar su perfil
     * @param myPlayerId
     */
    void deleteProfile(String myPlayerId) {
    }

    /**
     * Permite a un jugador ababdonal el equipo que tiene cargado
     * @param myPlayerId
     * @param myTeamName
     */
    void leavesTeam(String myPlayerId, String myTeamName) {
    }

    /**
     * Permite crear un evento
     * @param myTeamName
     * @param newEvent
     */
    void createEvent(String myTeamName, MyEvents newEvent) {
    }

    /**
     * Permite crear un partido
     * @param teamName
     * @param newMatch
     */
    void createMatch(String teamName,Match newMatch) {

    }

    /**
     *
     * @return cierto si un equipo existe y me puedo apuntar a el
     */
    boolean validEnrollTeamName() {
        return true;
    }

    /**
     * Guarda la relacion entre un equipo y un jugador
     * @param phone
     * @param team
     */
    void linkTeamAndPlayer(String phone, String team) {

    }

    void addToNextMatch(Player jugador) {
    }

    void removeFromNextMatch(Player jugador) {
    }

    void saveProfileChanges(String myPlayerId, Position p, String team) {

    }
}
