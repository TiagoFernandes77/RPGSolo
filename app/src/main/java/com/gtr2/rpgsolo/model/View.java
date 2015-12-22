package com.gtr2.rpgsolo.model;

import java.util.List;

/**
 * Created by Tiago on 21/12/2015.
 */
public class View {
    private int id;
    private List<Action> actions;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions){
        this.actions = actions;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}