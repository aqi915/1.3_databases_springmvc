package com.kingtop.databases.mongodb.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public void sheet() {
        // 表单名
        String tName = "tableOne";
        
        // 表头行列名
        ArrayList<String> tHeader = new ArrayList<String>();
        tHeader.add("编号");
        tHeader.add("姓名");
        tHeader.add("性别(is Man?)");
        tHeader.add("年龄");
        
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue1 = new ArrayList<Object>();
        tValue1.add(1);
        tValue1.add("Feleon");
        tValue1.add(true);
        tValue1.add("21");    
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue2 = new ArrayList<Object>();
        tValue2.add(2);
        tValue2.add("Iravy");
        tValue2.add(false);
        tValue2.add("18");
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue3 = new ArrayList<Object>();
        tValue3.add(3);
        tValue3.add("Helly");
        tValue3.add(false);
        tValue3.add("18");
        ArrayList<ArrayList<Object>> tValue = new ArrayList<ArrayList<Object>>();
        tValue.add(tValue1);
        tValue.add(tValue2);
        tValue.add(tValue3);
        
        // 表头样式
        Map<String, Short> tHeaderStyle = new HashMap<String, Short>();
        tHeaderStyle.put("color", (short)10);
        tHeaderStyle.put("weight", (short)700);
        
        // 表数据样式
        Map<String, Short> tValueStyle = new HashMap<String, Short>();
        tValueStyle.put("color", (short)32767);
        tValueStyle.put("weight", (short)400);

        String filePath = "F:/demo.xls";
        
        try {
            ExcelUtil.newInstance().exportExcel(tName, tHeader,
                    tValue, tHeaderStyle,
                    tValueStyle, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void sheets() {
        
        // 表单名
        ArrayList<String> tName = new ArrayList<String>();
        tName.add("tableOne");
        tName.add("tableTwo");
        
        // 表头行列名1, 2
        ArrayList<String> tHeader1 = new ArrayList<String>();
        tHeader1.add("编号1");
        tHeader1.add("姓名1");
        tHeader1.add("性别1(is Man?)");
        tHeader1.add("年龄1");
        ArrayList<String> tHeader2 = new ArrayList<String>();
        tHeader2.add("编号2");
        tHeader2.add("姓名2");
        tHeader2.add("性别2(is Man?)");
        tHeader2.add("年龄2");
        
        // 表头行列名
        ArrayList<ArrayList<String>> tHeader = new ArrayList<ArrayList<String>>();
        tHeader.add(tHeader1);
        tHeader.add(tHeader2);
        
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue1 = new ArrayList<Object>();
        tValue1.add(1);
        tValue1.add("Feleon");
        tValue1.add(true);
        tValue1.add("21");    
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue2 = new ArrayList<Object>();
        tValue2.add(2);
        tValue2.add("Iravy");
        tValue2.add(false);
        tValue2.add("18");
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue3 = new ArrayList<Object>();
        tValue3.add(3);
        tValue3.add("Helly");
        tValue3.add(false);
        tValue3.add("18");
        ArrayList<ArrayList<Object>> tValueb = new ArrayList<ArrayList<Object>>();
        tValueb.add(tValue1);
        tValueb.add(tValue2);
        tValueb.add(tValue3);
        
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue11 = new ArrayList<Object>();
        tValue11.add(1);
        tValue11.add("Feleon11");
        tValue11.add(true);
        tValue11.add("21");    
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue21 = new ArrayList<Object>();
        tValue21.add(2);
        tValue21.add("Iravy11");
        tValue21.add(false);
        tValue21.add("18");
        // 表单数据(除表头) - 行
        ArrayList<Object> tValue31 = new ArrayList<Object>();
        tValue31.add(3);
        tValue31.add("Helly11");
        tValue31.add(false);
        tValue31.add("18");
        ArrayList<ArrayList<Object>> tValuea = new ArrayList<ArrayList<Object>>();
        tValuea.add(tValue11);
        tValuea.add(tValue21);
        tValuea.add(tValue31);
        

        ArrayList<ArrayList<ArrayList<Object>>> tValue = new ArrayList<ArrayList<ArrayList<Object>>>();
        tValue.add(tValueb);
        tValue.add(tValuea);
        
        // 表头样式
        Map<String, Short> tHeaderStyle1 = new HashMap<String, Short>();
        tHeaderStyle1.put("color", (short)10);
        tHeaderStyle1.put("weight", (short)700);
        
        Map<String, Short> tHeaderStyle2 = new HashMap<String, Short>();
        tHeaderStyle2.put("color", (short)10);
        tHeaderStyle2.put("weight", (short)700);
        
        ArrayList<Map<String, Short>> tHeaderStyle = new ArrayList<Map<String, Short>>();
        tHeaderStyle.add(tHeaderStyle1);
        tHeaderStyle.add(tHeaderStyle2);
        
        // 表数据样式
        Map<String, Short> tValueStyle1 = new HashMap<String, Short>();
        tValueStyle1.put("color", (short)32767);
        tValueStyle1.put("weight", (short)400);
        
        Map<String, Short> tValueStyle2 = new HashMap<String, Short>();
        tValueStyle2.put("color", (short)32767);
        tValueStyle2.put("weight", (short)400);
        
        ArrayList<Map<String, Short>> tValueStyle = new ArrayList<Map<String, Short>>();
        tValueStyle.add(tValueStyle1);
        tValueStyle.add(tValueStyle2);

        String filePath = "F:/demo2.xls";
        
        try {
            ExcelUtil.newInstance().exportExcel(tName, tHeader,
                    tValue, tHeaderStyle,
                    tValueStyle, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Demo().sheet();
        new Demo().sheets();

    }
}
