/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2015-02-19 09:49:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.sale;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class order_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \t<link href=\"../css/common_style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \t<script src=\"../js/logout.js\"></script>\n");
      out.write("  \t<script src=\"../js/jquery-2.1.3.min.js\"></script>\n");
      out.write("  \t<script src=\"../js/bootstrap/bootstrap-table.min.js\"></script>\n");
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
      out.write("\t\t\t<form class=\"form-horizontal\" action=\"order_input\">\n");
      out.write("\t\t        <div class=\"form-group ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${E_inc_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            <label class=\"col-xs-2 control-label\" for=\"inputSuccess\">発注元名</label>\n");
      out.write("\t\t            <div class=\"col-xs-10\">\n");
      out.write("\t\t            \t");
if(request.getAttribute("order_input").toString() == "input"){
      out.write("\n");
      out.write("\t\t            \t\t<input type=\"text\" id=\"inputSuccess\" class=\"form-control\" placeholder=\"（株）スグクル\" name=\"inc-name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inc_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            \t");
}else{
      out.write("\n");
      out.write("\t\t                \t<input type=\"text\" id=\"inputSuccess\" class=\"form-control\" placeholder=\"（株）スグクル\" name=\"inc-name\">\n");
      out.write("\t\t            \t");
}
      out.write("\n");
      out.write("\t\t            </div>\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t        <div class=\"form-group ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${E_inc_name_kana}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            <label class=\"col-xs-2 control-label\" for=\"inputSuccess\">フリガナ</label>\n");
      out.write("\t\t            <div class=\"col-xs-10\">\n");
      out.write("\t\t            \t");
if(request.getAttribute("order_input").toString() == "input"){
      out.write("\n");
      out.write("\t\t            \t\t<input type=\"text\" id=\"inputSuccess\" class=\"form-control\" placeholder=\"カブシキガイシャ スグクル\" name=\"inc-name-kana\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inc_name_kana}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            \t");
}else{
      out.write("\n");
      out.write("\t\t                \t<input type=\"text\" id=\"inputSuccess\" class=\"form-control\" placeholder=\"カブシキガイシャ スグクル\" name=\"inc-name-kana\">\n");
      out.write("\t\t            \t");
}
      out.write("\n");
      out.write("\t\t            </div>\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t        <div class=\"form-group ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${E_address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            <label class=\"col-xs-2 control-label\" for=\"inputSuccess\">住所</label>\n");
      out.write("\t\t            <div class=\"col-xs-10\">\n");
      out.write("\t\t            \t");
if(request.getAttribute("order_input").toString() == "input"){
      out.write("\n");
      out.write("\t\t            \t\t<input type=\"text\" id=\"inputSuccess\" class=\"form-control\" placeholder=\"東京都新宿区西新宿 1-7-3\" name=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            \t");
}else{
      out.write("\n");
      out.write("\t\t                \t<input type=\"text\" id=\"inputSuccess\" class=\"form-control\" placeholder=\"東京都新宿区西新宿 1-7-3\" name=\"address\">\n");
      out.write("\t\t            \t");
}
      out.write("\n");
      out.write("\t\t            </div>\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t        <div class=\"form-group ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${E_zipcode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("        \t\t\t<label class=\"col-xs-2 control-label\" for=\"inputSuccess\">郵便番号</label>\n");
      out.write("        \t\t\t<div class=\"col col-xs-7 col-sm-4 col-md-4\">\n");
      out.write("          \t\t\t\t");
if(request.getAttribute("order_input").toString() == "input"){
      out.write("\n");
      out.write("\t\t            \t\t<input type=\"text\" name=\"zipcode\" id=\"zipcode\" class=\"form-control\" placeholder=\"160-0023\" name=\"post-code\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zipcode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            \t");
}else{
      out.write("\n");
      out.write("\t\t                \t<input type=\"text\" name=\"zipcode\" id=\"zipcode\" class=\"form-control\" placeholder=\"160-0023\" name=\"post-code\">\n");
      out.write("\t\t            \t");
}
      out.write("\n");
      out.write("        \t\t\t</div>\t\n");
      out.write("        \t\t</div>\n");
      out.write("\t\t        <div class=\"form-group ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${E_tel_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("        \t\t\t<label class=\"col-xs-2 control-label\" for=\"inputSuccess\">電話番号</label>\n");
      out.write("        \t\t\t<div class=\"col col-xs-7 col-sm-4 col-md-4\">\n");
      out.write("        \t\t\t\t");
if(request.getAttribute("order_input").toString() == "input"){
      out.write("\n");
      out.write("\t\t            \t\t<input type=\"text\" id=\"zipcode\" class=\"form-control\" placeholder=\"03-3344-1010\" name=\"tel-code\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tel_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            \t");
}else{
      out.write("\n");
      out.write("\t\t                \t<input type=\"text\" id=\"zipcode\" class=\"form-control\" placeholder=\"03-3344-1010\" name=\"tel-code\">\n");
      out.write("\t\t            \t");
}
      out.write("\n");
      out.write("        \t\t\t</div>\t\n");
      out.write("        \t\t</div>\n");
      out.write("\t\t        <div class=\"form-group ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${E_mail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            <label class=\"col-xs-2 control-label\" for=\"inputSuccess\">メールアドレス</label>\n");
      out.write("\t\t            <div class=\"col-xs-10\">\n");
      out.write("\t\t            \t");
if(request.getAttribute("order_input").toString() == "input"){
      out.write("\n");
      out.write("\t\t            \t\t<input type=\"text\" id=\"inputSuccess\" class=\"form-control\" placeholder=\"info@sugukuru.hal.ac.jp\" name=\"mail\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t            \t");
}else{
      out.write("\n");
      out.write("\t\t                \t<input type=\"text\" id=\"inputSuccess\" class=\"form-control\" placeholder=\"info@sugukuru.hal.ac.jp\" name=\"mail\">\n");
      out.write("\t\t            \t");
}
      out.write("\n");
      out.write("\t\t            </div>\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t        <div class=\"form-group\">\n");
      out.write("\t\t        \t<label class=\"col-xs-2 control-label\" for=\"inputSuccess\"></label>\n");
      out.write("\t\t            <div class=\"col col-xs-7 col-sm-4 col-md-4\">\n");
      out.write("\t\t            \t<input type=\"hidden\" name=\"bcd\" value=\"\" />\n");
      out.write("\t\t                <button type=\"submit\" class=\"btn btn-primary\">商品入力画面へ</button>\n");
      out.write("\t\t            </div>\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t    </form>\n");
      out.write("\t\t</div><!-- /main_content -->\n");
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
