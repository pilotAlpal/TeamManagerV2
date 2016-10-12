package com.segarra.lucas.teammanagerv2.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.PlayerStats;
import com.segarra.lucas.teammanagerv2.Model.Position;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by lucas.segarra on 28/09/2016.
 */

public class EditProfileFragment extends ViewFragment {

    private ArrayList<String> teams;
    private String loadedTeam;
    private Position chosenPos;
    private Spinner spPos,spTeam;
    private Button save,searchTeam,createTeam,errase,leaveTeam;

    @Override
    public EditProfileFragment newInstance(Controller controller) {
        EditProfileFragment editProfileFragment=new EditProfileFragment();
        editProfileFragment.setController(controller);
        controller.fillData(editProfileFragment);
        return editProfileFragment;
    }

    public void fill(PlayerStats myPlayerStats) {
        loadedTeam=myPlayerStats.getLoadedTeam();
        chosenPos=myPlayerStats.getPosition();
        teams=myPlayerStats.getTeams();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.edit_profile_view, container, false);
        spPos=(Spinner)v.findViewById(R.id.sp_pos);
        final ArrayAdapter<Position> adapter=new ArrayAdapter<Position>(getActivity(),android.R.layout.simple_spinner_item,Position.values());
        spPos.setAdapter(adapter);
        spPos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                controller.changePos(adapter.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spTeam=(Spinner)v.findViewById(R.id.sp_equipo);
        final  ArrayAdapter<String> adEquipos=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,teams);
        spTeam.setAdapter(adEquipos);
        spTeam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                controller.changeTeam(adEquipos.getItem(i));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        save=(Button)v.findViewById(R.id.b_ep_guarda_cambios);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.saveProfileChanges((Position)spPos.getSelectedItem(),(String)spTeam.getSelectedItem());
            }
        });
        searchTeam=(Button)v.findViewById(R.id.b_ep_busca_equipo);
        searchTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.showSearchTeam();
            }
        });
        createTeam=(Button)v.findViewById(R.id.b_crea_equipo);
        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.showNewTeam();
            }
        });
        errase=(Button)v.findViewById(R.id.b_ep_borrar);
        errase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.deletePlayerProfile();
            }
        });
        leaveTeam=(Button)v.findViewById(R.id.b_ep_abandonar);
        leaveTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.leaveTeam();
            }
        });
        return v;
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
    public void onChangesSaved() {

    }

    @Override
    public void update(Observable o, Object arg) {

    }


}
