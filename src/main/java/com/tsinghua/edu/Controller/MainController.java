package com.tsinghua.edu.Controller;
import com.tsinghua.edu.dao.NodeDao;
import com.tsinghua.edu.model.Data;
import com.tsinghua.edu.model.NodeInfo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 16-12-4.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private NodeDao nodeDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //获取所有节点属性描述表
    @RequestMapping(value = "/sensor/nodeinfo/list", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String showNodeInfo() {
        JSONObject jsonObject=new JSONObject();
        try {
            ArrayList<NodeInfo> node_list = nodeDao.getNodeInfo();
            NodeInfo nodeInfo = null;
            for (int i = 0; i < node_list.size(); i++) {
                nodeInfo = node_list.get(i);
                System.out.println(nodeInfo.getId() + ", " + nodeInfo.getName() + ", "+ nodeInfo.getType() + ", " + nodeInfo.getSubtype() + ", " + nodeInfo.getMin() + ", " + nodeInfo.getMax()+ ", "+ nodeInfo.getArea() + ", " + nodeInfo.getSubarea());
            }
            //json封装
            Map<String,ArrayList<NodeInfo>> map=new HashMap<>();
            map.put("list",node_list);
            jsonObject.put("data",map);
            System.out.println(jsonObject);
        }catch (Exception e){
            return "error";
        }
        return jsonObject.toString();
    }

    //获取所有节点的最新的传感器读数
    @RequestMapping(value = "/sensor/data/latestAll", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String data(ModelMap model) {
        JSONObject jsonObject=new JSONObject();
        try {
            ArrayList<Data> node_list = nodeDao.getAllData();
            Data dt = null;
            for (int i = 0; i < node_list.size(); i++) {
                dt = node_list.get(i);
                model.put("id", dt.getId());
                model.put("value", dt.getValue());
                model.put("time", dt.getTime());
                model.put("exception", dt.getException());
                System.out.println(dt.getId() + ", " + dt.getValue() + ", " + dt.getTime() + ", " + dt.getException());
            }
            //json封装
            Map<String,ArrayList<Data>> map=new HashMap<>();
            map.put("list",node_list);
            jsonObject.put("data",map);
            System.out.println();
        }catch (Exception e){
            return "error";
        }
        return jsonObject.toString();
    }

    //获取指定节点的最新的传感器读数
    @RequestMapping(value = "/sensor/data/latestRange", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String showSpecificData(HttpServletRequest request) {
        JSONObject json=new JSONObject(request.getParameter("param"));
        JSONArray jsonArray=json.getJSONArray("idlist");
        ArrayList<Integer> idLists=new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            idLists.add(jsonArray.getInt(i));
        }
        JSONObject jsonObject=new JSONObject();
        ArrayList<Data> node_list=new ArrayList<>();
        try {
            for(int i=0;i<idLists.size();i++) {
                int nodeSpec = idLists.get(i);
                node_list.addAll(nodeDao.getSpecificData(nodeSpec));
            }
            //json封装
            Map<String,ArrayList<Data>> map=new HashMap<>();
            map.put("list",node_list);
            jsonObject.put("data",map);
            System.out.println(jsonObject);
        }catch (Exception e){
            return "error";
        }
        return jsonObject.toString();
    }

    //获取指定节点指定时间范围的传感器读数
    @RequestMapping(value = "/sensor/data/range", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String showDurationData(HttpServletRequest request) {
        JSONObject json=new JSONObject(request.getParameter("param"));
        JSONArray jsonArray=json.getJSONArray("idlist");
        ArrayList<Integer> idLists=new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            idLists.add(jsonArray.getInt(i));
        }
        String startTime = json.getString("starttime");
        String endTime = json.getString("endtime");
        JSONObject jsonObject=new JSONObject();
        ArrayList<Data> node_list=new ArrayList<>();
        try {
            Timestamp st = Timestamp.valueOf(startTime);
            Timestamp et = Timestamp.valueOf(endTime);
            for(int i=0;i<idLists.size();i++){
                int node_id_spec=idLists.get(i);
                node_list.addAll(nodeDao.getDurationData(node_id_spec, st, et));
            }
            //json封装
            Map<String,ArrayList<Data>> map=new HashMap<>();
            map.put("list",node_list);
            jsonObject.put("data",map);
            System.out.println(jsonObject);
        }catch (Exception e){
            return "error";
        }
        return jsonObject.toString();
    }

    //获取对应类型的传感器节点ID
    @RequestMapping(value = "/sensor/search/type", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String showNodeType(HttpServletRequest request) {
        JSONObject json=new JSONObject(request.getParameter("param"));
        String type = json.getString("type");
        String sub_type = json.getString("subtype");
        JSONObject jsonObject=new JSONObject();
        try {
            ArrayList<Integer> node_list=nodeDao.getNodeType(type,sub_type);
            //json封装
            Map<String,ArrayList<Integer>> map=new HashMap<>();
            map.put("list",node_list);
            jsonObject.put("data",map);
            System.out.println(jsonObject);
        }catch (Exception e){
            return "error";
        }
        return jsonObject.toString();
    }

    //获取对应区域的传感器节点ID
    @RequestMapping(value = "/sensor/search/area", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String showNodeArea(HttpServletRequest request) {
        JSONObject json=new JSONObject(request.getParameter("param"));
        String area=json.getString("area");
        String sub_area=json.getString("subarea");
        JSONObject jsonObject=new JSONObject();
        try {
            ArrayList<Integer> node_list=nodeDao.getNodeArea(area,sub_area);
            //json封装
            Map<String,ArrayList<Integer>> map=new HashMap<>();
            map.put("list",node_list);
            jsonObject.put("data",map);
            System.out.println(jsonObject);
        }catch (Exception e){
            return "error";
        }
        return jsonObject.toString();
    }

    //GET,POST
    @RequestMapping(value = "/sensor/data/input",method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
    public String addData(HttpServletRequest request) {
        if ("GET".equals(request.getMethod())) {
            return "input";
        } else {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                float value = Float.parseFloat(request.getParameter("value"));
                Timestamp st = Timestamp.valueOf(request.getParameter("time"));
                Boolean exception = Boolean.valueOf(request.getParameter("exception"));
                Data dt = new Data(id, value, st, exception);
                nodeDao.addData(dt);
            } catch (Exception e) {
                return "error";
            }
            return "success";
        }
    }

    //传感器节点健康评分模型
    @RequestMapping(value = "/sensor/data/state", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String showSensorState() {
        //
        JSONObject jsonObject=new JSONObject();
        return jsonObject.toString();
    }
}
