package com.lost.t_3.domain;

import java.io.Serializable;

public class WeaponsContent implements Serializable {

    private String name, calibr, razrab, constr;
    private int drawableResourse;


    public WeaponsContent() {
    }

    public WeaponsContent(int drawableResourse) {

        this.drawableResourse = drawableResourse;
    }


    public WeaponsContent(String name, String calibr, String razrab, String constr, int drawableResourse) {
        this.name = name;
        this.calibr = calibr;
        this.razrab = razrab;
        this.constr = constr;
        this.drawableResourse = drawableResourse;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalibr() {
        return calibr;
    }

    public void setCalibr(String calibr) {
        this.calibr = calibr;
    }

    public String getRazrab() {
        return razrab;
    }

    public void setRazrab(String razrab) {
        this.razrab = razrab;
    }

    public String getConstr() {
        return constr;
    }

    public void setConstr(String constr) {
        this.constr = constr;
    }

    public int getDrawableResourse() {
        return drawableResourse;
    }

    public void setDrawableResourse(int drawableResourse) {
        this.drawableResourse = drawableResourse;
    }
}
