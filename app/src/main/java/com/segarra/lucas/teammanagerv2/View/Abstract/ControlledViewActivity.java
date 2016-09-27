package com.segarra.lucas.teammanagerv2.View.Abstract;

import android.os.Bundle;

import java.util.Observable;

/**
 * Created by lucas.segarra on 27/09/2016.
 */

public abstract class ControlledViewActivity extends ViewActivity {
    @Override
    public void onCreate(Bundle savedInstance){
        loadController();
        super.onCreate(savedInstance);
    }

}
