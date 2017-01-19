package com.tsinghua.edu.model;

import java.sql.Timestamp;

/**
 * Created by root on 16-12-7.
 */
public class Data {
    private int id;
    private float value;
    private Timestamp time;
    private Boolean exception;

    public Data(){
    }

    public Data(int id,float value,Timestamp time,Boolean exception){
        this.id=id;
        this.value=value;
        this.time=time;
        this.exception=exception;
    }

    public int getId(){return id;}
    public Boolean getException(){return exception;}
    public float getValue(){return value;}
    public Timestamp getTime(){return time;}

    public void setId(int id){this.id=id;}
    public void setException(Boolean exception){this.exception=exception;}
    public void setValue(float value){this.value=value;}
    public void setTime(Timestamp time){this.time=time;}
}
