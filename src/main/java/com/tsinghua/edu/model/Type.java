package com.tsinghua.edu.model;

/**
 * Created by root on 16-12-7.
 */
public class Type {
    private int type_id;
    private String type;
    private String subtype;
    private float min;
    private float max;

    public Type(){
    }

    public Type(int type_id,String type,String subtype,float min,float max){
        this.type_id=type_id;
        this.type=type;
        this.subtype=subtype;
        this.max=max;
        this.min=min;
    }

    public int getType_id(){return type_id;}
    public String getType(){return type;}
    public String getSubtype(){return subtype;}
    public float getMin(){return min;}
    public float getMax(){return max;}

    public void setType_id(int type_id){
        this.type_id=type_id;
    }

    public void setType(String type){
        this.type=type;
    }

    public void setSubtype(String subtype){
        this.subtype=subtype;
    }

    public void setMin(float min){
        this.min=min;
    }

    public void setMax(float max){
        this.max=max;
    }
}
