package com.segarra.lucas.teammanagerv2.View;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.EventsInfo;
import com.segarra.lucas.teammanagerv2.Model.Match;
import com.segarra.lucas.teammanagerv2.Model.MyEvents;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;
import com.segarra.lucas.teammanagerv2.View.Adapters.EventsListAdapter;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by lucas.segarra on 27/09/2016.
 */
public class EventsFragment extends ViewFragment {

    private RecyclerView myRecycler;
    private CardView myCard;
    private ArrayList<MyEvents> myEventses;
    private ArrayList<Match> last,next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.fragment_events,viewGroup,false);
        myCard=(CardView)v.findViewById(R.id.cv_matches);
        myRecycler=(RecyclerView)v.findViewById(R.id.rv_next_matches);
        myRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager rVlM=new LinearLayoutManager(getActivity());
        myRecycler.setLayoutManager(rVlM);
        RecyclerView.Adapter adapter=new EventsListAdapter(myEventses);
        myRecycler.setAdapter(adapter);
        return v;
    }
    @Override
    public EventsFragment newInstance(Controller controller) {
        EventsFragment eventsFragment=new EventsFragment();
        eventsFragment.setController(controller);
        controller.fillData(eventsFragment);
        return eventsFragment;
    }

    public void fill(EventsInfo eventsInfo, ArrayList<Match> lastMatches, ArrayList<Match> nextMatches) {
        myEventses=eventsInfo.getEvents();
        last=lastMatches;next=nextMatches;
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
