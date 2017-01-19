package com.tsinghua.edu.model;

/**
 * Created by root on 16-12-7.
 */
public class Area {
    private int area_id;
    private String area;
    private String subarea;

    public Area(){
    }

    public Area(int area_id,String area,String subarea){
        this.area_id=area_id;
        this.area=area;
        this.subarea=subarea;
    }

    public int getArea_id(){return area_id;}
    public String getArea(){return area;}
    public String getSubarea(){return subarea;}

    public void setArea_id(int area_id){
        this.area_id=area_id;
    }

    public void setArea(String area){
        this.area=area;
    }

    public void setSub_area(String subarea){
        this.subarea=subarea;
    }
}
