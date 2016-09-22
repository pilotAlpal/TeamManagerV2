package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class Team implements Serializable{
    private String name;
    private TeamStats info;
    private ArrayList<Player> players;
    private Diary agenda;
}
