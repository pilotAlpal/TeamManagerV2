package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class MyEvents implements Serializable{

    private Time time;
    private String title;
    private Date date;

    public MyEvents(Date d,Time t, String tit){
        time=t;
        title=tit;
        date=d;
    }
    public Date getDate(){return date;}
    public Time getTime(){return time;}
    public String getTitle(){return title;}
}
