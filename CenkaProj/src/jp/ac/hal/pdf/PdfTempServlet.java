package jp.ac.hal.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.cenka.BillsBeans;
import jp.ac.hal.cenka.Dao;
import jp.ac.hal.cenka.EstimatesBeans;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfCopyFields;
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB Connection
		Dao dao = null;
		ArrayList<BillsBeans> billsArray = new ArrayList<BillsBeans>();
		ArrayList<EstimatesBeans> estimatesArray = new ArrayList<EstimatesBeans>();

		try {
			dao = new Dao();
			billsArray = dao.findByBillsIdBills(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 0 PDFを返すことを知らせる
		response.setContentType("application/pdf");
		
		try {
			dao = new Dao();
			BillsBeans billsBeans = billsArray.get(0);
			
			// 1 テンプレートを読み込む
			PdfReader reader = new PdfReader(this.getClass().getResourceAsStream("/template/bill.pdf"));
			
			// 2 入力欄の取得
			PdfStamper stamper = new PdfStamper(reader, response.getOutputStream());
			AcroFields fields = stamper.getAcroFields();
			
			// 3 値をセット
			double tax = 1.08;
			fields.setField("name", billsBeans.getName());
			fields.setField("term", billsBeans.getTerm());
			fields.setField("place", billsBeans.getPlace());
			fields.setField("system", billsBeans.getSystem());
			fields.setField("available", billsBeans.getAvailable());
			fields.setField("charge", billsBeans.getCharge());
			fields.setField("tel", Integer.toString(billsBeans.getTel()));
			fields.setField("fax", Integer.toString(billsBeans.getFax()));
			
			estimatesArray = dao.findByBillsIdEstimates(billsBeans.getBill_id());
			int i = 1;
			int total = 0;
			for (EstimatesBeans estimatesBeans : estimatesArray) {
				int num = estimatesBeans.getNum();
				int cost = estimatesBeans.getCost();
				fields.setField("item_"+i, estimatesBeans.getItem());
				fields.setField("num_"+i, Integer.toString(num));
				fields.setField("cost_"+i, Integer.toString(cost));
				fields.setField("price_"+i, Integer.toString(num*cost));
				fields.setField("taxPrice_"+i, Double.toString((num*cost)*tax));
				i++;
				total += num*cost*tax;
			}
			fields.setField("total", "¥ "+Integer.toString(total));
			BigDecimal _tax = new BigDecimal((tax-1)*100);
			_tax.setScale(0, BigDecimal.ROUND_DOWN);
			fields.setField("taxRate", Integer.toString(_tax.intValue())+" %");
			BigDecimal amounstTax = new BigDecimal(total*tax);
			amounstTax.setScale(0, BigDecimal.ROUND_DOWN);
			fields.setField("amountTax", "¥ "+Integer.toString(amounstTax.intValue()));
			
			// 4 変種不可に
			stamper.setFormFlattening(true);
			stamper.setFreeTextFlattening(true);
			
			// 5 閉じる
			stamper.close();
			dao.close();
			
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
