<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/apartment/js/jquery-2.2.3.js"></script>
<style type="text/css">
	#body{width:800px;margin:auto ;text-align:center}
	#body table{text-align:left}
	#body table td{padding:10px;}
	.s_date{float:left;}
	.s_addlay{float:right;margin-right:20px;}
	
	#add_label,#add_layout{
		position:absolute;
		top:20%;
		left:35% ;
		width:260px ;
		background:#fff ;
		border:1px solid #22b14c ;
		text-align:center ;
		display:none ;
	}
	#add_lable div,#add_layout div{
		background:#22b14c ;
		font-size:18px ;
		padding:10px ;
		font-weight: bold;
	}
	#add_label input,#add_layout input{
		margin:10px ;
	}
</style>
</head>
<body>
	<div id="body">
	<div><h1>优家房产</h1></div>
	<form action="" id="sele_from">
	<table id="table_a" border="1" width="100%">
		
	</table>
	</form>
	<div>
		<span><input type="checkbox" id="allSelect"/><label for="allSelect">全选  </label>/  <input type="checkbox" id="rset_All"/><label for="rset_All">反选 </label> &nbsp;<a id="p_delete" href="javascript:">批量删除</a></span>
		<a href="/apartment/apartment_add.jsp" style="text-align:right">添加记录</a>
	</div>
	
	</div>
	
	<div id="add_label">
		<div>添加标签</div>
		<input id="label_name"/>
		<input id="hidden_id" type="hidden"/>
		<div><input id="add_label_div" type="button" value="添加"/></div>
	</div>
	
	<div id="add_layout">
		<div>添加户型</div>
		<input id="alyout_name"/>
		<input id="hidden_id" type="hidden"/>
		<div><input id="add_alyout_div" type="button" value="添加"/></div>
	</div>
<script type="text/javascript">
$("#allSelect").click(function(){
	if(this.checked==true){
		$("#rset_All").prop("checked",false) ;
		$(".c_aids").prop("checked",true) ;
	}else{
		$(".c_aids").prop("checked",false) ;
	}
}) ;
$("#rset_All").click(function(){
	if(this.checked==true){
		$("#allSelect").prop("checked",false) ;
		var check = $(".c_aids") ;
		for(var i=0;check.length>i;i++){
			if(check[i].checked==true){
				$(check[i]).prop("checked",false) ;
			}else{
				$(check[i]).prop("checked",true) ;
			}
		}
	}
}) ;
$("#p_delete").click(function(){
	var per = $("#sele_from").serialize() ;
	$.post("apartmentAction_delete",per,function(data){
		if(data.bl){
			loadDate() ;
			alert("删除成功！") ;
		}else{
			alert("删除失败！");
		}
	},"json") ;
}) ;

function loadDate(){
	$("#table_a tr").remove() ;
	$.post("apartmentAction_findAll","",function(data){
		$.each(data.list,function(i,v){
			var tr = "<tr>" ;
				tr+= "<td><input class='c_aids' name='aids' type='checkbox' value='"+v[0].aid+"'/></td>" ;
				tr+= "<td><div>"+v[0].aprt_name+"&nbsp;<span>主力户型: ";
				if(v[1].length>0){
					for(var j=0;j<v[1].length;j++){
						tr+= "<span>"+v[1][j]+"</span>" ;
					}
				}else{
					tr+= "暂无" ;
				}
				tr+= "</span></div>" ;
				tr+= "<div><span>"+v[0].addr+"</span><span><font>"+v[0].price+"</font>元/m</span></div>" ;
				tr+= "<div><span>";
				if(v[2].length>0){
					for(var j=0;j<v[2].length;j++){
						tr+= "<span>"+v[2][j]+"</span>" ;
					}
				}
				tr+= "</span><span class='s_phone'>"+v[0].phone+"</span></div>" ;
				tr+= "<div><span class='s_date'>发布日期："+v[0].pub_date+"</span><span class='s_addlay'><a href='javascript:showLabel(\""+v[0].aid+"\");'>添加标签</a>&nbsp;&nbsp;<a  href='javascript:showAlyout(\""+v[0].aid+"\");'>添加户型</a></span></div>" ;
				tr+= "</td>" ;
				tr+= "</tr>" ;
			$("#table_a").append(tr) ;
		}) ;
	},"json") ;
}
loadDate() ;

function showLabel(id){
	$("#add_label").css("display","block") ;
	$("#hidden_id").val(id) ;
}

$("#add_label_div").click(function(){
	var id = $("#hidden_id").val() ;
	var alyout_name = $("#label_name").val() ;
	var per = "label.label="+alyout_name+"&label.aparment.aid="+id ;
	
	$.post("labelAction_add",per,function(data){
		if(data.bl){
			loadDate() ;
			alert("添加成功！");
			$("#add_label").css("display","none") ;
		}else{
			alert("添加失败！") ;
		}
	},"json") ;
}) ;
function showAlyout(id){
	$("#add_layout").css("display","block") ;
	$("#hidden_id").val(id) ;
}

$("#add_alyout_div").click(function(){
	var id = $("#hidden_id").val() ;
	var alyout_name = $("#alyout_name").val() ;
	var per = "alyout.layout="+alyout_name+"&alyout.aparment.aid="+id ;
	
	$.post("alyoutAction_add",per,function(data){
		if(data.bl){
			loadDate() ;
			alert("添加成功！");
			$("#add_layout").css("display","none") ;
		}else{
			alert("添加失败！") ;
		}
	},"json") ;
}) ;
</script>
</body>
</html>