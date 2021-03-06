<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>タイトル</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/cssreset-min.css" rel="stylesheet" type="text/css">
  	<link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
  	<link href="../css/login_style.css" rel="stylesheet" type="text/css">
</head>
<body id="login_wrap">
  <div class="login_form_wrap">
    <div class="login_logo">
      <div id="login_img_wrap"><img src="../img/logo.png" alt="ロゴ"></div>
    </div>
	
	<!-- セッション切る -->
	<% session.invalidate(); %>
	
    <!-- フォーム -->
    <div class="login_form">
      <form action="login.jsp" method="POST">
        <ul>
          <li>
            <p>ユーザー名</p>
            <input class="text_form" type="text" name="id" />
          </li>
          <li>
            <p>パスワード</p>
            <input class="text_form" type="password" name="pswd" />
          </li>
          <li>
            <a href="#" id="add_user_link">新規従業員登録はこちら</a>
            <button id="login_button" type="submit" class="btn btn-primary">
              ログイン
            </button>
          </li>
        </ul>
      </form>
    </div>
  </div>
</body>
</html>