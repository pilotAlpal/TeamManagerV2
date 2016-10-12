package com.segarra.lucas.teammanagerv2.View;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;


import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.MatchInfo;
import com.segarra.lucas.teammanagerv2.Model.Player;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;
import com.segarra.lucas.teammanagerv2.View.Adapters.PlayersListAdapter;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by lucas.segarra on 26/09/2016.
 */

public class NextMatchFragment extends ViewFragment {


    private ArrayList<Player> nextConvocatory;
    private TextView rNam,nConv;
    private RecyclerView recyclerView;
    private ToggleButton acudir;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.fragment_next_match,viewGroup,false);
        rNam=(TextView)v.findViewById(R.id.tv_prox_rival);
        acudir=(ToggleButton)v.findViewById(R.id.toggleButton);
        acudir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    controller.addToNextMatch();
                else controller.removeFromNextMatch();
            }
        });
        nConv=(TextView)v.findViewById(R.id.tv_n_confirmados);
        recyclerView=(RecyclerView) v.findViewById(R.id.rv_players_layout);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager  myLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(myLayoutManager);
        RecyclerView.Adapter adapter=new PlayersListAdapter(nextConvocatory);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public void fill(MatchInfo nextMatchInfo) {
        nextConvocatory=nextMatchInfo.getConvocatory();
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

    @Override
    public NextMatchFragment newInstance(Controller controller) {
        NextMatchFragment nextMatchFragment=new NextMatchFragment();
        nextMatchFragment.setController(controller);
        controller.fillData(nextMatchFragment);
        return nextMatchFragment;
    }

}
