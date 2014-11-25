package jp.ac.hal.pdf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * Servlet implementation class PdfTempServlet
 */
@WebServlet("/PdfTempServlet")
public class PdfTempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfTempServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 0 PDFを返すことを知らせる
		response.setContentType("application/pdf");
		
		try {
			// 1 テンプレートを読み込む
			PdfReader reader = new PdfReader(this.getClass().getResourceAsStream("/template/bill.pdf"));
			
			// 2 入力欄の取得
			PdfStamper stamper = new PdfStamper(reader, response.getOutputStream());
			AcroFields fields = stamper.getAcroFields();
			
			// 3 値をセット
			fields.setField("name", "大谷昇平");
			
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
