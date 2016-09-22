package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Created by lucas.segarra on 22/09/2016.
 */
public class MyEvents implements Serializable{
    private Date date;
    private Time time;

    public MyEvents(Date d,Time t){
        date=d;time=t;
    }
    public Date getDate(){return date;}
    public Time getTime(){return time;}
}
