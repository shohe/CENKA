package jp.ac.hal.tokyo.cenka.pdf;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.tokyo.cenka.beans.StockBean;
import jp.ac.hal.tokyo.cenka.beans.StockDetailsBean;
import jp.ac.hal.tokyo.cenka.beans.SupplierBean;
import jp.ac.hal.tokyo.cenka.dao.ProductsDao;
import jp.ac.hal.tokyo.cenka.dao.StockDao;
import jp.ac.hal.tokyo.cenka.dao.StockDetailsDao;
import jp.ac.hal.tokyo.cenka.dao.SupplierDao;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * Servlet implementation class Ryousyusyo
 */
@WebServlet("/Ryousyusyo")
public class Ryousyusyo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ryousyusyo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param stamper
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, PdfReader stamper) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/pdf");
		String stock_id = request.getParameter("stock_id");
		int subtotal = 0;
		int tanka = 0;
		int suuryou = 0;

		try {
			StockDao stockdao = new StockDao();
			StockDetailsDao stockdetails = new StockDetailsDao();
			SupplierDao supplierdao = new SupplierDao();
			ProductsDao productsdao = new ProductsDao();
			Calendar cal = Calendar.getInstance();
			PdfReader reader = new PdfReader(this.getClass().getResourceAsStream("/pdf/history.pdf"));
			System.out.println("1");
			PdfStamper stamper = new PdfStamper(reader,response.getOutputStream());
			AcroFields fields = stamper.getAcroFields();
			StockBean sb = new StockBean();
			SupplierBean ccb = new SupplierBean();
			System.out.println("2");
			sb = stockdao.findByStockId(stock_id);
			System.out.println("3");
			ccb = supplierdao.findByLanguageId(sb.getSupplier_id());
			System.out.println("4");
			List<StockDetailsBean> sdb = stockdetails.findByStockList(stock_id);
			System.out.println("5");

			fields.setField("Receipt_number",sb.getStock__id());//仕入ID
			fields.setField("Company_name", ccb.getSupplier_name());//企業名
			//fields.setField("Zip_code",);//郵便番号？
			fields.setField("Address", ccb.getSupplier_address());//住所
			fields.setField("Address2", "");
			fields.setField("Department", ccb.getSupplier_tel());
			fields.setField("Change", ccb.getSupplier_mail());
			//fields.setField("Person_name", ccb.getSupplier_mail());
			System.out.println("mail:"+ccb.getSupplier_mail());
			System.out.println("size:"+sdb.size());
			if(sdb.size()>=1){
				for(int i=1;i<=sdb.size();i++){
					System.out.println("i:"+i);
					System.out.println("p_id:"+sdb.get(i-1).getProdect_id());
					fields.setField("Goods" + i,productsdao.findByLanguageId(sdb.get(i-1).getProdect_id()).getProduct_name());//商品名
					suuryou = sdb.get(i-1).getStock_details_quantity();
					fields.setField("Quantity" + i, Integer.toString(suuryou));//数量
					tanka = productsdao.findByLanguageId(sdb.get(i-1).getProdect_id()).getTaax_omission_price();
					fields.setField("Unit" + i, Integer.toString(tanka));//単価
					fields.setField("Price" + i, Integer.toString(tanka*suuryou));//金額
					subtotal = subtotal + (tanka * suuryou);
				}
			}
			fields.setField("Subtotal", Integer.toString(subtotal));//小計
			fields.setField("Tax", "8%");//消費税
			fields.setField("Total", Integer.toString((int) (subtotal*1.08)));//合計金額
			fields.setField("Overall_price", Integer.toString((int) (subtotal*1.08)));//総合計金額
			fields.setField("Note", "");//備考
			stamper.setFormFlattening(true);
			stamper.setFreeTextFlattening(true);

			stamper.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NamingException e){
			e.printStackTrace();
		}
	}
}