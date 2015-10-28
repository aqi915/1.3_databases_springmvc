<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form action="find.do">
		<input type="submit" value="find" name="method"></input>
		<c:out value="${str0121}"></c:out>

		<table border="1" name="ta_name" value="表名">
			<thead>
				<tr>
					<th name="th_ygh" value="员工号">员工号</th>
					<th name="th_xm" value="姓名">姓名</th>
					<th name="th_nl" value="年龄">年龄</th>
					<th name="th_cz" >操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="userList">
					<tr>
						<td class="center">${userList.uid}</td>
						<td class="center">${userList.uname}</td>
						<td class="center">${userList.age}</td>
						<td class="center"><a
							href="./JcxxbServlet?action=jcxxcxxq&jcxxbid=${jcxxb.ygh}">详情</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<input type="submit" value="export" name="method"></input>
	</form>
</body>
</html>
