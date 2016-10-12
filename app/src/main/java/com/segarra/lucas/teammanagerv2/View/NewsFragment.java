package com.segarra.lucas.teammanagerv2.View;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.MyMessage;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;
import com.segarra.lucas.teammanagerv2.View.Adapters.NewsListAdapter;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by lucas.segarra on 27/09/2016.
 */
public class NewsFragment extends ViewFragment {
    private ArrayList<MyMessage> conversation;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_news,viewGroup,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.rv_news);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager  myLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(myLayoutManager);
        RecyclerView.Adapter adapter=new NewsListAdapter(conversation);
        recyclerView.setAdapter(adapter);

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

    public void fill(ArrayList<MyMessage> teamMessages) {
        conversation=teamMessages;

    }

    @Override
    public NewsFragment newInstance(Controller controller) {
        NewsFragment newsFragment=new NewsFragment();
        newsFragment.setController(controller);
        controller.fillData(newsFragment);
        return newsFragment;
    }
}
