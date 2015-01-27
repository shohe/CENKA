package jp.ac.hal.tokyo.cenka.pdf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.tokyo.cenka.constant.SSCORE;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class PdfNouhinServlet
 */
@WebServlet("/PdfNouhinServlet")
public class PdfNouhinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfNouhinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session
		HttpSession session = request.getSession();

		// 0 PDFを返すことを知らせる
		response.setContentType("application/pdf");
		
		try {
			// 1 テンプレートを読み込む
			PdfReader reader = new PdfReader(this.getClass().getResourceAsStream("/pdf/hacchuDoc.pdf"));
			
			// 2 入力欄の取得
			PdfStamper stamper = new PdfStamper(reader, response.getOutputStream());
			AcroFields fields = stamper.getAcroFields();
			
			// 3 値をセット
			fields.setField("Company_name", session.getAttribute("company_name").toString());
			fields.setField("Zip_code", session.getAttribute("zip_code").toString());
			fields.setField("Address", session.getAttribute("address").toString());
			fields.setField("Address2", session.getAttribute("address2").toString());
			fields.setField("Department", session.getAttribute("department").toString());
			fields.setField("Charge", session.getAttribute("charge").toString());
			fields.setField("Parson_name", session.getAttribute("person_name").toString());
			fields.setField("fill_12", session.getAttribute("total").toString());
			fields.setField("Order", session.getAttribute("order").toString());
			fields.setField("Issue", session.getAttribute("issue").toString());
			fields.setField("Item", session.getAttribute("item").toString());
			fields.setField("Goods1", session.getAttribute("goods1").toString());
			fields.setField("Quantity1", session.getAttribute("quantity1").toString());
			fields.setField("Unit1", session.getAttribute("unit1").toString());
			fields.setField("Price1", session.getAttribute("price1").toString());
			fields.setField("Subtotal", session.getAttribute("subtotal").toString());
			fields.setField("Tax", session.getAttribute("tax").toString());
			fields.setField("Total", session.getAttribute("total").toString());
			fields.setField("Note", session.getAttribute("note").toString());
			
			// 4 変種不可に
			stamper.setFormFlattening(true);
			stamper.setFreeTextFlattening(true);
			
			// 5 閉じる
			stamper.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
