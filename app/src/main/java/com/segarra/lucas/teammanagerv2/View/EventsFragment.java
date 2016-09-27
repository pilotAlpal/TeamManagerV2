package com.segarra.lucas.teammanagerv2.View;

import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.EventsInfo;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;

import java.util.Observable;

/**
 * Created by lucas.segarra on 27/09/2016.
 */
public class EventsFragment extends ViewFragment {
    @Override
    public ViewFragment newInstance(Controller controller) {
        return null;
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

    public void fill(EventsInfo eventsInfo) {

    }
}
