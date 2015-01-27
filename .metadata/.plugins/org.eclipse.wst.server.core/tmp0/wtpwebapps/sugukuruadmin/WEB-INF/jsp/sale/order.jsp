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
				<li><a href="index">受注リスト</a></li>
				<li class="activ"><a href="order">受注入力</a></li>
				<li><a href="stock_list">在庫リスト</a></li>
				<li><a href="#">請求書・領収書発行履歴</a></li>
				<li><a href="#" onClick="logout()">ログアウト</a></li>
			</ul>
		</div><!-- /side_menu -->
		
		<div id="main_content">
			<form class="form-horizontal" action="order_input">
		        <div class="form-group ${E_inc_name}">
		            <label class="col-xs-2 control-label" for="inputSuccess">発注元名</label>
		            <div class="col-xs-10">
		            	<%if(request.getAttribute("order_input").toString() == "input"){%>
		            		<input type="text" id="inputSuccess" class="form-control" placeholder="（株）スグクル" name="inc-name" value="${inc_name}">
		            	<%}else{%>
		                	<input type="text" id="inputSuccess" class="form-control" placeholder="（株）スグクル" name="inc-name">
		            	<%}%>
		            </div>
		        </div>
		        <div class="form-group ${E_inc_name_kana}">
		            <label class="col-xs-2 control-label" for="inputSuccess">フリガナ</label>
		            <div class="col-xs-10">
		            	<%if(request.getAttribute("order_input").toString() == "input"){%>
		            		<input type="text" id="inputSuccess" class="form-control" placeholder="カブシキガイシャ スグクル" name="inc-name-kana" value="${inc_name_kana}">
		            	<%}else{%>
		                	<input type="text" id="inputSuccess" class="form-control" placeholder="カブシキガイシャ スグクル" name="inc-name-kana">
		            	<%}%>
		            </div>
		        </div>
		        <div class="form-group ${E_address}">
		            <label class="col-xs-2 control-label" for="inputSuccess">住所</label>
		            <div class="col-xs-10">
		            	<%if(request.getAttribute("order_input").toString() == "input"){%>
		            		<input type="text" id="inputSuccess" class="form-control" placeholder="東京都新宿区西新宿 1-7-3" name="address" value="${address}">
		            	<%}else{%>
		                	<input type="text" id="inputSuccess" class="form-control" placeholder="東京都新宿区西新宿 1-7-3" name="address">
		            	<%}%>
		            </div>
		        </div>
		        <div class="form-group ${E_zipcode}">
        			<label class="col-xs-2 control-label" for="inputSuccess">郵便番号</label>
        			<div class="col col-xs-7 col-sm-4 col-md-4">
          				<%if(request.getAttribute("order_input").toString() == "input"){%>
		            		<input type="text" name="zipcode" id="zipcode" class="form-control" placeholder="160-0023" name="post-code" value="${zipcode}">
		            	<%}else{%>
		                	<input type="text" name="zipcode" id="zipcode" class="form-control" placeholder="160-0023" name="post-code">
		            	<%}%>
        			</div>	
        		</div>
		        <div class="form-group ${E_tel_code}">
        			<label class="col-xs-2 control-label" for="inputSuccess">電話番号</label>
        			<div class="col col-xs-7 col-sm-4 col-md-4">
        				<%if(request.getAttribute("order_input").toString() == "input"){%>
		            		<input type="text" id="zipcode" class="form-control" placeholder="03-3344-1010" name="tel-code" value="${tel_code}">
		            	<%}else{%>
		                	<input type="text" id="zipcode" class="form-control" placeholder="03-3344-1010" name="tel-code">
		            	<%}%>
        			</div>	
        		</div>
		        <div class="form-group ${E_mail}">
		            <label class="col-xs-2 control-label" for="inputSuccess">メールアドレス</label>
		            <div class="col-xs-10">
		            	<%if(request.getAttribute("order_input").toString() == "input"){%>
		            		<input type="text" id="inputSuccess" class="form-control" placeholder="info@sugukuru.hal.ac.jp" name="mail" value="${mail}">
		            	<%}else{%>
		                	<input type="text" id="inputSuccess" class="form-control" placeholder="info@sugukuru.hal.ac.jp" name="mail">
		            	<%}%>
		            </div>
		        </div>
		        <div class="form-group">
		        	<label class="col-xs-2 control-label" for="inputSuccess"></label>
		            <div class="col col-xs-7 col-sm-4 col-md-4">
		            	<input type="hidden" name="bcd" value="" />
		                <button type="submit" class="btn btn-primary">商品入力画面へ</button>
		            </div>
		        </div>
		    </form>
		</div><!-- /main_content -->
	</div><!-- /body_wrapper -->
</body>
</html>