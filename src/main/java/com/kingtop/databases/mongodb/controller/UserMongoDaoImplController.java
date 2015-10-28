package com.kingtop.databases.mongodb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kingtop.databases.mongodb.dao.impl.UserMongoDaoImpl;
import com.kingtop.databases.mongodb.model.User;
import com.kingtop.databases.mongodb.util.ExcelUtil;
import com.mongodb.DBObject;

@Controller
@RequestMapping(value = "find.do")
public class UserMongoDaoImplController {

	@RequestMapping(params = "method=find")
	public void find_jsp(Model model) {
		model.addAttribute("str0121", "Hellow world");
		User user = null;
		List<User> userList = new ArrayList<User>();
		System.out.println("find.jsp");
		UserMongoDaoImpl userDao = new UserMongoDaoImpl();
		List<DBObject> records = userDao.getInstance().findAll("test");
		for (DBObject record : records) {
			System.out.println("姓名" + record.get("name").toString());
			user = new User();
			user.setUname(record.get("name").toString());
			user.setAge(record.get("age").toString());
			user.setUid(record.get("_id").toString());
			userList.add(user);
		}

		model.addAttribute("userList", userList);

	}

	/**
	 * 导出mongodb数据到excel
	 */
	@RequestMapping(params = "method=export")
	public void excel() {
		User user = null;
		List<User> userList = new ArrayList<User>();
		System.out.println("controller.export");
		UserMongoDaoImpl userDao = new UserMongoDaoImpl();
		List<DBObject> records = userDao.getInstance().findAll("test");
		for (DBObject record : records) {
			System.out.println("姓名" + record.get("name").toString());
			user = new User();
			user.setUname(record.get("name").toString());
			user.setAge(record.get("age").toString());
			user.setUid(record.get("_id").toString());
			userList.add(user);
		}
		// 表单名
		String tName = "tableOne";

		// 表头行列名
		ArrayList<String> tHeader = new ArrayList<String>();
		tHeader.add("编号");
		tHeader.add("姓名");
		// tHeader.add("性别(is Man?)");
		tHeader.add("年龄");

		// 表单数据(除表头) - 行
		ArrayList<ArrayList<Object>> tValue = new ArrayList<ArrayList<Object>>();
		for (int i = 0; i < userList.size(); i++) {
			ArrayList<Object> tValue1 = new ArrayList<Object>();
			user = (User) userList.get(i);
			String id = user.getUid();
			String name = user.getUname();
			String age = user.getAge();
			System.out.println(id + name + age);
			tValue1.add(id);
			tValue1.add(name);
			// tValue1.add(true);
			tValue1.add(age);
			tValue.add(tValue1);
		}

		// 表头样式
		Map<String, Short> tHeaderStyle = new HashMap<String, Short>();
		tHeaderStyle.put("color", (short) 10);
		tHeaderStyle.put("weight", (short) 700);

		// 表数据样式
		Map<String, Short> tValueStyle = new HashMap<String, Short>();
		tValueStyle.put("color", (short) 32767);
		tValueStyle.put("weight", (short) 400);

		String filePath = "F:/demo.xls";
		System.out.println("demo");
		try {
			ExcelUtil.newInstance().exportExcel(tName, tHeader, tValue, tHeaderStyle, tValueStyle, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
