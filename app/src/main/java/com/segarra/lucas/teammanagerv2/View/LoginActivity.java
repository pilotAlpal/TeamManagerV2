package com.segarra.lucas.teammanagerv2.View;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewActivity;

import java.util.Observable;

public class LogInActivity extends ViewActivity {

    private EditText etPhone,etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etPhone =(EditText) findViewById(R.id.et_li_telefono);
        etPass=(EditText) findViewById(R.id.et_contrasena);

    }

    public void login(View view){
        String telf= etPhone.getText().toString();
        String pass=etPass.getText().toString();
        createAndLoadController();
        controller.logIn(telf,pass);
    }

    public void displaySignIn(View view){
        createAndLoadController();
        Intent signInIntent=new Intent(LogInActivity.this,SignInActivity.class);
        Bundle b=getControlledBundle();
        signInIntent.putExtras(b);
        startActivity(signInIntent);
    }

    @Override
    public void onInvalidLogin() {
        String text=getString(R.string.error_login);
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
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
         Intent homeIntent = new Intent(LogInActivity.this,HomeActivity.class);
         Bundle b=getControlledBundle();
         homeIntent.putExtras(b);
         startActivity(homeIntent);
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
    private void createAndLoadController(){
        Controller aux=new Controller();
        setController(aux);
    }
}
