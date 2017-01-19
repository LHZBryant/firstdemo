package com.tsinghua.edu.model;

/**
 * Created by lhz_bryant on 2017/1/16.
 */
public class Path {
    private int package_id;
    private int hop;

    Path(){
    }

    Path(int package_id,int hop){
        this.package_id=package_id;
        this.hop=hop;
    }

    public int getPackage_id(){return package_id;}
    public int getHop(){return hop;}

    public void setPackage_id(int package_id){this.package_id=package_id;}
    public void setHop(int hop){this.hop=hop;}
}
