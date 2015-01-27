package jp.ac.hal.tokyo.cenka.constant;

public class SSCORE {
	// インスタンス生成を抑止
	private SSCORE(){}
	
	// 定数
	public static final String LOGIN_CONTROLLER = "http://localhost:8080/SugukuruAdmin/login/";
	public static final String LOGIN_JSP = "/WEB-INF/jsp/login/login.jsp";
	
	public static final String SALE_CONTROLLER = "http://localhost:8080/SugukuruAdmin/sale/";
	public static final String SALE_INDEX_JSP = "/WEB-INF/jsp/sale/index.jsp";
	public static final String SALE_ORDER_LIST_JSP = "/WEB-INF/jsp/sale/order_list.jsp";
	public static final String SALE_ORDER_PRODUCT_JSP = "/WEB-INF/jsp/sale/order_product.jsp";
	public static final String SALE_ORDER_JSP = "/WEB-INF/jsp/sale/order.jsp";
	public static final String SALE_STOCK_LIST_JSP = "/WEB-INF/jsp/sale/stock_list.jsp";
	
	public static final String PDF_NOUHIN_SERVLET = "../PdfNouhinServlet";
	
//	public static final String BARCODE_JSON_FILE_PATH = getServletContext().getRealPath("/json/bcd.json");
}
