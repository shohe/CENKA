function logout() {
  ret = confirm("ログアウトします。よろしいですか？");
  if (ret == true) {
	  location.href = "http://localhost:8080/SugukuruAdmin/login/";
  }
}