package com.segarra.lucas.teammanagerv2.Model;

/**
 * Created by lucas.segarra on 22/09/2016.
 */

public interface MyObservable<T> {
    public void addObserver(T observer);
    public void delObserver(T observer);
}
