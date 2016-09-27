package com.segarra.lucas.teammanagerv2.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 22/09/2016.
 */

public enum MatchResult implements Serializable{
    Won,Drawn,Lost;

    public boolean isWon(){
        if(this.equals(Won))
            return true;
        return false;
    }
    public boolean isDrawn(){
        if(this.equals(Drawn))
            return true;
        return false;
    }
    public boolean isLost(){
        if(this.equals(Lost))
            return true;
        return false;
    }

    public static MatchResult getResult(ArrayList<Gol> golesF, ArrayList<Gol> golesC) {
        int favor=golesF.size(),contra=golesC.size();
        if(favor<contra)
            return Lost;
        if(favor==contra)
            return Drawn;
        return Won;
    }
}
