package com.tsinghua.edu.model;

/**
 * Created by lhz_bryant on 2017/1/16.
 */
public class NetPackage {
    private int package_id;
    private String sequence;
    private String type;
    private int source_id;
    private float chip_temp;
    private float chip_volt;
    private int hopcount;

    NetPackage(){

    }

    NetPackage(int package_id,String sequence,String type,int source_id,float chip_temp,float chip_volt,int hopcount){
        this.package_id=package_id;
        this.sequence=sequence;
        this.type=type;
        this.source_id=source_id;
        this.chip_temp=chip_temp;
        this.chip_volt=chip_volt;
        this.hopcount=hopcount;
    }

    public int getPackage_id(){return package_id;}
    public String getSequence(){return sequence;}
    public String getType(){return type;}
    public int getSource_id(){return source_id;}
    public float getChip_temp(){return chip_temp;}
    public float getChip_volt(){return chip_volt;}
    public int getHopcount(){return hopcount;}

    public void setPackage_id(int package_id){this.package_id=package_id;}
    public void setSequence(String sequence){this.sequence=sequence;}
    public void setType(String type){this.type=type;}
    public void setSource_id(int source_id){this.source_id=source_id;}
    public void setChip_temp(float chip_temp){this.chip_temp=chip_temp;}
    public void setChip_volt(float chip_volt){this.chip_volt=chip_volt;}
    public void setHopcount(int hopcount){this.hopcount=hopcount;}
}
