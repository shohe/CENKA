<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/cssreset-min.css" rel="stylesheet" type="text/css">
  	<link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
  	<link href="../css/bootstrap/bootstrap-table.min.css" rel="stylesheet" type="text/css">
  	<link href="../css/common_style.css" rel="stylesheet" type="text/css">
  	<script src="../js/logout.js"></script>
  	<script src="../js/jquery-2.1.3.min.js"></script>
  	<script src="../js/bootstrap/bootstrap-table.min.js"></script>
	<title>タイトル</title>
</head>
<body>
	<header><div>CENKA ADMIN - 販売部門 -</div></header>
	<div id="body_wrapper">
		<div id="side_menu">
			<ul>
				<li class="activ"><a href="index">受注リスト</a></li>
				<li><a href="order">受注入力</a></li>
				<li><a href="stock_list">在庫リスト</a></li>
				<li><a href="#">請求書・領収書発行履歴</a></li>
				<li><a href="#" onClick="logout()">ログアウト</a></li>
			</ul>
		</div><!-- /side_menu -->
		
		<div id="main_content">
			<table id="events-table" data-toggle="table" data-url="../json/data1.json" data-height="500">
			<!-- data-search="true"を付けると検索できます -->
			    <thead>
			        <tr>
			            <!-- <th data-field="state" data-checkbox="true"></th> -->
			            <a href="#"><th data-field="id" data-align="">受注ID</th></a>
			            <th data-field="name" data-align="">受注元</th>
			            <th data-field="price" data-align="">合計金額</th>
			        </tr>
			    </thead>
			</table>
			<script>
				$(function () {
					$('#events-table').bootstrapTable({
		            	
		            }).on('all.bs.table', function (e, name, args) {
		            	console.log('Event:', name, ', data:', args);
		            }).on('click-row.bs.table', function (e, row, $element) {
		                location.href = "order_list?id="+row["id"]+
        				"&name="+row["name"]+
        				"&price="+row["price"]+
        				"&date="+row["date"];
		            });
			    });
			</script>
		</div><!-- /main_content -->
	</div><!-- /body_wrapper -->
</body>
</html>