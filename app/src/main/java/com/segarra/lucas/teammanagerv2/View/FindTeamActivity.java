package com.segarra.lucas.teammanagerv2.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewActivity;

import java.util.Observable;

/**
 * Created by lucas.segarra on 30/09/2016.
 */
public class FindTeamActivity extends ViewActivity {
    private EditText etTeamName;
    private Button save;


    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.layout_load_teams);
        etTeamName=(EditText)findViewById(R.id.et_team_name);
        save=(Button)findViewById(R.id.b_register_team);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.joinTeam(etTeamName.getText().toString());
            }
        });
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
