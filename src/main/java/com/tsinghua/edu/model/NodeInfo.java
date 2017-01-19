package com.tsinghua.edu.model;

/**
 * Created by root on 16-12-7.
 */
public class NodeInfo {
    private int id;
    private String name;
    private String type;
    private String subtype;
    private float min;
    private float max;
    private String area;
    private String subarea;

    public NodeInfo(){
    }

    public NodeInfo(int id,String name,String type,String subtype,float min,float max,String area,String subarea){
        this.id=id;
        this.name=name;
        this.type=type;
        this.subtype=subtype;
        this.area=area;
        this.subarea=subarea;
        this.min=min;
        this.max=max;
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public String getType(){return type;}
    public String getSubtype(){return subtype;}
    public String getArea(){return area;}
    public String getSubarea(){return subarea;}
    public float getMin(){return min;}
    public float getMax(){return max;}

    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setArea(String area){this.area=area;}
    public void setSubarea(String subarea){this.subarea=subarea;}
    public void setSubtype(String subtype){this.subtype=subtype;}
    public void setType(String type){this.type=type;}
    public void setMax(float max){this.max=max;}
    public void setMin(float min){this.min=min;}
}
