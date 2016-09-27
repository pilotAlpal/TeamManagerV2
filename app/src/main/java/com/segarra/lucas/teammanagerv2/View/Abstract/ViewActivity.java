package com.segarra.lucas.teammanagerv2.View.Abstract;

import android.app.Activity;
import android.os.Bundle;


import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.Session;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 26/09/2016.
 */

public abstract class ViewActivity extends Activity implements Session.MyObserver,Serializable{
    protected Controller controller;

    @Override
    public void setController(Controller c){
        controller=c;
        controller.addObserver(this);
    }

    protected void loadController(){
        String key=getString(R.string.controller_code);
        Controller c=(Controller) getIntent().getExtras().getSerializable(key);
        setController(c);
    }
    protected Bundle getControlledBundle(){
        Bundle b=new Bundle();
        String key=getString(R.string.controller_code);
        controller.removeObservers();
        b.putSerializable(key,controller);
        return b;
    }
}
