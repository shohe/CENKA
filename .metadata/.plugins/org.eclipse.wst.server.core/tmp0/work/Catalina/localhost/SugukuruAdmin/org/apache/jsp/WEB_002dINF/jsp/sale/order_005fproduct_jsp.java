/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2015-01-21 03:35:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.sale;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class order_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<link href=\"../css/cssreset-min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \t<link href=\"../css/bootstrap/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \t<link href=\"../css/bootstrap/bootstrap-table.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \t<link href=\"../css/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \t<link href=\"../css/common_style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \t<link href=\"../css/order_product_style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \t<script src=\"../js/logout.js\"></script>\n");
      out.write("  \t<script src=\"../js/jquery-2.1.3.min.js\"></script>\n");
      out.write("  \t<script src=\"../js/bootstrap/bootstrap-table.min.js\"></script>\n");
      out.write("  \t<script src=\"../js/prototype.js\"></script>\n");
      out.write("\t<title>タイトル</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<header><div>CENKA ADMIN - 販売部門 -</div></header>\n");
      out.write("\t<div id=\"body_wrapper\">\n");
      out.write("\t\t<div id=\"side_menu\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"index\">受注リスト</a></li>\n");
      out.write("\t\t\t\t<li class=\"activ\"><a href=\"order\">受注入力</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"stock_list\">在庫リスト</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">請求書・領収書発行履歴</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\" onClick=\"logout()\">ログアウト</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div><!-- /side_menu -->\n");
      out.write("\t\t\n");
      out.write("\t\t<div id=\"main_content\">\n");
      out.write("\t\t\t<div id=\"order-inc-info\">\n");
      out.write("\t\t\t\t<div class=\"info-info\">\n");
      out.write("\t\t\t\t\t<h5>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inc_name_kana}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h5>\n");
      out.write("\t\t\t\t\t<h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inc_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h4>\n");
      out.write("\t\t\t\t\t<h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h4>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"info-info\">\n");
      out.write("\t\t\t\t\t<h5>〒 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zipcode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h5>\n");
      out.write("\t\t\t\t\t<h4><i class=\"fa fa-phone\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tel_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h4>\n");
      out.write("\t\t\t\t\t<h4><i class=\"fa fa-envelope-o\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h4>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"order-check\">\n");
      out.write("\t\t\t\t<form action=\"order_product\">\n");
      out.write("\t\t\t\t\t<button id=\"order-button\" type=\"submit\" class=\"btn btn-primary\">受注確認画面へ</button>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<table id=\"events-table\" data-toggle=\"table\" data-url=\"\" data-height=\"400\">\n");
      out.write("\t\t\t<!-- data-search=\"true\"を付けると検索できます -->\n");
      out.write("\t\t\t    <thead>\n");
      out.write("\t\t\t        <tr>\n");
      out.write("\t\t\t            <a href=\"#\"><th data-field=\"no\" data-align=\"\">商品No</th></a>\n");
      out.write("\t\t\t            <th data-field=\"name\" data-align=\"\">商品名</th>\n");
      out.write("\t\t\t            <th data-field=\"unit_price\" data-align=\"\">単価</th>\n");
      out.write("\t\t\t            <th data-field=\"number\" data-align=\"\">個数</th>\n");
      out.write("\t\t\t            <th data-field=\"sub_total\" data-align=\"\">小計</th>\n");
      out.write("\t\t\t        </tr>\n");
      out.write("\t\t\t    </thead>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</div><!-- /main_content -->\n");
      out.write("\t\t\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("\t\t\tvar key_code = \"\";\n");
      out.write("\t\t\tdocument.onkeydown = function (e){\n");
      out.write("\t\t\t\t// キーコード \n");
      out.write("\t\t\t\tswitch(e.keyCode){\n");
      out.write("\t\t\t       case 48 : key_code += \"0\"; break ; // 0\n");
      out.write("\t\t\t       case 49 : key_code += \"1\"; break ; // 1\n");
      out.write("\t\t\t       case 50 : key_code += \"2\"; break ; // 2\n");
      out.write("\t\t\t       case 51 : key_code += \"3\"; break ; // 3\n");
      out.write("\t\t\t       case 52 : key_code += \"4\"; break ; // 4\n");
      out.write("\t\t\t       case 53 : key_code += \"5\"; break ; // 5\n");
      out.write("\t\t\t       case 54 : key_code += \"6\"; break ; // 6\n");
      out.write("\t\t\t       case 55 : key_code += \"7\"; break ; // 7\n");
      out.write("\t\t\t       case 56 : key_code += \"8\"; break ; // 8\n");
      out.write("\t\t\t       case 57 : key_code += \"9\"; break ; // 9\n");
      out.write("\t\t\t    }\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t// Enterキーの押下状態\n");
      out.write("\t\t\t\tif(e.keyCode == 13){\n");
      out.write("\t\t\t\t\t// バーコードパラメータ付与\n");
      out.write("\t\t\t\t\tvar url = location.href;\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\tif (url.search(/&bcd=/) != -1) {\n");
      out.write("\t\t\t\t\t\tvar sub = url.substring(url.search(/&bcd=/));\n");
      out.write("\t\t\t\t\t\turl = url.replace(sub, \"\");\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\tif (key_code.length > 0) {\n");
      out.write("\t\t\t\t\t\tlocation.href = url+\"&bcd=\"+key_code;\n");
      out.write("\t\t\t\t\t\tkey_code = \"\";\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t};\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t</script>\n");
      out.write("\t\t\n");
      out.write("\t</div><!-- /body_wrapper -->\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}