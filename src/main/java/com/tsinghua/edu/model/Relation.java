package com.tsinghua.edu.model;

/**
 * Created by lhz_bryant on 2017/1/16.
 */
public class Relation {
    private int package_id;
    private int node_id;

    Relation(){
    }

    Relation(int package_id,int node_id){
        this.package_id=package_id;
        this.node_id=node_id;
    }

    public int getPackage_id(){return package_id;}
    public int getNode_id(){return node_id;}

    public void setPackage_id(int package_id){this.package_id=package_id;}
    public void setNode_id(int node_id){this.node_id=node_id;}
}
