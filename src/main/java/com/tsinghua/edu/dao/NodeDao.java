package com.tsinghua.edu.dao;

import com.tsinghua.edu.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by root on 16-12-7.
 */
public interface NodeDao {

    //获取所有节点的最新的传感器读数
    @Select("with t as (select id,max(time)as time from data group by id) " +
            "select t.id,value,t.time,exception from t join data on t.id=data.id and t.time=data.time;")
    ArrayList<Data> getAllData();

    //获取所有节点的属性描述
    @Select("with temp_table as (select id,name,area_id,type,subtype,min,max\n" +
            "from node join type on node.type_id=type.type_id)\n" +
            "select id,name,type,subtype,area,subarea,min,max\n" +
            "from temp_table join area on temp_table.area_id=area.area_id")
    ArrayList<NodeInfo> getNodeInfo();

    //获取指定节点的最新的传感器读数
    @Select("with t as (select id,max(time)as time from data where id=#{id_spec} group by id) " +
            "select t.id,value,t.time,exception from t join data on t.id=data.id and t.time=data.time;")
    ArrayList<Data> getSpecificData(@Param("id_spec")int id_spec);

    //获取指定节点指定时间范围的传感器读数
    @Select("select * from data where id=#{id_spec} and time>#{startTime} and time<#{endTime}")
    ArrayList<Data> getDurationData(@Param("id_spec")int id_spec, @Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);

    //获取对应类型的传感器节点ID
    @Select(" select id from node join type on node.type_id=type.type_id and type.type=#{type} and subtype=#{subtype}")
    ArrayList<Integer> getNodeType(@Param("type")String type,@Param("subtype")String subtype);

    //获取对应区域的传感器节点ID
    @Select(" select id from node join area on node.area_id=area.area_id and area.area=#{area} and subarea=#{subarea}")
    ArrayList<Integer> getNodeArea(@Param("area")String area,@Param("subarea")String subarea);

    @Select("select * from node")
    ArrayList<Node> getNode();

    //向Node表中插入数据
    @Insert("insert into node (id,type_id,name,area_id,parent_id) VALUES (#{id},#{type_id},#{name},#{area_id},#{parent_id})")
    void addNode(Node nd);

    //向Data表中插入数据
    @Insert("insert into data (id,value,time,exception) VALUES (#{id},#{value},#{time},#{exception})")
    void addData(Data dt);

    //向Type表中插入数据
    @Insert("insert into type (type_id,type,subtype,min,max) VALUES (#{type_id},#{type},#{subtype},#{min},#{max})")
    void addType(Type tp);

    //向Area表中插入数据
    @Insert("insert into area (area_id,area,subarea) VALUES (#{area_id},#{area},#{subarea})")
    void addArea(Area area);

    //获取NetPackage表中源节点id及其相应邻居节点id

}
