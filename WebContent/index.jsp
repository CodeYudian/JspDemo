<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.codeYudian.entity.Items"%>
<%@ page import="com.codeYudian.dao.ItemsDAO"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>

 <style>
     td {text-align:center}
  </style>

<title>首页</title>
</head>
<body>
<br>
	<h1 align="center">商品展示</h1>
	<br/>
	<div   class="col-lg-12 table-responsive">
	<table  class="table  table-bordered" width="100%" >
	<tr class="primary">
	<th>No</th>
	<th>Place of Origin</th>
	<th>Name</th>
	<th>Quantity</th>
	<th>Pic</th>
	<th>Price</th>
	<th></th>
	</tr >
		<%
			ItemsDAO itemsDao = new ItemsDAO();
			ArrayList<Items> list = itemsDao.getAllItems();
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Items item = new Items();
					item = list.get(i);
		%>

		<tr>
			<td><%=item.getId()%></td>
			<td><%=item.getCity()%></td>
			<td><%=item.getName()%></td>
			<td><%=item.getNumber()%></td>
			<td><img  src="images/<%=item.getPicture()%>" width="180" height="180" border="1"/></td>
			<td><%=item.getPrice()%></td>
			<td><button class="btn btn-primary">Buy it</button></td>
		</tr>
		<%
			}
			}
		%>

	</table>
	</div>
</body>
</html>