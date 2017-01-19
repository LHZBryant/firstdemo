package com.tsinghua.edu.model;

/**
 * Created by lhz_bryant on 2017/1/16.
 */
public class Neighbor {
    private int node_id;
    private float rssi;
    private float lqi;
    private int etx;

    Neighbor(){
    }

    Neighbor(int node_id,float rssi,float lqi,int etx){
        this.node_id=node_id;
        this.rssi=rssi;
        this.lqi=lqi;
        this.etx=etx;
    }

    public int getNode_id(){return node_id;}
    public float getRssi(){return rssi;}
    public float getLqi(){return lqi;}
    public int getEtx(){return etx;}

    public void setNode_id(int node_id){this.node_id=node_id;}
    public void setRssi(int rssi){this.rssi=rssi;}
    public void setLqi(int lqi){this.lqi=lqi;}
    public void setEtx(int etx){this.etx=etx;}
}
