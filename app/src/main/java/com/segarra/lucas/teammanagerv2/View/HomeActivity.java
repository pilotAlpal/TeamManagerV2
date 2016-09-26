package com.segarra.lucas.teammanagerv2.View;
import android.os.Bundle;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewActivity;

import java.util.Observable;

/**
 * Created by lucas.segarra on 26/09/2016.
 */

public class HomeActivity extends ViewActivity {
    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.activity_home);
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
}
