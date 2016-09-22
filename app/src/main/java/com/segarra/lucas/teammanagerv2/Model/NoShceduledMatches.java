package com.segarra.lucas.teammanagerv2.Model;

import android.os.SystemClock;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Propietario on 22/09/2016.
 */
public class NoShceduledMatches extends Match {
    public NoShceduledMatches() {
        super(Calendar.getInstance().getTime(), new Time(SystemClock.currentThreadTimeMillis()));
    }
}
