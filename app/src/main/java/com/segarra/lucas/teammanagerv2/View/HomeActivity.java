package com.segarra.lucas.teammanagerv2.View;
import android.os.Bundle;
import android.view.View;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.View.Abstract.ControlledViewActivity;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;

import java.util.Observable;

/**
 * Created by lucas.segarra on 26/09/2016.
 */

public class HomeActivity extends ControlledViewActivity {
    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.activity_home);
    }

    //OPTIONS GUI BUTTONS RESPONSE

    public void playerButton(View view){
        PlayerFragment p=new PlayerFragment().newInstance(controller);
        changeRightFragment(p);
    }
    public void teamButton(View view){
        TeamFragment t=new TeamFragment().newInstance(controller);
        changeRightFragment(t);
    }
    public void eventsButton(View view){
        EventsFragment c=new EventsFragment().newInstance(controller);
        changeRightFragment(c);
    }
    public void logOutButton(View view){
        controller.logOut();
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
    public void update(Observable o, Object arg) {

    }

    private void changeRightFragment(ViewFragment viewFragment){
        getFragmentManager().beginTransaction().replace(R.id.f_info,viewFragment).addToBackStack(null).commit();
    }
}
