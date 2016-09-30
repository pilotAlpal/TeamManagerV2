package com.segarra.lucas.teammanagerv2.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;

import java.util.Observable;

/**
 * Created by lucas.segarra on 26/09/2016.
 */

public class OptionsFragment extends ViewFragment {

    private Button playerButton,teamButton,eventsButton,leaveButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.fragment_options,viewGroup,false);
        playerButton= (Button) v.findViewById(R.id.b_stats_jug);
        playerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.showMyPlayerProfile();
            }
        });
        teamButton=(Button) v.findViewById(R.id.b_stats_eq);
        teamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.showMyTeamProfile();
            }
        });
        eventsButton=(Button)v.findViewById(R.id.b_calendario);
        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.showEvents();
            }
        });
        leaveButton=(Button)v.findViewById(R.id.b_salir);
        leaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.logOut();
            }
        });
        NextMatchFragment nextMatchFragment=new NextMatchFragment().newInstance(controller);
        getFragmentManager().beginTransaction().replace(R.id.fr_next_match, nextMatchFragment).commit();
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
    public void update(Observable o, Object arg) {

    }

    @Override
    public OptionsFragment newInstance(Controller controller) {
        OptionsFragment optionsFragment=new OptionsFragment();
        optionsFragment.setController(controller);
        return optionsFragment;
    }
}
