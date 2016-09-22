package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class Diary implements Serializable {
    private ArrayList<MyEvents> eventos;
    private ArrayList<Match> ultimos,proximos;
    private Match prPartido;
}
