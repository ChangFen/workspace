<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>添加房产信息</h2>
		<form method="post" action="apartmentAction_add">
			<table width="400">
				<tr>
					<th align="right">小区名称：</th><td><input name="apartment.aprt_name"/><span class="span_font"></span></td>
				</tr>
				<tr>
					<th align="right">地址：</th><td><input name="apartment.addr"/></td>
				</tr>
				<tr>
					<th align="right">发布日期：</th><td><input name="apartment.pub_date"/></td>
				</tr>
				<tr>
					<th align="right">价格：</th><td><input name="apartment.price"/></td>
				</tr>
				<tr>
					<th align="right">销售电话：</th><td><input name="apartment.phone"/></td>
				</tr>				
				<tr><th colspan="2"><input type="submit" value="保存"/></th></tr>
			</table>
		</form>
	</div>
</body>
</html>