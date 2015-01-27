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
  	<link href="../css/order_list_style.css" rel="stylesheet" type="text/css">
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
				<li><a href="order_list">在庫リスト</a></li>
				<li><a href="#">請求書・領収書発行履歴</a></li>
				<li><a href="#" onClick="logout()">ログアウト</a></li>
			</ul>
		</div><!-- /side_menu -->
		
		<div id="main_content">
			<div id="order-inc-info">
				<h5>${date}</h5>
				<h4>${vendor}</h4>
				<h3>合計金額: ${price}</h3>
			</div>
			<div id="output-document">
				<form action="pdf">
					<input type="hidden" name="company_name" value="株式会社テスト" />
					<input type="hidden" name="zip_code" value="000-0000" />
					<input type="hidden" name="address" value="東京都西新宿" />
					<input type="hidden" name="address2" value="1-2-3" />
					<input type="hidden" name="department" value="総務部" />
					<input type="hidden" name="charge" value="経理担当" />
					<input type="hidden" name="person_name" value="てすと 太郎  様" />
					<input type="hidden" name="order" value="17839" />
					<input type="hidden" name="issue" value="2015 / 01 / 15" />
					<input type="hidden" name="item" value="項目" />
					<input type="hidden" name="goods1" value="2B鉛筆" />
					<input type="hidden" name="quantity1" value="200" />
					<input type="hidden" name="unit1" value="30" />
					<input type="hidden" name="price1" value="6,000" />
					<input type="hidden" name="subtotal" value="6,000" />
					<input type="hidden" name="tax" value="0.5%" />
					<input type="hidden" name="total" value="6,300" />
					<input type="hidden" name="note" value="なし" />
					
					<button id="output-button" type="submit" class="btn btn-primary" name="juryou" value="1">領収書発行</button>
					<button id="output-button2" type="submit" class="btn btn-primary" name="seikyu" value="1">請求書発行</button>
					<button id="output-button3" type="submit" class="btn btn-primary" name="nouhin" value="1">納品書発行</button>
				</form>
			</div>
			<table id="events-table" data-toggle="table" data-url="../json/data2.json" data-height="400">
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
	</div><!-- /body_wrapper -->
</body>
</html>