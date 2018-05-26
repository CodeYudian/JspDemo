<%@page import="com.codeYudian.entity.Items"%>
<%@page import="com.codeYudian.dao.ItemsDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="resource/css/bootstrap.min.css">

<title>Detail</title>
</head>
<body>
	<table class="table">
		<tr>
			<!-- 商品详情 -->
			<%
				ItemsDAO itemDao = new ItemsDAO();
				Items item = itemDao.getItemsById(Integer.parseInt(request.getParameter("id")));
				if (item != null) {
			%>
			<td width="70%" valign="top">
				<table>
					<tr>
						<td rowspan="4"><img src="images/<%=item.getPicture()%>"
							width="200" height="160" /></td>
					</tr>
					<tr>
						<td><B><%=item.getName()%></B></td>
					</tr>
					<tr>
						<td>产地：<%=item.getCity()%></td>
					</tr>
					<tr>
						<td>价格：<%=item.getPrice()%>￥
						</td>
					</tr>
				</table> <%
 	}
 %>
			
</body>
</html>
