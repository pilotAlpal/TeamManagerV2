package com.segarra.lucas.teammanagerv2.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.Position;

import com.segarra.lucas.teammanagerv2.View.Abstract.ControlledViewActivity;


import java.util.Observable;

/**
 * Created by lucas.segarra on 26/09/2016.
 */

public class SignInActivity extends ControlledViewActivity {

    private Spinner spPos;
    private EditText etNombre,etContrasena,etEquipo,etTelefono;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        spPos=(Spinner) findViewById(R.id.sp_si_pos);
        Position[] pos= controller.getPlayersPositions();
        ArrayAdapter<Position> adapter=new ArrayAdapter<Position>(this,android.R.layout.simple_spinner_item,pos);
        spPos.setAdapter(adapter);
        etNombre=(EditText) findViewById(R.id.et_si_nomUsuario);
        etContrasena=(EditText) findViewById(R.id.et_si_contrasena);
        etEquipo=(EditText) findViewById(R.id.et_si_equipo);
        etTelefono=(EditText) findViewById(R.id.et_si_telefono);
    }

    public void signIn(View view){
        String phone=etTelefono.getText().toString(),
                name=etNombre.getText().toString(),team=etEquipo.getText().toString(),
                pass=etContrasena.getText().toString();
        Position pos=(Position) spPos.getSelectedItem();
        if(team.equalsIgnoreCase(""))
            controller.signUp(phone,name,pass,pos);
        else
            controller.signUp(phone,name,pass,pos,team);
    }

    @Override
    public void onInvalidLogin() {

    }

    @Override
    public void onInvalidSignUp() {
        String errMsg=getString(R.string.error_signin);
        Toast.makeText(this,errMsg,Toast.LENGTH_SHORT).show();
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
        Intent homeIntent = new Intent(SignInActivity.this,HomeActivity.class);
        Bundle b=getControlledBundle();
        homeIntent.putExtras(b);
        startActivity(homeIntent);
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
