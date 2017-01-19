package com.tsinghua.edu.model;

/**
 * Created by root on 16-12-7.
 */
public class Node {
    private int id;
    private int type_id;
    private String name;
    private int area_id;
    private int parent_id;

    public Node(){
    }

    public Node(int id,int type_id,String name,int area_id,int parent_id){
        this.id=id;
        this.type_id=type_id;
        this.name=name;
        this.area_id=area_id;
        this.parent_id=parent_id;
    }

    public int getId(){return id;}
    public int getType_id(){return type_id;}
    public int getArea_id(){return area_id;}
    public String getName(){return name;}
    public int getParent_id(){return parent_id;}

    public void setNode_id(int id){this.id=id;}
    public void setArea_id(int area_id){this.area_id=area_id;}
    public void setVrname(String name){this.name=name;}
    public void setType_id(int type_id){this.type_id=type_id;}
    public void setParent_id(int parent_id){this.parent_id=parent_id;}
}
