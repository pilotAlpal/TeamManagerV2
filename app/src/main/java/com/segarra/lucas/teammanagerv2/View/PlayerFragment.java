package com.segarra.lucas.teammanagerv2.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.PlayerStats;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;

import java.util.Observable;

/**
 * Created by lucas.segarra on 27/09/2016.
 */
public class PlayerFragment extends ViewFragment {

    private ImageView imageView;
    private RatingBar ratingBar;
    private TextView nomUsuario,nomEquipo,posicion,dorsal,
                    goles,asisitencias,expulsiones,jugados;
    private PlayerStats playerStats;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View main= inflater.inflate(R.layout.fragment_player,viewGroup,false);
        View aux= main.findViewById(R.id.img_layout);
        imageView=(ImageView) aux.findViewById(R.id.imageView);
        aux=main.findViewById(R.id.rating_layout);
        ratingBar=(RatingBar)aux.findViewById(R.id.ratingBar);
        aux=main.findViewById(R.id.player_stats_layout);
        nomUsuario=(TextView)aux.findViewById(R.id.tv_nom_usuario);
        nomEquipo=(TextView)aux.findViewById(R.id.tv_nom_equipo);
        posicion=(TextView)aux.findViewById(R.id.tv_pos);
        dorsal=(TextView)aux.findViewById(R.id.tv_dorsal);
        goles=(TextView)aux.findViewById(R.id.tv_goles);
        asisitencias=(TextView)aux.findViewById(R.id.tv_asistencias);
        expulsiones=(TextView)aux.findViewById(R.id.tv_expulsiones);
        jugados=(TextView)aux.findViewById(R.id.tv_jugados);
        ratingBar.setRating(playerStats.getRating());
        nomUsuario.setText(playerStats.getName());
        nomEquipo.setText(playerStats.getLoadedTeam());
        posicion.setText(playerStats.getPosition().toString());
        String aux1=String.valueOf(playerStats.getNumber());
        dorsal.setText(aux1);
        aux1=String.valueOf(playerStats.getNumber());
        goles.setText(aux1);
        aux1=String.valueOf(playerStats.getAsists());
        asisitencias.setText(aux1);
        aux1=String.valueOf(playerStats.getExpulsions());
        expulsiones.setText(aux1);
        aux1=String.valueOf(playerStats.getPlayed());
        jugados.setText(aux1);
        EditProfileFragment editProfileFragment= new EditProfileFragment().newInstance(controller);
        getFragmentManager().beginTransaction().replace(R.id.edit_prof_fragment,editProfileFragment).commit();
        return main;
    }

    public  PlayerFragment newInstance(Controller controller) {
        PlayerFragment p=new PlayerFragment();
        p.setController(controller);
        controller.fillData(p);
        return p;
    }

    public void fill(PlayerStats pS) {
        playerStats=pS;
    }


    @Override
    public void onInvalidLogin() {

    }

    @Override
    public void onInvalidSignUp() {

    }

    @Override
    public void onInvalidCreateTeamName() {

    }

    @Override
    public void onNoTeamUser() {

    }

    @Override
    public void onLogged() {

    }

    @Override
    public void onSigned() {

    }

    @Override
    public void onTeamCreated() {

    }

    @Override
    public void onPictureChanged() {

    }

    @Override
    public void onTeamChanged() {

    }

    @Override
    public void onMatchCreated() {

    }

    @Override
    public void onInvalidEnrollTeamName() {

    }

    @Override
    public void onMyPlayerProfile() {

    }

    @Override
    public void onMyTeamProfile() {

    }

    @Override
    public void onEvents() {

    }

    @Override
    public void onTeamSearch() {

    }

    @Override
    public void onNewTeam() {

    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
