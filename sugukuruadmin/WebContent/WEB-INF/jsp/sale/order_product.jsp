<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/cssreset-min.css" rel="stylesheet" type="text/css">
  	<link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
  	<link href="../css/bootstrap/bootstrap-table.min.css" rel="stylesheet" type="text/css">
  	<link href="../css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  	<link href="../css/common_style.css" rel="stylesheet" type="text/css">
  	<link href="../css/order_product_style.css" rel="stylesheet" type="text/css">
  	<script src="../js/logout.js"></script>
  	<script src="../js/jquery-2.1.3.min.js"></script>
  	<script src="../js/bootstrap/bootstrap-table.min.js"></script>
  	<script src="../js/prototype.js"></script>
	<title>タイトル</title>
</head>
<body>
	<header><div>CENKA ADMIN - 販売部門 -</div></header>
	<div id="body_wrapper">
		<div id="side_menu">
			<ul>
				<li><a href="index">受注リスト</a></li>
				<li class="activ"><a href="order">受注入力</a></li>
				<li><a href="stock_list">在庫リスト</a></li>
				<li><a href="#">請求書・領収書発行履歴</a></li>
				<li><a href="#" onClick="logout()">ログアウト</a></li>
			</ul>
		</div><!-- /side_menu -->
		
		<div id="main_content">
			<div id="order-inc-info">
				<div class="info-info">
					<h5>${inc_name_kana}</h5>
					<h4>${inc_name}</h4>
					<h4>${address}</h4>
				</div>
				<div class="info-info">
					<h5>〒 ${zipcode}</h5>
					<h4><i class="fa fa-phone"></i> ${tel_code}</h4>
					<h4><i class="fa fa-envelope-o"></i> ${mail}</h4>
				</div>
			</div>
			<div id="order-check">
				<form action="order_product">
					<button id="order-button" type="submit" class="btn btn-primary">受注確認画面へ</button>
				</form>
			</div>
			<table id="events-table" data-toggle="table" data-url="" data-height="400">
			<!-- data-search="true"を付けると検索できます -->
			    <thead>
			        <tr>
			            <a href="#"><th data-field="no" data-align="">商品No</th></a>
			            <th data-field="name" data-align="">商品名</th>
			            <th data-field="unit_price" data-align="">単価</th>
			            <th data-field="number" data-align="">個数</th>
			            <th data-field="sub_total" data-align="">小計</th>
			        </tr>
			    </thead>
			</table>
		</div><!-- /main_content -->
		
		<script type="text/javascript">
			var key_code = "";
			document.onkeydown = function (e){
				// キーコード 
				switch(e.keyCode){
			       case 48 : key_code += "0"; break ; // 0
			       case 49 : key_code += "1"; break ; // 1
			       case 50 : key_code += "2"; break ; // 2
			       case 51 : key_code += "3"; break ; // 3
			       case 52 : key_code += "4"; break ; // 4
			       case 53 : key_code += "5"; break ; // 5
			       case 54 : key_code += "6"; break ; // 6
			       case 55 : key_code += "7"; break ; // 7
			       case 56 : key_code += "8"; break ; // 8
			       case 57 : key_code += "9"; break ; // 9
			    }
				
				// Enterキーの押下状態
				if(e.keyCode == 13){
					// バーコードパラメータ付与
					var url = location.href;
					
					if (url.search(/&bcd=/) != -1) {
						var sub = url.substring(url.search(/&bcd=/));
						url = url.replace(sub, "");
					}
					
					if (key_code.length > 0) {
						alert(key_code);
						location.href = url+"&bcd="+key_code;
						key_code = "";
					}
				}
			};
			
			
		</script>
		
	</div><!-- /body_wrapper -->
</body>
</html>