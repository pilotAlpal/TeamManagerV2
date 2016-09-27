package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 27/09/2016.
 */

public class Message implements Serializable {
    private String text;
    public Message(String t){
        text=t;
    }
    public String getText(){
        return text;
    }
}
