package com.manager.util;

import com.manager.pojo.GradeInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPageHelper {
    public static Map<String,Object> myPageHelper(Map<String,Object> params, List data){
        Map<String,Object> res = new HashMap<>();
        int from =((Integer)params.get("pageIndex")-1)*((Integer)params.get("pageSize"));
        int to = ((Integer)params.get("pageIndex"))*((Integer)params.get("pageSize"));
        //小小地实现一下分页，就不用pagehelper了
        res.put("data",data.subList(from,to>data.size()?data.size():to));
        res.put("pagetotal",data.size());
        return  res;
    }
    public static Map<String,Object> myPageHelper(Map<String,String> params, ArrayList data){
        Map<String,Object> res = new HashMap<>();
        int from =(Integer.parseInt(params.get("pageIndex"))-1)*(Integer.parseInt(params.get("pageSize")));
        int to = (Integer.parseInt(params.get("pageIndex")))*(Integer.parseInt(params.get("pageSize")));
        //小小地实现一下分页，
        res.put("data",data.subList(from, Math.min(to, data.size())));
        res.put("pagetotal",data.size());
        return  res;
    }
}
