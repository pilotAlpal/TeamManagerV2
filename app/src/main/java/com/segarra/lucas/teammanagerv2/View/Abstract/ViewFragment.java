package com.segarra.lucas.teammanagerv2.View.Abstract;

import android.app.Fragment;

import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.Model.EventsInfo;
import com.segarra.lucas.teammanagerv2.Model.Session;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 26/09/2016.
 */

public abstract class ViewFragment extends Fragment implements Session.MyObserver,Serializable {
    protected Controller controller;

    @Override
    public void setController(Controller c){
        controller=c;
        controller.addObserver(this );
    }

    public abstract ViewFragment newInstance(Controller controller);



}
